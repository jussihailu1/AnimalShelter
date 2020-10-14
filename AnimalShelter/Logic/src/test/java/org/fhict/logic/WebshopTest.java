package org.fhict.logic;

import junit.framework.TestCase;

import java.util.ArrayList;

public class WebshopTest extends TestCase {

    private Webshop webshop;

    public void setUp() throws Exception {
        super.setUp();
        webshop = new Webshop();
    }

    public void tearDown() throws Exception {
    }

    public void testAddItemToCart_ItemGetsAdded() {
        Product product = new Product("Borstel", 15);
        webshop.addItemToCart(product);

        assertEquals(1, webshop.getShoppingCartItems().size());
        assertEquals(product, webshop.getShoppingCartItems().get(0));
    }

    public void testAddItemToCart_TotalPriceGetsUpdated() {
        int price = 15;
        Product product = new Product("Borstel", price);
        webshop.addItemToCart(product);

        assertEquals(price, webshop.getTotalPrice());
    }

    public void testCheckout() {
        Product product = new Product("Borstel", 15);
        Dog animal = new Dog("Max", Gender.Male);
        webshop.addItemToCart(product);
        webshop.addItemToCart(animal);
        webshop.checkout();
        assertEquals(0, webshop.getTotalPrice());
        assertEquals(0, webshop.getShoppingCartItems().size());
    }
}
