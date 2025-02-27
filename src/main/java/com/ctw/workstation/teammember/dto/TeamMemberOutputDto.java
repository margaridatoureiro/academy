package com.ctw.workstation.teammember.dto;

import com.ctw.workstation.teammember.entity.TeamMember;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class TeamMemberOutputDto {
    @JsonProperty
    private List<TeamMember> teamMembers;

    public TeamMemberOutputDto(List<TeamMember> list) {
        this.teamMembers = list;
    }
}