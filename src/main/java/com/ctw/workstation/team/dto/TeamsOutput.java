package com.ctw.workstation.team.dto;

import com.ctw.workstation.team.entity.Team;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TeamsOutput {
    @JsonProperty
    private List<TeamDtoOutput> teams;

    public TeamsOutput(List<TeamDtoOutput> list) {
        this.teams = list;
    }
}
