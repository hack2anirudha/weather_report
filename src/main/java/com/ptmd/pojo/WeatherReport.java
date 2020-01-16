package com.ptmd.pojo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data


public class WeatherReport implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Coord coord;
	private List<Weather> weather;
	private String base;
	private Main main;
	private Long visibility;
	private Wind wind;
	private Clouds clouds;
	private Long dt;
	private Sys sys;
	private Rain rain;
	private Snow snow;
	private Long timezone;
	private String name;
	private Integer cod;
}
