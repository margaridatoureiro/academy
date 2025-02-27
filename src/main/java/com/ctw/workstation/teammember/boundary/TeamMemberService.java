package com.ctw.workstation.teammember.boundary;

import com.ctw.workstation.teammember.entity.TeamMember;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class TeamMemberService {

    @Inject
    TeamMemberDatabase database;

    @Transactional
    public TeamMember createTeamMember(TeamMember newTeamMember) {
        database.persist(newTeamMember);
        return newTeamMember;
    }

    public TeamMember findTeamMember(Long id) {
        return database.findById(id);
    }

    public List<TeamMember> getAllTeamMembers() {
        return database.listAll();
    }

    @Transactional
    public TeamMember destroyTeamMember(Long id) {
        TeamMember team = database.findById(id);
        database.delete(team);
        return team;
    }
}

