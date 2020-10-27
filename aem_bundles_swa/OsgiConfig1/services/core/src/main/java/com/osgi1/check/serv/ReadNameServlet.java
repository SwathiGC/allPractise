package com.osgi1.check.serv;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

import com.osgi1.check.config.CheckNameConfig;

//import com.forms.learn.core.config.NameResourceConfig;

@Designate(ocd = CheckNameConfig.class,factory=true)
@Component(
    immediate = true,
    service  = Servlet.class,
    property = {
    		"sling.servlet.paths="+ "/bin/readConfigValues",
    		}
)

public class ReadNameServlet extends SlingSafeMethodsServlet{
	
	private String firstName;
	private String lastName;
	private CheckNameConfig config;
	
	
	
	@Activate
	public void activate(CheckNameConfig config) {
		this.config=config;
		this.firstName=config.getFirstName();
		this.lastName=config.getLastName();
	}
	
	 @Override
	    protected void doGet(final SlingHttpServletRequest req,
	            final SlingHttpServletResponse resp) throws ServletException, IOException {
		 resp.getWriter().println("Response from Servlet"+firstName );
	 }
}
