package com.raft.servletsResponse;
//import javax.servlet.Servlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.osgi.service.component.annotations.Component;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import javax.servlet.Servlet;

@Component(
			immediate=true,
			service = Servlet.class,
			 property = {
		 			"sling.servlet.paths=" + "/bin/simpleServlet" 
				}
		)
public class MesageServlet extends SlingSafeMethodsServlet {
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {
	try{
		response.getWriter().println("Response from Servlet :)");
	}catch(Exception e){
		//response.getWriter().println("In catch check for exception");
		
	}
}}