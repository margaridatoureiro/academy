package com.ctw.workstation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class HelloAcademyTest {

    @Test
    void test_hello_academy_with_valid_input() {
        // given
        String name = "Academy";
        HelloAcademy academy = new HelloAcademy();

        // when
        String result = academy.sayHello(name);

        // then
        assertEquals("Hello Academy", result, "Matching result from sayHello is equal to Hello Academy");
    }

    @Test
    void test_hello_academy_with_null_input() {
        // given
        HelloAcademy academy = new HelloAcademy();

        // when
        String result = academy.sayHello(null);

        // then
        assertEquals("Hello", result);
    }

    @Test
    void test_hello_academy_with_empty_string_input() {
        // given
        HelloAcademy academy = new HelloAcademy();

        // when
        String result = academy.sayHello("");

        // then
        assertEquals("Hello ", result);
    }

    @ParameterizedTest
    @NullSource
    void test_hello_academy_with_null_input(String input) {
        HelloAcademy academy = new HelloAcademy();
        // when
        String result = academy.sayHello(input);
        assertEquals("Hello", result);
    }

    @ParameterizedTest
    @EmptySource
    void test_hello_academy_with_empty_input(String input) {
        HelloAcademy academy = new HelloAcademy();
        // when
        String result = academy.sayHello(input);
        assertEquals("Hello ", result);
    }

    @Test
    void test_list_of_hellos_all_satisfy() {

        List<String> list = List.of("Hello", "Hello World");

        assertThat(list)
                .allSatisfy(text -> assertThat(text).isNotEmpty())
                .allSatisfy(text -> assertThat(text.contains("Hello"))
                );
    }

}