import java.util.Dictionary;
import java.util.*;


public class Api{
/*	public static String MyGETRequest() throws IOException {
    URL urlForGetRequest = new URL("https://api.github.com/users/mojombo");
    String readLine = null;
    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
    conection.setRequestMethod("GET");
    int responseCode = conection.getResponseCode();
	System.out.println(responseCode);
    if (responseCode == HttpURLConnection.HTTP_OK) {
        BufferedReader in = new BufferedReader(
            new InputStreamReader(conection.getInputStream()));
        StringBuffer response = new StringBuffer();
        while ((readLine = in .readLine()) != null) {
            response.append(readLine);
        } in .close();
        // print result
        //System.out.println("JSON String Result " + response.toString());
	return "Json String Result"+response.toString(); 
       
    } else {
        //System.out.println("GET NOT WORKED");
	return "Not Worked"; 
    }
}*/
	public static void main(String[] args) throws IOException {
        //String result=Api.MyGETRequest();
        //JSONObject json = new JSONObject(result);
        //System.out.println(json.toString);
		//System.out.println(result);
      System.out.println("Check");
	Object obj1=new String("value1");
	Object obj2=new ArrayList<Integer>();
	obj2.add(1);
	obj2.add(2);

	Dictionary<String,Object> diction=new Hashtable<String, Object>();
	diction.put("frst_elem",obj1);
	diction.put("sec_elem",obj2);

	System.out.println("The value is:"+" "+diction.get(sec_elem));

   
}
}
//
Object[] src={"India",1};
String [] dest= new String[src.length];
System.arraycopy(src,0,dest,0,src.length);
System.out.println(Arrays.toString(dest));

debug mode
<input type="hidden" id="externalPath" value=${login.external_path} />
<input type="hidden" id="internalPath" value=${login.internal_path} />

var external_path=document.getElementById("externalPath").value;
var internal_path=document.getElementById("internalPath").value