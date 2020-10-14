package org.fhict.logic;

public abstract class Sellable {
    String Name = null;
    int Price = 0;

    public Sellable(String name) {
        Name = name;
    }

    public Sellable(String name, int price){
        Name = name;
        Price = price;
    }

    @Override
    public String toString() {
        return "Name: " + this.Name + " | Price: €" + Price;
    }
}
