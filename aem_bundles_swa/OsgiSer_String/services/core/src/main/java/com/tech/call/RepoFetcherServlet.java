package com.tech.call;
import com.tech.repo.*;
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
		"sling.servlet.paths="+ "/bin/repositories",
		/*"sling.servlet.resourceType=" + "/libs/wcm/foundation/components/page" ,
		"sling.servlet.selectors="+"servlet" */
	})
public class RepoFetcherServlet extends SlingSafeMethodsServlet{
	@Reference
	Irepo repoList;

	 @Override
	 protected void doGet(final SlingHttpServletRequest req,
	 	final SlingHttpServletResponse resp)  {
	 	try{
	 		String userName=req.getParameter("u_name");
	 		//resp.getWriter().println(userName);
	 		System.out.println(userName);
	 		resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
	 		resp.getWriter().println(repoList.getRepositories(userName));
		}catch(Exception e){
		  //response.getWriter().println("In catch check for exception");
	}
	 }
	
}
