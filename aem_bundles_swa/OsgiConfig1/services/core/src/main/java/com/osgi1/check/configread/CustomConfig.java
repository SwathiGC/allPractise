package com.osgi1.check.configread;


import java.io.IOException;
import java.util.Arrays;
import java.util.Dictionary;

 

import javax.annotation.PostConstruct;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

 



 

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CustomConfig {

 

    /**
     * The constant log.
     */
    private static final Logger log = LoggerFactory.getLogger(CustomConfig.class);

 

    @OSGiService
    private ConfigurationAdmin configAdmin;

 

    private String customValue;
    /*private String justicePath;
    private String facsPath;*/
    @PostConstruct
    private void init() {
        Configuration configurationCustom = null;
       /* Configuration configurationJustice = null;
        Configuration configurationFacs = null;
*/
        try {

           

            Configuration[] configurations = configAdmin
            .listConfigurations("(service.factoryPid=com.tech.custom.impl.NamesImpl)");
            for(int i=0; i < configurations.length ; i++) {
                String pid = configurations[i].getPid();
                if(null != pid){
                    if(pid.equalsIgnoreCase("com.tech.custom.impl.NamesImpl.12368846-f668-4562-aaac-6954651d5a11")) {
                        configurationCustom = configurations[i];
                        customValue=externalPathValue(configurationCustom);
                    }
                }
            }
        }catch (IOException e) {
                log.error("Error found while getting SAML configuration", e);
            } catch (InvalidSyntaxException e) {
            // TODO Auto-generated catch block
                e.printStackTrace();
            }

       
    }
    String custom;
    private String externalPathValue(Configuration confExternal) {
        Dictionary<String, Object> externalProperties = confExternal.getProperties();
        if (!(externalProperties.isEmpty())) {
            Object exterPath =  externalProperties.get("getLastName");
            if (null != exterPath) {
                custom = exterPath.toString();
            }
            log.info("SAML External Path: {}", custom);
            System.out.println("This is to get the value : "+custom);
            return custom;
        } else {
            log.info("SAML External Path: {}", custom);
            return null;
        }
       }
     public String getCustomValue() {
            return customValue;
        }
    }

