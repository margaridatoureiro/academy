package com.ctw.workstation.rack.boundary;

import com.ctw.workstation.rack.dto.RackDto;
import com.ctw.workstation.rack.entity.Rack;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
public class RackService {

//    private static final Logger log = Logger.getLogger(RackService.class);

    @Inject
    RackDatabase database;

    @Transactional
    public Rack createRack(RackDto input) {
        Rack newRack = new Rack(input.getSerialNumber(), input.getStatus(), input.getDefaultLocation(), input.getTeam());
        database.persist(newRack);
//        log.info("Rack created: " + newRack);
        return newRack;
    }

    @Transactional
    public Rack findRack(Long id) {
        return database.findById(id);
    }

    public List<Rack> getAllRacks() {
        return database.listAll();
    }

    @Transactional
    public Rack destroyRack(Long id) {
        Rack rack = database.findById(id);
        database.delete(rack);
        return rack;
    }

    @Transactional
    public Rack updateRack(Long id, RackDto input) {
        Rack existingRack = database.findById(id);
        existingRack.status = input.getStatus();
        existingRack.defaultLocation = input.getDefaultLocation();
        existingRack.team = input.getTeam();
        database.persist(existingRack);
        return existingRack;
    }

//    @Transactional
//    public List<Rack> getAllRacksByStatus(String status) {
//        return new ArrayList<>(database.getAllByStatus(status).values());
//    }
}
