package UI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Controller;
import Model.Member;
import Model.Swimmer;

public class UserInterface {
    private Controller controller;
    private Scanner scanner;

    public UserInterface() {
        this.controller = new Controller();
        this.scanner = new Scanner(System.in);
    }

    void displayMenu() {
        System.out.println("\n---- Administration ----");
        System.out.println("[1] Register a new member to the club");
        System.out.println("[2] View the list of members");
        System.out.println("[0] Exit the program");
    }

    public void startProgram() {
        boolean running = true;
        while (running) {
            displayMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "1" -> addMember();
                case "2" -> showMembers();
                case "0" -> {
                    System.out.println("Exiting program...");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addMember() {
        System.out.println("[Please enter the following details to register a new member]");

        System.out.print("First name [Include middle name if applicable]: ");
        String name = scanner.nextLine().trim();

        System.out.print("Surname: ");
        String surName = scanner.nextLine().trim();

        System.out.print("Date of birth [DD-MM-YYYY]: ");
        LocalDate birthDate = null;
        while (birthDate == null) {
            try {
                String dobString = scanner.nextLine().trim();
                birthDate = LocalDate.parse(dobString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use DD-MM-YYYY.");
            }
        }

        System.out.print("Address [Street name, number and city]: ");
        String address = scanner.nextLine().trim();


        System.out.print("Phone number: ");
        int phoneNumber = getIntInput();

        System.out.print("Email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Is the member active? Y/N: ");
        boolean isActive = scanner.nextLine().trim().equalsIgnoreCase("y");

        System.out.print("Register member as competitive? Y/N: ");
        boolean isCompetitive = scanner.nextLine().trim().equalsIgnoreCase("y");

        Swimmer newMember = new Swimmer(name, surName, birthDate, isActive, address, phoneNumber,email, isCompetitive);
        controller.getMemberList().addMember(newMember);
        System.out.println("\nMember added successfully!");
    }

    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return input;
    }

    private void showMembers() {
        ArrayList<Member> members = controller.getMemberList().getMembers();

        if (members.isEmpty()) {
            System.out.println("No members on the list.");
        } else {
            System.out.println("Members on the list:");
            for (Member member : members) {
            }
        }
    }
}
