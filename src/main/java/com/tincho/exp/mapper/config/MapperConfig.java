package com.tincho.exp.mapper.config;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan(basePackages = {"com.tincho.exp.mapper.mappers"})
public class MapperConfig {

    @Autowired
    private List<CustomMapper> customMappers;

    @Bean
    public MapperFacade mapperFacade() {
        DefaultMapperFactory defaultMapperFactory = new DefaultMapperFactory.Builder().build();
        for (CustomMapper cm : customMappers) {
            defaultMapperFactory.registerMapper(cm);
        }
        return defaultMapperFactory.getMapperFacade();
    }
}
