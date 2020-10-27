package com.tech.dcj;

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
public class ReadOsgiConfigInfo {

 

    /**
     * The constant log.
     */
    private static final Logger log = LoggerFactory.getLogger(ReadOsgiConfigInfo.class);

 

    @OSGiService
    private ConfigurationAdmin configAdmin;

 

    private String externalPath;
    private String justicePath;
    private String facsPath;

 

    @PostConstruct
    private void init() {
        Configuration configurationExternal = null;
        Configuration configurationJustice = null;
        Configuration configurationFacs = null;
        try {
            Configuration[] configurations = configAdmin
                    .listConfigurations("(service.factoryPid=com.adobe.granite.auth.saml.SamlAuthenticationHandler)");
            for(int i=0; i < configurations.length ; i++) {
                String pid = configurations[i].getPid();
                if(pid.equalsIgnoreCase(Constants.SAML_EXTERNAL_CONFIGURATION_PID)) {
                    configurationExternal = configurations[i];
                } else if(pid.equalsIgnoreCase(Constants.SAML_JUSTICE_CONFIGURATION_PID)) {
                    configurationJustice = configurations[i];
                } else if(pid.equalsIgnoreCase(Constants.SAML_FACS_CONFIGURATION_PID)) {
                    configurationFacs = configurations[i];
                }
            }
            
                Dictionary<String, Object> externalProperties = configurationExternal.getProperties();
                if (!(externalProperties.isEmpty())) {
                    Object[] exterPath = (Object[]) externalProperties.get("path");
                    if (null != exterPath) {
                        String[] external = Arrays.asList(exterPath).toArray(new String[0]);
                        externalPath = external[0];
                    }
                }
                log.info("SAML External Path: {}", externalPath);

 

                Dictionary<String, Object> justiceProperties = configurationJustice.getProperties();
                if (!(justiceProperties.isEmpty())) {
                    Object[] justPath = (Object[]) justiceProperties.get("path");
                    if (null != justPath) {
                        String[] justice = Arrays.asList(justPath).toArray(new String[0]);
                        justicePath = justice[0];
                    }
                }
                log.info("SAML Justice Path: {}", justicePath);

 

                Dictionary<String, Object> facsProperties = configurationFacs.getProperties();
                if (!(facsProperties.isEmpty())) {
                    Object[] facPath = (Object[]) facsProperties.get("path");
                    if (null != facPath) {
                        String[] facs = Arrays.asList(facPath).toArray(new String[0]);
                        facsPath = facs[0];
                    }
                }
                log.info("SAML Facs Path: {}", facsPath);
            
        } catch (IOException e) {
            log.error("Error found while getting SAML configuration", e);
        } catch (InvalidSyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

 

    public String getExternalPath() {
        return externalPath;
    }

 

    public String getJusticePath() {
        return justicePath;
    }

 

    public String getFacsPath() {
        return facsPath;
    }
}