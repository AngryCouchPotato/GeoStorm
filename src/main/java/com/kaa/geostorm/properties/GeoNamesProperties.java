package com.kaa.geostorm.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "api.geonames")
@Getter
@Setter
public class GeoNamesProperties {
    private String userName;
    private String searchUrl;
}
