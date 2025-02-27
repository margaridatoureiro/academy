package com.ctw.workstation.teammember.boundary;

import com.ctw.workstation.teammember.entity.TeamMember;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public final class TeamMemberDatabase implements PanacheRepository<TeamMember> {
}