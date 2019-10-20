package com.kaa.geostorm.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "api.geonames")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GeoNamesProperties {
    private String userName;
    private String searchUrl;
}
