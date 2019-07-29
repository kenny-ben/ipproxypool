package com.spring.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component	
public class valueTest {
	@Value("${show.me.flowers}")
	private String flowers;
	@Value("${show.me.toy}")
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
