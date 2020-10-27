package osgiexample.core.serviceimpl;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Modified;
import org.apache.sling.commons.osgi.PropertiesUtil;
import osgiexample.core.services.VarService;

@Component(immediate=true, label="VARDHAN Service", description="Hello There – This is a Service component", configurationFactory = true, metatype=true)
@Service(value=VarService.class)

public class VarServiceImpl implements VarService {

/** this property is used to get input from OSGI felix console **/
@Property(description="This is Label for Varservice")
private static final String SERVICE_LABEL = "service.label";

/** this property is used to identify the exact config from config Factory services **/
@Property(description="This is Config input to test", value="Hello There – this is property value")
static final String SERVICE_VARIABLE = "service.variable";

private String serviceVariable;

/** this getData() method is used to give result to the caller **/
@Override
public String getData() {
return "Return data from Service:"+ this.serviceVariable;
}

/** this Activate method is used to initiate the variable when osgi activate status **/
@Activate
protected void activate (ComponentContext ctx) {
this.serviceVariable = PropertiesUtil.toString(ctx.getProperties().get(SERVICE_VARIABLE),SERVICE_VARIABLE);
}

/** this Modified method is used to load the variable when the osgi modified status**/
@Modified
protected void modified (ComponentContext ctx) {
this.serviceVariable = PropertiesUtil.toString(ctx.getProperties().get(SERVICE_VARIABLE),SERVICE_VARIABLE);
}
}