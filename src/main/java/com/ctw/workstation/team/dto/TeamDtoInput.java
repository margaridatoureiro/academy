package com.ctw.workstation.team.dto;

import com.ctw.workstation.common.CommonData;

public class TeamDtoInput extends CommonData {
    private final String name;
    private final String product;
    private final String defaultLocation;

    public String getName() { return name; }

    public String getProduct() { return product; }

    public String getDefaultLocation() { return defaultLocation;}

    public TeamDtoInput(String name, String product, String defaultLocation) {
        this.name = name;
        this.product = product;
        this.defaultLocation = defaultLocation;
    }
}