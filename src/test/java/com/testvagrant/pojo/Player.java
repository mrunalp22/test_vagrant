package com.testvagrant.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    @JsonProperty("name")
    private String name;

    @JsonProperty("country")
    private String country;

    @JsonProperty("role")
    private String role;

    @JsonProperty("price-in-crores")
    private String priceInCrores;

}
