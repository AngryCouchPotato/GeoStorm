package com.kaa.geostorm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@EnableConfigurationProperties
@SpringBootApplication
public class GeoStormApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeoStormApplication.class, args);
    }
}
