package com.ctw.workstation.booking.dto;

import com.ctw.workstation.common.CommonData;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.teammember.entity.TeamMember;

import java.time.LocalDateTime;

public class BookingDto extends CommonData {
    private Rack rack;
    private TeamMember requester;
    private final LocalDateTime bookFrom;
    private final LocalDateTime bookTo;

    public final Rack getRack() {
        return rack;
    }

    public final TeamMember getRequester() {
        return requester;
    }

    public final LocalDateTime getBookFrom() {
        return bookFrom;
    }

    public final LocalDateTime getBookTo() {
        return bookTo;
    }

    public final void setRack(final Rack rack) {
        this.rack = rack;
    }

    public final void setRequester(final TeamMember requester) {
        this.requester = requester;
    }

    BookingDto(Rack rack, TeamMember requester, LocalDateTime bookFrom, LocalDateTime bookTo) {
        this.rack = rack;
        this.requester = requester;
        this.bookFrom = bookFrom;
        this.bookTo = bookTo;
    }
}
