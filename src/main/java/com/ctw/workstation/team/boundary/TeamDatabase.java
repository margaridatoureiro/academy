package com.ctw.workstation.team.boundary;

import com.ctw.workstation.team.entity.Team;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public final class TeamDatabase implements PanacheRepository<Team> {
}