package com.ctw.workstation.team.boundary;

import com.ctw.workstation.rack.boundary.RackDatabase;
import com.ctw.workstation.team.dto.TeamDtoInput;
import com.ctw.workstation.team.dto.TeamDtoOutput;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.teammember.boundary.TeamMemberDatabase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class TeamService {

    @Inject
    TeamDatabase database;

    @Inject
    TeamMemberDatabase teamMemberDatabase;

    @Inject
    RackDatabase rackDatabase;

    @Transactional
    public TeamDtoOutput createTeam(TeamDtoInput input) {
        Team team = new Team(input.getName(), input.getProduct(), input.getDefaultLocation());

//        Set<TeamMember> members = new HashSet<>();
//        Set<Rack> racks = new HashSet<>();
//
//        TeamMember defaultMember = new TeamMember("Mulan Fa", "9999-003", newTeam);
//        Rack defaultRack = new Rack("333888", RackStatus.AVAILABLE, "Asia", newTeam);
//
//        members.add(defaultMember);
//        racks.add(defaultRack);

        database.persist(team);
//        teamMemberDatabase.persist(defaultMember);
//        rackDatabase.persist(defaultRack);
//
//        newTeam.teamMembers = members;
//        newTeam.racks = racks;
        return new TeamDtoOutput(team.id, team.name, team.product,
                team.defaultLocation, team.createdAt, team.modifiedAt);
    }

    public TeamDtoOutput findTeam(Long id) {
        Team team = database.findById(id);
        return new TeamDtoOutput(team.id, team.name, team.product,
                team.defaultLocation, team.createdAt, team.modifiedAt);
    }

    public List<Team> getAllTeams() {
        return database.listAll();
    }

    @Transactional
    public TeamDtoOutput destroyTeam(Long id) {
        Team team = database.findById(id);
        TeamDtoOutput teamDtoOutput = new TeamDtoOutput(team.id, team.name,
                team.product, team.defaultLocation, team.createdAt, team.modifiedAt);
        database.delete(team);
        return teamDtoOutput;
    }
}

