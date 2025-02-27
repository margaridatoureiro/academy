package com.ctw.workstation.rack.boundary;

import com.ctw.workstation.rack.entity.Rack;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public final class RackDatabase implements PanacheRepository<Rack> {
}
