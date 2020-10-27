package com.osgi1.check.model;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//SlingHttpServletRequest.class,
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ChcekInfoSling {

      Logger logger = LoggerFactory.getLogger(this.getClass());
      private String message;

        @SlingObject
        private SlingHttpServletRequest request;

        @Inject @Via("resource")
    private String firstName;
 
    @Inject  @Via("resource")
    private String lastName;
           
    @PostConstruct
    protected void init() {
         
        message = "Hello World\n";
               
        if (null != request) {
            this.message += "Request Path: "+request.getRequestPathInfo().getResourcePath()+"\n";
        }
 
        message += "First Name: "+ firstName +" \n";
        message += "Last Name: "+ lastName + "\n";
         
        logger.info("inside post construct"+message);
    }
 
    public String getMessage() {
        return message;
    }
 
    public String getFirstName() {
        return firstName;
    }
     
    public String getLastName() {
        return lastName;
    }

       /* @Inject  @Default(values="Swathi")
        private String firstName;
        
        @ValueMapValue(name = "title",via = "resource",injectionStrategy = InjectionStrategy.REQUIRED)
         private String firstName;

        
        @Inject @Default(values="GC")
        private String lastName;
        
        @Inject  @Default(values="XXXXXXXXX90")
        private String contactNo;
   
        @PostConstruct
        protected void init() {
         
        message = "Hello World\n";
       
 
        message += "First Name: "+ firstName +" \n";
        message += "Last Name: "+ lastName + "\n";
         
        //logger.info("inside post construct");
    }

         public String getFirstName() {
            return firstName;
        }

       
        public String getLastName() {
            return lastName;
       }

      public String getMessage() {
        return message;
    }
       public String getContactNo() {
            return contactNo;
       }*/
}