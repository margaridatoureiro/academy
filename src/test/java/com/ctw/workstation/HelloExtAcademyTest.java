package com.ctw.workstation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class HelloExtAcademyTest {

    @Test
    @DisplayName("Say hello from outer space")
    public void sayHelloFromOuterSpace() {
        String name = "Margarida";
        // given
        HelloExtAcademy helloExtAcademy = new HelloExtAcademy();
        ExternalMessageService externalMessageServiceMock = Mockito.mock(ExternalMessageService.class);
        //helloExtAcademy.externalMessageService = externalMessageServiceMock;

        Mockito.when(externalMessageServiceMock.sayHelloFromOuterSpace()).thenReturn("Hello World from outer space");

        Mockito.when(externalMessageServiceMock.sayHelloFromOuterSpace(name)).thenReturn("Hello Margarida from outer space");

        // when
        //String result = helloExtAcademy.sayHello(null);
        // then
        //assertEquals("Hello World from outer space", result);

        // when
        //String result2 = helloExtAcademy.sayHello(name);
        // then
        //assertEquals("Hello Margarida from outer space", result2);
    }

}