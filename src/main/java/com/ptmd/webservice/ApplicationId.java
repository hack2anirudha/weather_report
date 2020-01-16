package com.ptmd.webservice;

/**
 * Application id  
 * 
 * it provide the application id for the web request 
 * 
 * @author ANNI
 *
 */
public final class ApplicationId {

	/**
	 * application id for security propose save into the class
	 */
	public static final String appId="ed3c5a41ce8bfed69d296d8ac5fcb2a0";
	
	/**
	 * Concatenate the url with the application.
	 * send the proper url which have the application id.
	 * 
	 * @param url
	 * @return url
	 */
	public static final String appendId(String url){
		return url+"&APPID="+appId;
	}
}
