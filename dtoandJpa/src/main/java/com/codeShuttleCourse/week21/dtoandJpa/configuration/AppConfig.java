package com.codeShuttleCourse.week21.dtoandJpa.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;

@Configuration
public class AppConfig {

  @Bean
  public ModelMapper getModelMapper(){

      return new ModelMapper();
  }
}
