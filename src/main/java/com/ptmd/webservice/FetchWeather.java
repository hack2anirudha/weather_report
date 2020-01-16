package com.ptmd.webservice;

import com.ptmd.pojo.WeatherReport;

/**
 * FetchWeather gives the declaration to web service class.
 * 
 * @author ANNI
 *
 */
public interface FetchWeather {

	/**
	 * send the web request as the url and capture the weather report 
	 * and return it.
	 * 
	 * @param url
	 * @return WeatherReport 
	 */
	public WeatherReport getWeatherReport(String url);
}
