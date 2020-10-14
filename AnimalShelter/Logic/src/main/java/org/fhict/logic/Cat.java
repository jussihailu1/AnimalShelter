package org.fhict.logic;

public class Cat extends Animal {
    public String badHabits;

    public Cat(String name, Gender gender, String badHabits) {
        super(name, gender);
        this.badHabits = badHabits;
        int badHabitsLength = badHabits.length();
        int price = 350 - badHabitsLength * 20;
        if (price < 35) {
            price = 35;
        }
        this.Price = price;
        this.Name = name;
    }

    @Override
    public String toString() {
        return super.toString() + " | Bad habits: " + this.badHabits.toLowerCase();
    }
}
