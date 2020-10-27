package com.osgi1.check.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Check for Names", description = "This is for Names")
public @interface CheckNameConfig{
   
	@AttributeDefinition(name = "First Name" ,description = " Enter given name")
    String getFirstName() default "Swathi";
	
	@AttributeDefinition(name = "Last Name" ,description = "Enter family name")
    String getLastName() default "GC";


    /*@AttributeDefinition(name = "Collection name")
    String getCollectionId() default "pubdev2-2017";*/

}