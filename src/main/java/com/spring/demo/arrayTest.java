package com.spring.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="show.me")
public class arrayTest {
	private String flowers;
	private String toy;
	public String getFlowers() {
		return flowers;
	}
	public void setFlowers(String flowers) {
		this.flowers = flowers;
	}
	public String getToy() {
		return toy;
	}
	public void setToy(String toy) {
		this.toy = toy;
	}
}
