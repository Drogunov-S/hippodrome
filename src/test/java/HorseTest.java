import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;

class HorseTest {

    @Test
    void constructorTestParameter() {
        assertThrows(IllegalArgumentException.class, () ->
                new Horse(null, 2, 2.0));
    }

    @Test
    void constructorTestExceptionMassageInName() {
        try {
            new Horse(null, 2, 2.0);
        } catch (IllegalArgumentException e) {
            String message = e.getMessage();
            assertEquals("Name cannot be null.", message);
        }
    }

    @DisplayName("Test thrown IllegalArgumentException with start blank name")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t"})
    void constructorTestExceptionParameters(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Horse(name, 2, 2.0));
    }

    @DisplayName("Test massage exception IllegalArgumentException")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t"})
    void messageExceptionInConstructor(String name) {
        try {
            new Horse(name, 2, 2.4);
        } catch (IllegalArgumentException e) {
            assertEquals("Name cannot be blank.", e.getMessage());
        }
    }

    @DisplayName("Test negative parameters speed, distance and massage exception")
    @ParameterizedTest
    @ValueSource(doubles = -3.3)
    void testParametersConstructor(double negativeNumber) {
        assertAll("Test parameters",
                () -> assertThrows(IllegalArgumentException.class, () -> new Horse("Name", negativeNumber, 4)),
                () -> {
                    try {
                        new Horse("Name", negativeNumber, 4);
                    } catch (IllegalArgumentException e) {
                        assertEquals("Speed cannot be negative.", e.getMessage());
                    }
                },
                () -> assertThrows(IllegalArgumentException.class, () -> new Horse("Name", 4, negativeNumber)),
                () -> {
                    try {
                        new Horse("Name", 4, negativeNumber);
                    } catch (IllegalArgumentException e) {
                        assertEquals("Distance cannot be negative.", e.getMessage());
                    }
                }
        );
    }

    //Yes, I am know how do it with ValueSource, I am a training my english and @CsvSource
    @ParameterizedTest
    @CsvSource({
            "Pony1, 1.1, 2.2",
            "Pony2, 2.2, 3.3",
            "Pony3, 2.2, 3.3"})
    void getName(String name, double speed, double distance) {
        Horse horse = new Horse(name, speed, distance);
        assertEquals(name, horse.getName());
    }

    @ParameterizedTest
    @ValueSource(doubles = {2.3, 4.5, 6.6, 7.6, 0})
    void getSpeed(double doubleNumber) {
        Horse pony = new Horse("Pony", doubleNumber, doubleNumber / 2);
        assertEquals(doubleNumber, pony.getSpeed());
    }


    @ParameterizedTest
    @ValueSource(doubles = {2.3, 4.5, 6.6, 7.6, 0})
    void getDistance(double doubleNumber) {
        Horse pony = new Horse("Pony", doubleNumber / 2, doubleNumber);
        assertEquals(doubleNumber, pony.getDistance());
    }

    @ParameterizedTest
    @ValueSource(doubles = {2.3, 4.5, 6.6, 7.6, 0})
    void getDistanceTwoParameterInCreate(double doubleNumber) {
        Horse pony = new Horse("Pony", doubleNumber);
        assertEquals(0, pony.getDistance());
    }

    @ParameterizedTest
    @CsvSource({
            "Pony2, 2.2, 3.3",
            "Pony3, 2.3, 3.4"})
    void move(String name, double speed, double distance) {
        try (MockedStatic<Horse> mockedStatic = Mockito.mockStatic(Horse.class)) {
            mockedStatic.when(() -> Horse.getRandomDouble(anyDouble(), anyDouble())).thenReturn(1.0);
            Horse horse = new Horse(name, speed, distance);
            horse.move();
            assertEquals(distance + speed, horse.getDistance());
        }
    }


    @ParameterizedTest
    @CsvSource({
            "Pony2, 2.2, 3.3",
            "Pony3, 2.3, 3.4"
    })
    void getRandomDouble(String name, double speed, double distance) {
        try (MockedStatic<Horse> mockedStatic = Mockito.mockStatic(Horse.class)) {
            mockedStatic.when(() -> Horse.getRandomDouble(anyDouble(), anyDouble())).thenReturn(1.0);
            Horse horse = new Horse(name, speed, distance);
            horse.move();
            mockedStatic.verify(() -> Horse.getRandomDouble(eq(0.2), eq(0.9)), times(1));
        }
    }
}