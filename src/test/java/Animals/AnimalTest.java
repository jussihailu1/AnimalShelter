package Animals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @BeforeEach
    void setUp() {
        System.out.println("Initiating testing");

    }

    @AfterEach
    void tearDown() {
        System.out.println("Testing completed");
    }

    @Test
    void reserve() {
        System.out.println("Testing: 'reserve'");
        Animal animal = new Animal("Pieter", Gender.Male);
        String animalReserverName = "Henk";
        animal.reserve(animalReserverName);
        assertTrue(animal.ReservedBy.Name.equals(animalReserverName));
    }
}
