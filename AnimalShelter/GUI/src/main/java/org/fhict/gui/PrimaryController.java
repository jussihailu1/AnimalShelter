package org.fhict.gui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.fhict.logic.Animal;
import org.fhict.logic.Gender;
import org.fhict.logic.Reservation;

public class PrimaryController {

    public ComboBox cbSpecies;
    public TextField tfAnimalName;
    public TextField tfBadHabits;
    public TextField tfReservorName;
    public ToggleGroup tgGender;
    public ListView listViewAnimals;
    Reservation reservation = new Reservation();

    @FXML
    public void initialize() {
        updateView();
    }

    public void updateView() {
        listViewAnimals.getItems().clear();
        for (Animal animal : reservation.animals) {
            listViewAnimals.getItems().add(
                    animal.toString()
            );
        }
    }

    public void addAnimal() {
        Gender gender = Gender.valueOf(
                (
                        (RadioButton) tgGender.getSelectedToggle()
                ).getText()
        );

        String name = tfAnimalName.getText();

        String selectedSpecies = cbSpecies.getSelectionModel().getSelectedItem().toString();
        String badHabits = tfBadHabits.getText();

        if (selectedSpecies.equals("Dog")) {
            reservation.newDog(name, gender);
        } else {
            reservation.newCat(name, gender, badHabits);
        }

        updateView();
    }

    public void reserveAnimal() {
        Animal animal = null;
        for (Animal a : reservation.animals) {
            if (a.toString().equals(listViewAnimals.getFocusModel().getFocusedItem())) {
                animal = a;
            }
        }

        String reservorName = tfReservorName.getText();

        if (animal != null) {
            animal.reserve(reservorName);
        }

        updateView();
    }

    @FXML
    public void goToWebshopView() throws IOException {
        App.setRoot("secondary");
    }
}
