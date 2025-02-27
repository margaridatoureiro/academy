package com.ctw.workstation.booking.entity;

import com.ctw.workstation.common.CommonData;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.teammember.entity.TeamMember;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "T_BOOKING")
public class Booking extends CommonData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookingIdGenerator")
    @SequenceGenerator(name = "bookingIdGenerator", sequenceName = "SEQ_BOOKING_ID")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "rack_id", referencedColumnName = "id", nullable = false)
    public Rack rack;

    @ManyToOne
    @JoinColumn(name = "requester_id", referencedColumnName = "id", nullable = false)
    public TeamMember requester;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "book_from", nullable = false)
    public LocalDateTime bookFrom;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "book_to", nullable = false)
    public LocalDateTime bookTo;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    public LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "modified_at")
    public LocalDateTime modifiedAt;

    public Booking(Rack rack, TeamMember requester, LocalDateTime bookFrom, LocalDateTime bookTo) {
        this.rack = rack;
        this.requester = requester;
        this.bookFrom = bookFrom;
        this.bookTo = bookTo;
    }

    public Booking() {
    }
}