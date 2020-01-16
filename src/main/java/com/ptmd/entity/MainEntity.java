package com.ptmd.entity;

import lombok.Data;

@Data
public class MainEntity {

	private Double temp;
	private Double feels_like;
	private Double temp_min;
	private Double temp_max;
	private Double pressure;
	private Double humidity;
	private Double sea_level;
	private Double grnd_level;

}
