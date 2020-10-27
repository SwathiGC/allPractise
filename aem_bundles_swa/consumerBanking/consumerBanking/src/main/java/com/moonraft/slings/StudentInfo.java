package com.moonraft.slings;
import javax.inject.Inject;
import org.apache.sling.models.annotations.Default;
import javax.annotation.PostConstruct;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model; 
@Model(adaptables = {Resource.class})
public class StudentInfo { 
 
    private String message1; 
    @Inject @Default(values="mahesh")

    private String firstName;

    @Inject @Default(values="wari")
    
    private String lastName;       
    @PostConstruct
    protected void init() {
          message1 = "hi "+firstName+lastName+" How are you?";
       }
 
    public String getMessage() {
        return message1;
    }
    public String getFirstName() {
        return firstName;
    }
}
