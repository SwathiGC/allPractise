package com.raft.technology;
                    
import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Default;
import javax.annotation.PostConstruct;
//import org.apache.sling.settings.SlingSettingsService;
import javax.inject.Named;

import java.util.*;
@Model(adaptables = Resource.class)
public class HelloWorldModel{
	//@Inject
	//private SlingSettingsService settin;
	
	@Inject @Named("sling:resourceType") //@Default(values="Enter value to change")
	protected String resourType;
	
	private String message;
	
	@Inject @Default(values="Enter text")
	private String text;
	

	@PostConstruct
	protected void init(){
		message="hello";
		//message+="This is the instance: "+settin.getSlingId()+" \n";
		message+="\tResource Type is:"+resourType+"\n";
	}

	public String getMessage(){
		return message;
	}

	public String getText(){
		return text;
	}
}