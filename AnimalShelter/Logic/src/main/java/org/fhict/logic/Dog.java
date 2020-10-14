package org.fhict.logic;

import java.time.Duration;
import java.time.LocalDateTime;

public class Dog extends Animal {
    public LocalDateTime LastWalk;

    public String needsWalk() {
        boolean needsWalk = Duration.between(LocalDateTime.now(), this.LastWalk).toDays() > 0;
        String answer = "Yes";
        if(needsWalk == false){
            answer = "No";
        }
        return answer;
    }

    public Dog(String name, Gender gender) {
        super(name, gender);
        this.LastWalk = LocalDateTime.now();
        int price = 500 - 50 * Reservation.dogsCount;
        if (price < 50) {
            price = 50;
        }
        this.Price = price;
        this.Name = name;
    }

    @Override
    public String toString() {
        return super.toString() + " | Last walk: " + this.LastWalk.toLocalDate() + " | Needs walk: " + needsWalk();
    }
}
