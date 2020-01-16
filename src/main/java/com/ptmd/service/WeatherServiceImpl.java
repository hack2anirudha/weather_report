package com.ptmd.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptmd.entity.CloudsEntity;
import com.ptmd.entity.CoordEntity;
import com.ptmd.entity.MainEntity;
import com.ptmd.entity.RainEntity;
import com.ptmd.entity.SnowEntity;
import com.ptmd.entity.SysEntity;
import com.ptmd.entity.WeatherReportEntity;
import com.ptmd.entity.WindEntity;
import com.ptmd.pojo.Clouds;
import com.ptmd.pojo.Coord;
import com.ptmd.pojo.Main;
import com.ptmd.pojo.Rain;
import com.ptmd.pojo.Snow;
import com.ptmd.pojo.Sys;
import com.ptmd.pojo.WeatherReport;
import com.ptmd.pojo.Wind;
import com.ptmd.repo.WeatherRepository;

/**
 * WeatherServiceImpl implements WeatherService all the methods of it.
 * 
 * @author ANNI
 *
 */
@Service
public class WeatherServiceImpl implements WeatherService {

	/**
	 * LOG
	 */
	private static final Logger LOG = LoggerFactory.getLogger(WeatherServiceImpl.class);

	/**
	 * inject weather repository into service.
	 */
	@Autowired
	private WeatherRepository repository;

	/**
	 * implements of the Weather Service class
	 */
	@Override
	public Integer saveWeatherReport(WeatherReport weatherReport) {
		// create an entity for convert pojo to entity
		WeatherReportEntity entity = new WeatherReportEntity();

		// convert by help of beanUtils class
		BeanUtils.copyProperties(weatherReport, entity);

		// set CoordEntity
		if (null != weatherReport.getCoord()) {
			CoordEntity coord = new CoordEntity();
			BeanUtils.copyProperties(weatherReport.getCoord(), coord);
			entity.setCoord(coord);
		}

		// set cloud
		if (null != weatherReport.getClouds()) {
			CloudsEntity clouds = new CloudsEntity();
			BeanUtils.copyProperties(weatherReport.getClouds(), clouds);
			entity.setClouds(clouds);
		}

		// set main
		if (null != weatherReport.getMain()) {
			MainEntity main = new MainEntity();
			BeanUtils.copyProperties(weatherReport.getMain(), main);
			entity.setMain(main);
		}

		// set wind entity
		if (null != weatherReport.getWind()) {
			WindEntity wind = new WindEntity();
			BeanUtils.copyProperties(weatherReport.getWind(), wind);
			entity.setWind(wind);
		}

		// set sys
		if (null != weatherReport.getSys()) {
			SysEntity sys = new SysEntity();
			BeanUtils.copyProperties(weatherReport.getSys(), sys);
			entity.setSys(sys);
		}

		// set rain
		if (null != weatherReport.getRain()) {
			RainEntity rain = new RainEntity();
			BeanUtils.copyProperties(weatherReport.getRain(), rain);
			entity.setRain(rain);
		}

		// set snow
		if (null != weatherReport.getSnow()) {
			SnowEntity snow = new SnowEntity();
			BeanUtils.copyProperties(weatherReport.getSnow(), snow);
			entity.setSnow(snow);
		}

		WeatherReportEntity save = repository.save(entity);
		if (save != null) {
			LOG.info("Weather report saved into db ::" + save);
			return 1;
		}
		LOG.error("Weather report unable to store into db.");
		return 0;
	}

	/**
	 * Retrieve all report and store into an list and return list.
	 */
	@Override
	public List<WeatherReport> retriveAllReport() {

		// create a list of report to store the retrieved report
		List<WeatherReport> reportList = new ArrayList<WeatherReport>();

		// retrieve all the record form the database.
		List<WeatherReportEntity> entityList = repository.findAll();

		// make enitity list to report list
		for (WeatherReportEntity entity : entityList) {

			WeatherReport report = new WeatherReport();
			BeanUtils.copyProperties(entity, report);

			// set Coord
			if (null != entity.getCoord()) {
				Coord coord = new Coord();
				BeanUtils.copyProperties(entity.getCoord(), coord);
				report.setCoord(coord);
			}

			// set cloud
			if (null != entity.getClouds()) {
				Clouds clouds = new Clouds();
				BeanUtils.copyProperties(entity.getClouds(), clouds);
				report.setClouds(clouds);
			}

			// set main
			if (null != entity.getMain()) {
				Main main = new Main();
				BeanUtils.copyProperties(entity.getMain(), main);
				report.setMain(main);
			}

			// set wind entity
			if (null != entity.getWind()) {
				Wind wind = new Wind();
				BeanUtils.copyProperties(entity.getWind(), wind);
				report.setWind(wind);
			}

			// set sys
			if (null != entity.getSys()) {
				Sys sys = new Sys();
				BeanUtils.copyProperties(entity.getSys(), sys);
				report.setSys(sys);
			}

			// set rain
			if (null != entity.getRain()) {
				Rain rain = new Rain();
				BeanUtils.copyProperties(entity.getRain(), rain);
				report.setRain(rain);
			}

			// set snow
			if (null != entity.getSnow()) {
				Snow snow = new Snow();
				BeanUtils.copyProperties(entity.getSnow(), snow);
				report.setSnow(snow);
			}

			LOG.info("Converted enitity to pojo report" + report);

			reportList.add(report);
		}

		return reportList;
	}

	/**
	 * get maximum temperature location area report
	 */
	@Override
	public WeatherReport getMaxTempArea() {
		List<WeatherReport> reportList = retriveAllReport();
		WeatherReport result = null;
		Double temp = Double.MIN_VALUE;
		for (WeatherReport report : reportList) {
			Double temp_max = report.getMain().getTemp_max();
			if (temp < temp_max) {
				result = report;
				temp = temp_max;
			}
		}
		LOG.info("maximum temperature area is founded. " + result);
		return result;
	}

	/**
	 * get minimum temperature location area report
	 */
	@Override
	public WeatherReport getMinTempArea() {
		List<WeatherReport> reportList = retriveAllReport();
		WeatherReport result = null;
		Double temp = Double.MAX_VALUE;
		for (WeatherReport report : reportList) {
			Double temp_min = report.getMain().getTemp_min();
			if (temp_min < temp) {
				result = report;
				temp = temp_min;
			}
		}
		LOG.info("minimum temperature area is founded. " + result);
		return result;
	}

}
