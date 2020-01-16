package com.ptmd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ptmd.controller.WeatherReportController;
import com.ptmd.pojo.Coord;
import com.ptmd.pojo.WeatherReport;

/**
 * WeatherReportApplication spring boot application
 * 
 * @author ANNI
 *
 */
@SpringBootApplication
public class WeatherReportApplication {

	/**
	 * main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(WeatherReportApplication.class, args);

		WeatherReportController weatherController = (WeatherReportController) applicationContext.getBean("controller");

		/**
		 * insert all the records into the mongo data base.
		 */
		int i = weatherController.insertAllRecord();
		System.out.println(i + " no of record saved.");

		/**
		 * find minimum temperature
		 */
		WeatherReport minTempArea = weatherController.findMinTempArea();
		System.out.println("Minimum Temperature Country ::" + minTempArea.getSys().getCountry());
		System.out.println("Minimum Temperature Location ::" + minTempArea.getName());
		System.out.println("Minimum Temperature ::" + minTempArea.getMain().getTemp_min());
		Coord mincoord = minTempArea.getCoord();
		System.out.println("Minimum Temperature Coordinate ::" + mincoord.getLat() + " " + mincoord.getLon());

		/**
		 * find maximum temperature
		 */
		WeatherReport maxTempArea = weatherController.findMaxTempArea();
		System.out.println("Maximum Temperature Country ::" + maxTempArea.getSys().getCountry());
		System.out.println("Maximum Temperature Location ::" + maxTempArea.getName());
		System.out.println("Maximum Temperature ::" + maxTempArea.getMain().getTemp_max());
		Coord maxcoord = maxTempArea.getCoord();
		System.out.println("Maximum Temperature Coordinate ::" + maxcoord.getLat() + " " + maxcoord.getLon());

	}

}
