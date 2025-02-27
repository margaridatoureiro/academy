package com.ctw.workstation.team.boundary;

import com.ctw.workstation.CtwAcademyResource;
import com.ctw.workstation.CwtAcademyTestProfile;
import com.ctw.workstation.team.dto.TeamDtoInput;
import com.ctw.workstation.team.dto.TeamDtoOutput;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import jakarta.inject.Inject;
import org.junit.jupiter.api.*;


import static io.restassured.RestAssured.*;

@QuarkusTest
//@QuarkusTestResource(CtwAcademyResource.class)
@TestProfile(CwtAcademyTestProfile.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TeamControllerTest {

    public static TeamDtoInput firstTeamInputDto;

    @Inject
    TeamService service;
    public static TeamDtoOutput firstTeam;

    @BeforeEach
    void setUp() {
        firstTeamInputDto = new TeamDtoInput("The penguins", "Magic egg", "North Pole");
        firstTeam = service.createTeam(firstTeamInputDto);
    }

    @Order(1)
    @Test
    @DisplayName("Fetching all teams")
    void fetchAllTeamsSuccessfully() {
        given()
                .header("Content-Type", "application/json")
                .when().get("/workstation/teams").then().statusCode(200);
    }

    @Order(2)
    @Test
    @DisplayName("Getting the details of one team successfully")
    void getsTeamDetailsSuccessfully() {
        given()
                .header("Content-Type", "application/json")
                .when().get("/workstation/teams/{id}", firstTeam.getId())
                .then()
                .statusCode(200)
                .extract().body().as(TeamDtoOutput.class);
    }

    @Order(3)
    @Test
    @DisplayName("Creating one team successfully")
    void createTeamSuccessfully() {
        TeamDtoInput exampleTeamDto = new TeamDtoInput("the monkeys", "banana", "amazon jungle");
        // TeamDtoOutput createdTeam = new TeamDtoOutput("the monkeys", "banana", "amazon jungle", LocalDateTime.now(), LocalDateTime.now());
        // ObjectMapper objectMapper = new ObjectMapper();
        // String teamAsString = objectMapper.writeValueAsString(createdTeam);
        given()
        .header("Content-Type", "application/json")
                .body(exampleTeamDto)
                .when().post("/workstation/teams")
                .then()
                    .statusCode(201)
                    .extract().body().as(TeamDtoOutput.class);
                    //.body(is(teamAsString));
    }

    @Order(4)
    @Test
    @DisplayName("Deleting one team successfully")
    void deleteTeamSuccessfully() {
        given()
        .header("Content-Type", "application/json")
                .when().delete("/workstation/teams/{id}", firstTeam.getId())
                .then()
                .statusCode(200)
                .extract().body().as(TeamDtoOutput.class);
    }

}