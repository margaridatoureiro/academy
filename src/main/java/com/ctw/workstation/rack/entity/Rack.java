package com.ctw.workstation.rack.entity;

import com.ctw.workstation.common.CommonData;
import com.ctw.workstation.team.entity.Team;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "T_RACK")
public class Rack extends CommonData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rackIdGenerator")
    @SequenceGenerator(name = "rackIdGenerator", sequenceName = "SEQ_RACK_ID")
    public Long id;

    @Column(name = "serial_number", nullable = false)
    public String serialNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    public RackStatus status;

    @Column(name = "default_location", nullable = false)
    public String defaultLocation;

    // VERSÃO CORRETA
//    @ManyToOne
//    @JoinColumn(name = "team_id", referencedColumnName = "id", nullable = false)
//    public Team team;

    // VERSÃO TEMPORÁRIA
    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id", nullable = true)
    public Team team;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    public LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "modified_at")
    public LocalDateTime modifiedAt;

    public Rack(String serialNumber, RackStatus status, String defaultLocation, Team team) {
        this.serialNumber = serialNumber;
        this.status = status;
        this.defaultLocation = defaultLocation;
        this.team = team;
    }

    public Rack() {
    }
}
