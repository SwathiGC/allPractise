package com.tech.repo;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStream; 
import java.io.InputStreamReader; 
import java.io.OutputStream; 
import java.net.HttpURLConnection; 
import java.net.URL; 
import org.osgi.service.component.annotations.Component;


@Component(
	immediate = true,
	service  = Irepo.class
	)

public class IrepoImpl implements Irepo{

	@Override
	public String getRepositories(String username)
	{
		try
		{
        //https://api.github.com/users/mojombo
			URL urlForGetRequest = new URL("https://api.github.com/users/"+username+"/repos");
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
       
				return response.toString();

			} else 
			{
        
				return "Not Working"; 
			}
		}
		catch(Exception e)
		{
    	//e.printStackTrace(); 
			return "Check for the error logs" ;		
		}
	}
}