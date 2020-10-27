package com.tech.quest3;

import com.adobe.cq.sightly.WCMUsePojo;
public class FooBar extends WCMUsePojo {

	@Override
	public void activate() throws Exception{

	}

	public String getLinks(){
		return "https://www.foo'bar.com";
	}
	public String getText(){
		return "foo'bar";
	}
}