package com.ctw.workstation.teammember.dto;

import com.ctw.workstation.common.CommonData;
import com.ctw.workstation.team.entity.Team;

public class TeamMemberDto extends CommonData {
    private final String name;
    private final String ctwId;
    private final Team team;

    public String getName() { return name; }

    public String getCtwId() { return ctwId; }

    public Team getTeam() { return team;}

    public TeamMemberDto(String name, String ctwId, Team team) {
        this.name = name;
        this.ctwId = ctwId;
        this.team = team;
    }
}
