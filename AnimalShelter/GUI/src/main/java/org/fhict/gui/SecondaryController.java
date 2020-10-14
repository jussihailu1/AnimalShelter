package org.fhict.gui;

import java.io.IOException;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.fhict.logic.Animal;
import org.fhict.logic.Product;
import org.fhict.logic.Sellable;
import org.fhict.logic.Webshop;

public class SecondaryController {

    public Webshop webshop = new Webshop();

    @FXML
    ListView lvProducts;
    @FXML
    ListView lvAnimals;
    @FXML
    ListView lvShoppingCart;
    @FXML
    TextField tfName;
    @FXML
    TextField tfPrice;
    @FXML
    Label lbTotalPrice;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    public void initialize() {
        updateView();
    }

    public void updateView() {
        lvProducts.getItems().clear();
        for (Product p : webshop.getProductsForSale()) {
            lvProducts.getItems().add(p.toString());
        }

        lvAnimals.getItems().clear();
        for (Animal a : webshop.getAnimalsForSale()) {
            lvAnimals.getItems().add(a);
        }

        lvShoppingCart.getItems().clear();
        for (Object item : webshop.getShoppingCartItems()) {
            lvShoppingCart.getItems().add(item);
        }

        lbTotalPrice.setText("€ " + String.valueOf(webshop.getTotalPrice()));
    }

    public void addProduct() {
        int price = Integer.parseInt(tfPrice.getText());
        webshop.getProductsForSale().add(new Product(tfName.getText(), price));
        updateView();
    }

    public void addAnimaltoShoppingCart() {
        Animal animal = null;
        for (Animal a : webshop.getAnimalsForSale()) {
            if (a.equals(lvAnimals.getFocusModel().getFocusedItem())) {
                animal = a;
            }
        }

        webshop.addItemToCart(animal);
        updateView();
    }

    public void addProductToShoppingCart() {
        Product product = null;
        for (Product p : webshop.getProductsForSale()) {
            if (p.toString().equals(lvProducts.getFocusModel().getFocusedItem())) {
                product = p;
            }
        }

        webshop.addItemToCart(product);
        updateView();
    }

    public void goBack() throws IOException {
        App.setRoot("primary");
    }

    public void checkout() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to checkout?");
        Optional<ButtonType> result = alert.showAndWait();
        if (!result.isPresent()) {
        } else if (result.get() == ButtonType.CANCEL) {
        }
        else if (result.get() == ButtonType.OK) {
            webshop.checkout();
            updateView();
        }
    }

}
