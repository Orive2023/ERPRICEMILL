package com.orive.Worker.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkerConfig {

	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
}
