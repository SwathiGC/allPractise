package com.raft.repo.repo_without;
import java.io.InputStream;
import com.google.gson.JsonElement;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.*;
import java.io.*;
import java.net.HttpURLConnection; 
import java.net.URL;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = Igit.class)
public class IgitImpl implements Igit{
	public List<String> getRepositories() {
        List<String> repositoriesList = new ArrayList<String>();
        try {
            InputStream streamFromGithub = getResponseStreamFromGithub();
            JsonElement jsonElement = parseStreamToJson(streamFromGithub);
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            for (JsonElement element : jsonArray) {
                JsonObject jsonObject = element.getAsJsonObject();
                JsonElement name = jsonObject.get("name");
                repositoriesList.add(name.getAsString());
            }
        } catch (Exception e) {
            // HANDLE EXCEPTION HERE
        }
        return repositoriesList;
    }

    private JsonElement parseStreamToJson(InputStream stream) {
        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(new InputStreamReader(stream));
        return jsonElement;
    }

    private InputStream getResponseStreamFromGithub() throws IOException {
        Random random = new Random();
        int randomInt = random.nextInt(150000);
        String url = "https://api.github.com/repositories?since=" + randomInt;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        InputStream inputStream = con.getInputStream();
        return inputStream;
    }
}
