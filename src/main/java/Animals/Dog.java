package Animals;

import java.time.Duration;
import java.time.LocalDateTime;

public class Dog extends Animal {

    public LocalDateTime LastWalk;

    public boolean needsWalk() {
        return Duration.between(LocalDateTime.now(), this.LastWalk).toDays() > 0;
    }

    public Dog(String name, Gender gender) {
        super(name, gender);
        this.LastWalk = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return super.toString() + ", last walk: " + this.LastWalk.toLocalDate();
    }
}
