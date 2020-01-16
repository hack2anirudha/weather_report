package com.ptmd.service;

import java.util.List;

import com.ptmd.pojo.WeatherReport;

/**
 * WeatherService interface gives the declaration for its implementation.
 * 
 * @author ANNI
 *
 */
public interface WeatherService {

	/**
	 * save the weather report into the data base.
	 * 
	 * @param weatherReport
	 * @return integer
	 */
	public Integer saveWeatherReport(WeatherReport weatherReport);

	/**
	 * Retrieve all the records from the data base and return in a list.
	 * 
	 * @return list of weather report
	 */
	public List<WeatherReport> retriveAllReport();

	/**
	 * find out the maximum temperature area and return it.
	 * 
	 * @return maximum temperature area report
	 */
	public WeatherReport getMaxTempArea();

	/**
	 * find out the minimum temperature area and return it.
	 * 
	 * @return minimum temperature area report
	 */
	public WeatherReport getMinTempArea();
}
