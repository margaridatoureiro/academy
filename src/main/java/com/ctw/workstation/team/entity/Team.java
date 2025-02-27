package com.ctw.workstation.team.entity;

import com.ctw.workstation.common.CommonData;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.teammember.entity.TeamMember;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "T_TEAM")
public class Team extends CommonData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teamIdGenerator")
    @SequenceGenerator(name = "teamIdGenerator", sequenceName = "SEQ_TEAM_ID")
    public Long id;

    @Column(name = "name", nullable = false)
    public String name;

    @Column(name = "product", nullable = false)
    public String product;

    @Column(name = "default_location", nullable = false)
    public String defaultLocation;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    public LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "modified_at")
    public LocalDateTime modifiedAt;

    @OneToMany(mappedBy = "team")
    @JsonIgnore
    public Set<Rack> racks;

    @OneToMany(mappedBy = "team")
    @JsonIgnore
    public Set<TeamMember> teamMembers;

    public Team(String name, String product, String defaultLocation) {
        this.name = name;
        this.product = product;
        this.defaultLocation = defaultLocation;
    }

    public Team() {
    }
}

