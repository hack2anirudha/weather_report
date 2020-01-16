package com.ptmd.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ptmd.pojo.WeatherReport;

/**
 * Spring boot application test
 * 
 * @author ANNI
 *
 */
@SpringBootTest
public class WeatherServiceTest {

	/**
	 * inject the weather service for test all methods
	 */
	@Autowired
	private WeatherService service;

	/**
	 * test method for save weather report test
	 */
	@Test
	public void saveWeatherReportTest() {

		WeatherReport report = new WeatherReport();

		report.setId(5236L);
		report.setBase("rain");
		report.setCod(200);

		Integer result = service.saveWeatherReport(report);
		assertNotEquals(0, result);

	}

	/**
	 * test method for the retrieve all reports
	 */
	@Test
	public void retriveAllReportTest() {
		List<WeatherReport> retriveAllReport = service.retriveAllReport();
		for (WeatherReport re : retriveAllReport) {
			assertNotNull(re);
		}
		assertNotNull(retriveAllReport);
	}

	/**
	 * test method for the get maximum temperature area 
	 */
	@Test
	public void getMaxTempAreaTest() {
		WeatherReport maxTempArea = service.getMaxTempArea();
		assertNotNull(maxTempArea);
	}

	/**
	 * test method for the get minimum temperature area 
	 */
	@Test
	public void getMinTempAreaTest() {
		WeatherReport minTempArea = service.getMinTempArea();
		assertNotNull(minTempArea);
	}
}
