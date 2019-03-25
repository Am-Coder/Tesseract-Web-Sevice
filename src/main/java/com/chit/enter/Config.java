package com.chit.enter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

@Configuration
public class Config {
	
	@Bean
	@Scope("singleton")
	public ITesseract tess() {
		return new Tesseract();
	}
}
