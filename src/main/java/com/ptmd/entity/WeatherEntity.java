package com.ptmd.entity;

import lombok.Data;

@Data
public class WeatherEntity {
	
	private Integer id;
	private String main;
	private String description;
	private String icon;

}
