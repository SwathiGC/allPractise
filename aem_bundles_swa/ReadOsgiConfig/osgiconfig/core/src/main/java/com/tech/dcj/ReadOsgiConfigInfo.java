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
			if (null != configurations) {
				for (int i = 0; i < configurations.length; i++) {
					String pid = configurations[i].getPid();
					if (null != pid) {
						if (pid.equalsIgnoreCase(Constants.SAML_EXTERNAL_CONFIGURATION_PID)) {
							configurationExternal = configurations[i];
							externalPath = externalPathValue(configurationExternal);
						} else if (pid.equalsIgnoreCase(Constants.SAML_JUSTICE_CONFIGURATION_PID)) {
							configurationJustice = configurations[i];
							justicePath = justicePathValue(configurationJustice);
						} else if (pid.equalsIgnoreCase(Constants.SAML_FACS_CONFIGURATION_PID)) {
							configurationFacs = configurations[i];
							facsPath = facsPathValue(configurationFacs);
						}
					}
				}
			}
        } catch (IOException e) {
            log.error("Error found while getting SAML configuration", e);
        } catch (InvalidSyntaxException e) {
        	 log.error("Error found while getting SAML Factory PID", e);
        }
    }

    String[] justice;
    String[] external;
    String[] facs;

    private String justicePathValue(Configuration confJustice) {
        Dictionary<String, Object> justiceProperties = confJustice.getProperties();
        if (!(justiceProperties.isEmpty())) {
            Object[] justPath = (Object[]) justiceProperties.get("path");
            if (null != justPath) {
                justice = Arrays.asList(justPath).toArray(new String[0]);
            }
            log.info("SAML Justice Path: {}", justicePath);
            return justice[0];
        } else {
            log.info("SAML Justice Path: {}", justicePath);
            return null;
        }
    }

    private String externalPathValue(Configuration confExternal) {
        Dictionary<String, Object> externalProperties = confExternal.getProperties();
        if (!(externalProperties.isEmpty())) {
            Object[] exterPath = (Object[]) externalProperties.get("path");
            if (null != exterPath) {
                external = Arrays.asList(exterPath).toArray(new String[0]);
            }
            log.info("SAML External Path: {}", externalPath);
            return external[0];
        } else {
            log.info("SAML External Path: {}", externalPath);
            return null;
        }
    }

    private String facsPathValue(Configuration confFacs) {
        Dictionary<String, Object> facsProperties = confFacs.getProperties();
        if (!(facsProperties.isEmpty())) {
            Object[] facPath = (Object[]) facsProperties.get("path");
            if (null != facPath) {
                facs = Arrays.asList(facPath).toArray(new String[0]);
            }
            log.info("SAML Facs Path: {}", facsPath);
            return facs[0];
        } else {
            log.info("SAML Facs Path: {}", facsPath);
            return null;
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