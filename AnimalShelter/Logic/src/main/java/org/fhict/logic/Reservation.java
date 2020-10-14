package org.fhict.logic;

import java.util.ArrayList;

public class Reservation {
    public static ArrayList<Animal> animals = new ArrayList<>();
    public static int dogsCount = 0;

    public Reservation() {
        animals.clear();
        newDog("Pieter", Gender.Male);
        newCat("Catty", Gender.Female, "Stout");
    }

    public void newCat(String name, Gender gender, String badHabits) {
        animals.add(new Cat(name, gender, badHabits));
    }

    public void newDog(String name, Gender gender) {
        animals.add(new Dog(name, gender));
        dogsCount++;
    }
}
