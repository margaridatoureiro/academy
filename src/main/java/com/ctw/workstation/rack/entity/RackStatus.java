package com.ctw.workstation.rack.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;

@JsonSubTypes.Type(RackStatus.class)
public enum RackStatus {
    AVAILABLE,
    BOOKED,
    UNAVAILABLE
}