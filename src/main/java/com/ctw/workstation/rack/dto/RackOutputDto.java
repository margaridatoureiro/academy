package com.ctw.workstation.rack.dto;

import com.ctw.workstation.rack.entity.Rack;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RackOutputDto {
    @JsonProperty
    private List<Rack> racks;

    public RackOutputDto(List<Rack> list) {
        this.racks = list;
    }
}
