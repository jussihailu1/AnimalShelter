package org.fhict.logic;

import java.time.LocalDateTime;

public abstract class Animal extends Sellable {
    public Gender Gender;
    public Reservor ReservedBy;

    public Animal(String name, Gender gender) {
        super(name);
        Gender = gender;
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
        String reserved = "No";
        if (this.ReservedBy != null) {
            reserved = "Yes, by " + this.ReservedBy.Name;
        }
        String species = this.getClass().getSimpleName();
        return super.toString() + " | Species: " + species + " | Gender: " + this.Gender + " | Reserved: " + reserved;
    }
}
