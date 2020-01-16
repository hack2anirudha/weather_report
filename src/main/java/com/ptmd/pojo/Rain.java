package com.ptmd.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Rain {
	@JsonProperty("1h")
	private Double _1h;
	@JsonProperty("3h")
	private Double _3h;
}
