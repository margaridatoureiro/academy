package com.ctw.workstation;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestProfile(CwtAcademyTestProfile.class)
class HelloExtAcademyApiTest {
    @Inject
    HelloExtAcademy helloExtAcademy;

    @Test
    @DisplayName("Saying hello to external api")
    void sayHelloToExternalApi() {
        // given
        String name = "Margarida";
        // when
        String result = helloExtAcademy.sayHello(name);
        // then
        assertThat(result).isEqualTo("Hello Margarida!");
    }
}