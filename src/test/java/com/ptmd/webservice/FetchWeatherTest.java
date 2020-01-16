package com.ptmd.webservice;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ptmd.pojo.WeatherReport;

/**
 * spring boot test class for test the FetchWeather class
 * 
 * @author ANNI
 *
 */
@SpringBootTest
public class FetchWeatherTest {

	/**
	 * FetchWeather 
	 */
	@Autowired
	private FetchWeather api;
	
	/**
	 * test method for the get weather report method.
	 * 
	 * use FetchWeather send web request and get the response.
	 */
	@Test
	public void getWeatherReportTest() {
		String url="http://api.openweathermap.org/data/2.5/weather?q=London,uk";
		WeatherReport report = api.getWeatherReport(url);
		assertNotNull(report);
	}
}
