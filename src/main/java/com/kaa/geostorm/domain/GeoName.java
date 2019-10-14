package com.kaa.geostorm.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GeoName {
    private String adminCode1;
    private int geonameId;
    private String toponymName;
    private String fcl;
    private long population;
    private long countryId;
    private String countryCode;
    private String countryName;
    private String name;
    private String fclName;
    private String fcodeName;
    private String adminName1;
    private double lng;
    private double lat;
    private String fcode;
}
