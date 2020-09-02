import Animals.Animal;
import Animals.Dog;
import Animals.Gender;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Reservation reservation = new Reservation();

        System.out.println("Hello");
        System.out.println("");

        boolean endProgram = false;
        int choice = 0;

        do {
            System.out.println("Press 1 to add animal, press 2 to view all animals, press 3 to reserve animal, press 0 to close app.");
            choice = scanner.nextInt();
            System.out.println("");

            switch (choice) {
                case 0:
                    endProgram = true;
                    break;
                case 1:
                    addAnimal(scanner, reservation);
                    break;
                case 2:
                    viewAnimals(reservation);
                    break;
                case 3:
                    reserveAnimal(scanner, reservation);
            }

            System.out.println("");
        } while (!endProgram);
    }

    static void addAnimal(Scanner scanner, Reservation reservation) {
        System.out.println("Press 1 for dog, press 2 for cat");
        int animalType = scanner.nextInt();

        System.out.println("Press 1 for male animal, press 2 for female animal");
        Gender animalGender = scanner.nextInt() == 1 ? Gender.Male : Gender.Female;

        System.out.println("Enter the name of animal");
        String animalName = scanner.next();

        String animalBadHabits = "";

        if (animalType == 2) {
            System.out.println("Enter the animals bad habits");
            scanner.nextLine();
            animalBadHabits = scanner.nextLine();
        }


        if (animalType == 1) {
            reservation.newDog(animalName, animalGender);
        } else if (animalType == 2) {
            reservation.newCat(animalName, animalGender, animalBadHabits);
        }

        System.out.println("");
        System.out.println("New animal: " + reservation.Animals.get(reservation.Animals.size() - 1));
    }

    static void viewAnimals(Reservation reservation) {
        for (int i = 0; i < reservation.Animals.size(); i++) {
            int id = i + 1;
            System.out.println("Id: " + id + " | " + reservation.Animals.get(i));
        }
    }

    static void reserveAnimal(Scanner scanner, Reservation reservation){
        System.out.println("All animals:");
        System.out.println("");

        viewAnimals(reservation);
        System.out.println("");

        System.out.println("Choose animal to reserve by entering its id");
        int animalId = scanner.nextInt();

        System.out.println("Enter your name");
        scanner.nextLine();
        String reservatorName = scanner.nextLine();

        reservation.Animals.get(animalId - 1).reserve(reservatorName);

        System.out.println("Reserved animal: " + reservation.Animals.get(animalId - 1));

    }
}
