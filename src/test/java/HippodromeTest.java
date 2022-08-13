import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class HippodromeTest {

    @AfterEach
    void tearDown() {
    }

    @Test
    void constructorTestNull() {
        assertAll("Test constructor with argument null",
                () -> assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null)),
                () -> {
                    try {
                        Hippodrome hippodrome = new Hippodrome(null);
                    } catch (IllegalArgumentException e) {
                        assertEquals("Horses cannot be null.", e.getMessage());
                    }
                }
        );
    }

    @Test
    void constructorTestWithEmptyList() {
        assertAll("Test constructor with argument empty List",
                () -> assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>())),
                () -> {
                    try {
                        Hippodrome hippodrome = new Hippodrome(new ArrayList<>());
                    } catch (IllegalArgumentException e) {
                        assertEquals("Horses cannot be empty.", e.getMessage());
                    }
                }
        );

    }

    @Test
    void getHorses() {
        List<Horse> fillListHorses = getFillListHorses(30);
        Hippodrome hippodrome = new Hippodrome(fillListHorses);
        assertEquals(fillListHorses, hippodrome.getHorses());

    }

    List<Horse> getFillListHorses(int size) {
        Random random = new Random();
        ArrayList<Horse> horses = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            horses.add(new Horse(i + " Horse", random.nextDouble() * 10, random.nextDouble() * 10));
        }
        return horses;
    }


    @Test
    public void move() {
        List<Horse> horses = getMockFillListHorses(50);
        for (Horse hors : horses) {
            hors.move();
            Mockito.verify(hors, Mockito.times(1)).move();
        }
    }

    public List<Horse> getMockFillListHorses(int size) {
        ArrayList<Horse> horses = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            horses.add(Mockito.mock(Horse.class));
        }
        return horses;
    }

    @ParameterizedTest
    @CsvSource({
            "10, 11.0",
            "20, 21.0",
            "30, 31.0",
            "40, 41.0",
            "50, 51.0",
    })
    void getWinner(int sizeHorsesInHippodrome, double maxDistance) {
        List<Horse> fillListHorses = getFillListHorses(sizeHorsesInHippodrome);
        Horse expected = new Horse("Max", 1.0, maxDistance);
        fillListHorses.add(expected);

        Hippodrome hippodrome = new Hippodrome(fillListHorses);
        Horse actual = hippodrome.getWinner();

        assertEquals(expected, actual);

    }

}