package org.fhict.logic;

import java.util.ArrayList;

public class Webshop {
    public ArrayList<Product> productsForSale = new ArrayList<>();
    public ArrayList<Animal> animalsForSale = new ArrayList<>();
    public ArrayList shoppingCartItems = new ArrayList();
    public int totalPrice = 0;

    public Webshop() {
        animalsForSale.addAll(Reservation.animals);
        productsForSale.add(new Product("Hondenvoer", 10));
        productsForSale.add(new Product("Kattenvoer", 12));
    }

    public void addItemToCart(Sellable item) {
        totalPrice += item.Price;
        shoppingCartItems.add(item);
    }

    public void checkout(){
        totalPrice = 0;
        shoppingCartItems.clear();
    }

}
