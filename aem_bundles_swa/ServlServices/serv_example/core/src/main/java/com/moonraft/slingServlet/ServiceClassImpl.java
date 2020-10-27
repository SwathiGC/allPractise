package com.moonraft.slingservlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.Servlet;
@Component(
    immediate = true,
    service  = Servlet.class,
    property = {
        "sling.servlet.paths="+ "/bin/trainingproject/testservlet"
    }
)
public class ServiceClassImpl extends SlingSafeMethodsServlet {
    @Override
     protected void doGet(final SlingHttpServletRequest req,
            final SlingHttpServletResponse response)  {
      try{
		response.getWriter().println("Response from Servlet :)");
	}catch(Exception e){
		//response.getWriter().println("In catch check for exception");
	}
    }
}

//company-logo