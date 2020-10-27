package com.raft.tech;
import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Default;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.util.*;

@Model(adaptables = Resource.class)
public class ReadProperties{

	@Inject  @Default(values="Fac Path")
	 String pathFacs;

	@Inject @Default(values="External Path")
	private String pathExternal;

	@Inject @Default(values="Justice Path")
	private String pathJustice;

	/*@Inject @Named("path")
	private String path;

	public String getPath(){
		return path;
	}*/
	@Inject @Named("path") //@Default(values="Enter value to change")
	protected String resourType;
	


	private String pathproperty;

	@PostConstruct
	protected void init(){
		pathproperty="hello";
		//message+="This is the instance: "+settin.getSlingId()+" \n";
		pathproperty+="\t The path value is :"+resourType+"\n";
	}

	public String getPathproperty(){
		return pathproperty;
	}

	public String getPathFacs(){
		return pathFacs;
	}

	public String getPathJustice(){
		return pathJustice;
	}

	public String getPathExternal(){
		return pathExternal;
	} 
	/*@Inject @Named("sling:resourceType") //@Default(values="Enter value to change")
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
	}*/
}