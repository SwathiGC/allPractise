package com.raft.call.inter;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStream; 
import java.io.InputStreamReader; 
import java.io.OutputStream; 
import java.net.HttpURLConnection; 
import java.net.URL;
import org.apache.felix.scr.annotations.Service;
import org.apache.felix.scr.annotations.Property;
import javax.servlet.Servlet;
import org.apache.felix.scr.annotations.Component;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Modified;
import org.apache.sling.commons.osgi.PropertiesUtil;


@Component(immediate=true, label="ApiService", description="Hello There – This is a Api Service component", configurationFactory = true, metatype=true)
@Service(value=ApiSer.class)
public class ApiSerImpl implements ApiSer{
	/** this property is used to get input from OSGI felix console **/
@Property(description="This is Label for Varservice")
private static final String SERVICE_LABEL = "service.label";

/** this property is used to identify the exact config from config Factory services **/
@Property(description="This is Config input to test", value="Hello There – this is property value")
static final String SERVICE_VARIABLE ="service.variable";

private String serviceVariable;



@Override
public String myGETRequest () 
{
	try
	{
        //https://api.github.com/users/mojombo
	URL urlForGetRequest = new URL("this.serviceVariable");
    String readLine = null;
    String out_value="Fixed value trying";
    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
    conection.setRequestMethod("GET");
    int responseCode = conection.getResponseCode();
	System.out.println(responseCode);
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
		return "Json String Result"+response.toString();
       
    } else 
    {
        //System.out.println("GET NOT WORKED");
		return "Not Worked"; 
    }
	}
	catch(Exception e)
	{
    	//e.printStackTrace(); 
    	return "Check for errors";
    }
    //return out_value;
}



/** this Activate method is used to initiate the variable when osgi activate status **/
@Activate
protected void activate (ComponentContext ctx) 
{
	this.serviceVariable = PropertiesUtil.toString(ctx.getProperties().get(SERVICE_VARIABLE),SERVICE_VARIABLE);
}

/** this Modified method is used to load the variable when the osgi modified status**/
@Modified
protected void modified (ComponentContext ctx) 
{
	this.serviceVariable = PropertiesUtil.toString(ctx.getProperties().get(SERVICE_VARIABLE),SERVICE_VARIABLE);
}
}