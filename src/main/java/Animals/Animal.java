package Animals;

import java.time.LocalDateTime;

public class Animal {
    public String Name;
    public Gender Gender;
    public Reservor ReservedBy;

    public Animal(String name, Gender gender) {
        this.Name = name;
        this.Gender = gender;
    }

    public boolean reserve(String reservedBy) {
        if (this.ReservedBy == null) {
            this.ReservedBy = new Reservor(reservedBy, LocalDateTime.now());
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String reserved = "not reserved";
        if (this.ReservedBy != null) {
            reserved = "reserved by " + this.ReservedBy.Name;
        }
        return this.Name + ", " + this.Gender + ", " + reserved;
    }
}
