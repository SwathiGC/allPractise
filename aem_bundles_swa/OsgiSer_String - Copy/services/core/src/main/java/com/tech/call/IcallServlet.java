package com.tech.call;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.Servlet;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	service  = Servlet.class,
	property = {
		"sling.servlet.paths="+ "/bin/readjson",
		/*"sling.servlet.resourceType=" + "/libs/wcm/foundation/components/page" ,
		"sling.servlet.selectors="+"servlet" */
	})
public class IcallServlet extends SlingSafeMethodsServlet {

	

	@Reference
	IcallService apiService;

	@Override
	protected void doGet(final SlingHttpServletRequest req,
		final SlingHttpServletResponse resp)  {
		try{
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().println(apiService.myGetRequest());
		}catch(Exception e){
		
	}
	}
}
