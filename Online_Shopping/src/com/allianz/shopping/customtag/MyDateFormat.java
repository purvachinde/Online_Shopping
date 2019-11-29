package com.allianz.shopping.customtag;

import java.util.Calendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyDateFormat extends TagSupport{

	
	private String  value;
	private String pattern;
	
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	public int doStartTag() throws JspException {  
	    JspWriter out=pageContext.getOut();//returns the instance of JspWriter  
	    try{  
	     out.print(value+" "+pattern);//printing date and time using JspWriter  
	    }catch(Exception e){
	    	System.out.println(e);}  
	    return SKIP_BODY;//will not evaluate the body content of the tag  
	}  
}
