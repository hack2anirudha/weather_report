package com.ptmd.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data

@Document(collection = "weather")
public class WeatherReportEntity {

	@Id
	private Long id;
	
	private CoordEntity coord;
	private List<WeatherEntity> weather;
	private String base;
	private MainEntity main;
	private Long visibility;
	private WindEntity wind;
	private CloudsEntity clouds;
	private Long dt;
	private SysEntity sys;
	private RainEntity rain;
	private SnowEntity snow;
	private Long timezone;
	private String name;
	private Integer cod;
}
