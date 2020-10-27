/*
 * package com.osgi1.check.impl;
 * 
 * import org.osgi.service.component.annotations.Activate; import
 * org.osgi.service.component.annotations.Component; import
 * org.osgi.service.component.annotations.Modified; import
 * org.osgi.service.metatype.annotations.Designate; import
 * com.osgi1.check.INames; import com.osgi1.check.config.CheckName; import
 * au.gov.nsw.justice.cxp.config.SearchConfig; import
 * au.gov.nsw.justice.cxp.service.ISearchConfigParams;
 * 
 * 
 * @Component(immediate = true, service = INames.class)
 * 
 * @Designate(ocd = CheckNameConfig.class,factory=true) public class
 * CheckNameImpl implements CheckNameConfig {
 * 
 * private String firstName;
 * 
 * private String lastName;
 * 
 * 
 * 
 * @Activate //@Modified protected void activate(CheckNameConfig config) {
 * firstName = config.getFirstName(); lastName = config.getLastName();
 * 
 * }
 * 
 * @Override public String getFirstName() { return firstName; }
 * 
 * @Override public String getLastName() { return lastName; }
 * 
 * 
 * }
 */