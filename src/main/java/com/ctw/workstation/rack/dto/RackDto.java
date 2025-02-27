package com.ctw.workstation.rack.dto;

import com.ctw.workstation.common.CommonData;
import com.ctw.workstation.rack.entity.RackStatus;
import com.ctw.workstation.team.entity.Team;
import jakarta.validation.constraints.NotNull;

public class RackDto extends CommonData {

    @NotNull(message="Serial number cannot be blank")
    private final String serialNumber;

    // VERSÃO CORRETA
    //@NotNull(message="Team Id cannot be blank")
    // private final Team team;

    // VERSÃO TEMPORÁRIA
    private final Team team;

    private RackStatus status;

    private final String defaultLocation;

    public String getSerialNumber() {
        return serialNumber;
    }

    public Team getTeam() {
        return team;
    }

    public RackStatus getStatus() {
        return status;
    }

    public String getDefaultLocation() { return defaultLocation; }

    public void setStatus(RackStatus status) {
        this.status = status;
    }

    public RackDto(String serialNumber, RackStatus status, String defaultLocation, Team team) {
        this.serialNumber = serialNumber;
        this.status = status;
        this.defaultLocation = defaultLocation;
        this.team = team;
    }
}

