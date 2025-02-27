package com.ctw.workstation.team.boundary;

import com.ctw.workstation.team.dto.TeamDtoInput;
import com.ctw.workstation.team.dto.TeamDtoOutput;
import com.ctw.workstation.team.dto.TeamsOutput;
import com.ctw.workstation.team.entity.Team;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.util.List;

@Path("/workstation/teams")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeamController {

    @Inject
    TeamService service;

    @GET
    public Response listTeams() {
        List<Team> list = service.getAllTeams();
        List<TeamDtoOutput> outputList = list.stream().map(team ->
                new TeamDtoOutput(
                        team.id, team.name, team.product, team.defaultLocation,
                        team.createdAt, team.modifiedAt)).toList();
        TeamsOutput output = new TeamsOutput(outputList);
        return Response
                .status(Response.Status.OK)
                .entity(output)
                .build();
    }


    @POST
    public Response addTeam(@RequestBody TeamDtoInput input) {
        // MDC.put("request.id", UUID.randomUUID().toString());
        TeamDtoOutput teamOutput = service.createTeam(input);
        // Log.infov("Added team with id:{0}", savedTeam.getId());
        return Response
                .status(Response.Status.CREATED)
                .entity(teamOutput)
                .build();
    }

    @GET
    @Path("/{id}")
    public Response showTeam(@PathParam("id") Long id) {
        TeamDtoOutput teamOutput = service.findTeam(id);
        return Response
                .status(Response.Status.OK)
                .entity(teamOutput)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTeam(@PathParam("id") Long id) {
        TeamDtoOutput teamDtoOutput = service.destroyTeam(id);
        return Response
                .status(Response.Status.OK)
                .entity(teamDtoOutput)
                .build();
    }

}

