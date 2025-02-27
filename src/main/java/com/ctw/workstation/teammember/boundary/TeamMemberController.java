package com.ctw.workstation.teammember.boundary;

import com.ctw.workstation.teammember.dto.TeamMemberDto;
import com.ctw.workstation.teammember.dto.TeamMemberOutputDto;
import com.ctw.workstation.teammember.entity.TeamMember;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.util.List;

@Path("/workstation/team-members")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeamMemberController {

    @Inject
    TeamMemberService service;

    @GET
    public Response listTeams() {
        List<TeamMember> list = service.getAllTeamMembers();
        TeamMemberOutputDto output = new TeamMemberOutputDto(list);
        return Response
                .status(Response.Status.OK)
                .entity(output)
                .build();
    }


    @POST
    public Response addTeam(@RequestBody TeamMemberDto input) {
        TeamMember newTeamMember = new TeamMember(input.getName(), input.getCtwId(), input.getTeam());
        TeamMember savedTeam = service.createTeamMember(newTeamMember);
        return Response
                .status(Response.Status.CREATED)
                .entity(savedTeam)
                .build();
    }

    @GET
    @Path("/{id}")
    public Response showTeamMember(@PathParam("id") Long id) {
        TeamMember teamMember = service.findTeamMember(id);
        return Response
                .status(Response.Status.OK)
                .entity(teamMember)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTeamMember(@PathParam("id") Long id) {
        TeamMember teamMember = service.destroyTeamMember(id);
        return Response
                .status(Response.Status.OK)
                .entity(teamMember)
                .build();
    }

}