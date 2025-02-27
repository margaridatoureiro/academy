package com.ctw.workstation.team.dto;

import java.time.LocalDateTime;

public class TeamDtoOutput {
    private final Long id;
    private final String name;
    private final String product;
    private final String defaultLocation;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public Long getId() { return id; }

    public String getName() { return name; }

    public String getProduct() { return product; }

    public String getDefaultLocation() { return defaultLocation;}

    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getModifiedAt() { return modifiedAt; }

    public TeamDtoOutput(Long id, String name, String product, String defaultLocation, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.name = name;
        this.product = product;
        this.defaultLocation = defaultLocation;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
