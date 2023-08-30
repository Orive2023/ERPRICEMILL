package com.orive.Mandi.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
public class MandiConfig {

	    @Bean
	    public ModelMapper modelMapperBean() {
	        return new ModelMapper();
	    }
}
