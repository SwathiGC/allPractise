package com.tech.callApi;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStream; 
import java.io.InputStreamReader; 
import java.io.OutputStream; 
import java.net.HttpURLConnection; 
import java.net.URL; 
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;



@Component(
	immediate = true,
	service  = IcallServiceApi.class
	)

public class IcallServiceImplApi implements IcallServiceApi{
	@Override
	public JSONObject myGetRequest()
	{
		try
		{
        //https://api.github.com/users/mojombo
			URL urlForGetRequest = new URL("https://api.github.com/users/mojombo");
			String readLine = null;
			String out_value="Fixed value trying";
			HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
			conection.setRequestMethod("GET");
			int responseCode = conection.getResponseCode();
			//System.out.println(responseCode);
			if (responseCode == HttpURLConnection.HTTP_OK) 
			{

				BufferedReader in = new BufferedReader(
				new InputStreamReader(conection.getInputStream()));
				StringBuffer response = new StringBuffer();
				while ((readLine = in .readLine()) != null) 
				{
					response.append(readLine);
				} 
				in .close();
        // print result
        //System.out.println("JSON String Result " + response.toString());
		//out_value="Json String Result"+response.toString(); 
				
				return new JSONObject(response.toString());

			} else 
			{
        //System.out.println("GET NOT WORKED");
				return new JSONObject("Not Working"); 
			}
		}
		catch(Exception e)
		{
    			//e.printStackTrace(); 
			return new JSONObject("Error Code:Invalid output");
		}
    //return out_value;
	}
}
