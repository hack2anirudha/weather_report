package com.ptmd.entity;

import lombok.Data;

@Data
public class SysEntity {
	private Integer type;
	private Long id;
	private Double  message;
	private String country;
	private Long sunrise;
	private Long sunset;

}
