package org.fhict.logic;

import java.util.ArrayList;

public class Webshop {
    private ArrayList<Product> productsForSale = new ArrayList<>();
    private ArrayList<Animal> animalsForSale = new ArrayList<>();
    private ArrayList<Sellable> shoppingCartItems = new ArrayList<Sellable>();
    private int totalPrice = 0;

    public ArrayList<Product> getProductsForSale() {
        return productsForSale;
    }

    public ArrayList<Animal> getAnimalsForSale() {
        return animalsForSale;
    }

    public ArrayList<Sellable> getShoppingCartItems() {
        return shoppingCartItems;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

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
