package com.ptmd.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ptmd.pojo.WeatherReport;
import com.ptmd.service.WeatherService;
import com.ptmd.util.ReadUrls;
import com.ptmd.util.RequestURLs;
import com.ptmd.webservice.FetchWeather;

/**
 * Weather Report Controller is work as a controller.
 * 
 * @author ANNI
 *
 */
@Controller("controller")
public class WeatherReportController {

	/**
	 * LOG
	 */
	private static final Logger LOG = LoggerFactory.getLogger(WeatherReportController.class);

	/**
	 * Read URLS
	 */
	@Autowired
	private ReadUrls readUrls;

	/**
	 * Weather Service
	 */
	@Autowired
	private WeatherService weatherService;

	/**
	 * Fetch Weather
	 */
	@Autowired
	private FetchWeather webWeather;

	/**
	 * insert the record into data base. read the urls by the help of ReadUrls class
	 * by sending the xml file name. and fetch the weather report for by the help of FetchWeather class.
	 * send instruction to service class to insert the weather report. 
	 * 
	 * @return no of recored saved into data base
	 */
	public int insertAllRecord() {
		int _return = 0;
		// read urls from xml file
		RequestURLs urls = readUrls.read("RequestURLs.xml");
		// get all the url form the url list
		List<String> urlList = urls.getUrl();

		// Retrieve all urls
		for (String url : urlList) {
			// get the Weather Report form the web service
			WeatherReport weatherReport = webWeather.getWeatherReport(url);

			LOG.info("Weather Report :: " + weatherReport);

			// save the report into the database
			Integer result = weatherService.saveWeatherReport(weatherReport);

			if (result > 0) {
				_return++;
			} else {
				LOG.error("Unable to store the weather report into mongo db.");
			}
		}
		return _return;
	}

	/**
	 * Find the minimum temperature area and return Weather Report
	 * 
	 * @return minimum temperature area
	 */
	public WeatherReport findMinTempArea() {
		WeatherReport area = weatherService.getMinTempArea();
		LOG.info("Find Minimum temperature area method called and result ::" + area);
		return area;

	}

	/**
	 * Find the maximum temperature area and return Weather Report
	 * 
	 * @return maximum temperature area
	 */
	public WeatherReport findMaxTempArea() {
		WeatherReport area = weatherService.getMaxTempArea();
		LOG.info("Find Minimum temperature area method called and result ::" + area);
		return area;
	}
}
