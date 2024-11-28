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
        System.out.println("- [enter] the following number [1] to [register] a new member to the club");
        System.out.println("- [enter] the following number [2] to [view] the list of members");
        System.out.println("- [enter] the following number [0] to [exit] the program");
    }

    public void startProgram() {
        boolean running = true;
        displayMenu();
try{
        while (running) {
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
        System.out.println("\nFirst name [Please include middle name if applicable]: ");
        String name = scanner.nextLine().trim();

        System.out.println("Surname: ");
        String surName = scanner.nextLine().trim();

        System.out.println("Date of birth [DD-MM-YYYY]: ");
        LocalDate age= null;
        while (age == null) {
            try {
                String dobString = scanner.nextLine().trim();
                age = LocalDate.parse(dobString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use DD-MM-YYYY.");
            }
        }

        System.out.println("Adress Line 1 [Street name] : ");
        scanner.nextLine();
        System.out.println("Address Line 2 [Street number] : ");
        scanner.nextLine();
        System.out.println("Zip code: ");
        scanner.nextLine();
        System.out.println("City: ");
        String address = scanner.nextLine().trim();

        System.out.println("Phone number: ");
        int phoneNumber = getIntInput();

        //this option could need an if statement
        System.out.println("Is the member active? Y/N : ");
        boolean isActive = scanner.nextLine().trim().equalsIgnoreCase("y");

        //this option could need an if statement
        System.out.println("Register member as competitive? Y/N :");
        boolean isCompetitive = scanner.nextLine().trim().equalsIgnoreCase("y");

        Swimmer newMember = new Swimmer(name, surName, age, isActive, address,phoneNumber, isCompetitive);
        controller.getMemberList().addMember(newMember);
        System.out.println("\nMember added successfully!");

    } //----- method added for int phone number invalid input
    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        return input;
    }

    private void showMembers() {
        ArrayList<Member> members = controller.getMemberList().getMembers();

        if (members.isEmpty()) {
            System.out.println("No members on the list.");
        } else {
            System.out.println("Members on the list:");
            for (Member member : members) {
                System.out.println(member);
            }
        }
    }

    public boolean editMember() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();

        // Find member by username
        Member memberToEdit = controller.getMemberList().getMemberByUsername(username);

        if (memberToEdit == null) {
            System.out.println("Member not found.");
            return false;
        }

        System.out.print("Enter first name (press Enter to keep current): ");
        String newName = scanner.nextLine().trim();
        if (!newName.isEmpty()) memberToEdit.setName(newName);

        System.out.print("Enter surname (press Enter to keep current): ");
        String newSurname = scanner.nextLine().trim();
        if (!newSurname.isEmpty()) memberToEdit.setSurname(newSurname);

        System.out.print("Enter new age (press Enter to keep current): ");
        String ageInput = scanner.nextLine().trim();
        if (!ageInput.isEmpty()) {
            try {
                int newAge = Integer.parseInt(ageInput);
                memberToEdit.setAge(newAge);
            } catch (NumberFormatException e) {
                System.out.println("Invalid age input. Skipping update.");
            }
        }

        System.out.print("Enter new phone number (press Enter to keep current): ");
        String phoneNumberInput = scanner.nextLine().trim();
        if (!phoneNumberInput.isEmpty()) {
            try {
                int newPhoneNumber = Integer.parseInt(phoneNumberInput);
                memberToEdit.setPhoneNumber(newPhoneNumber);
            } catch (NumberFormatException e) {
                System.out.println("Invalid phone number input. Skipping update.");
            }
        }

        System.out.print("Is the member a competitive swimmer? y/n (press Enter to keep current): ");
        String isCompetitiveInput = scanner.nextLine().trim();
        if (!isCompetitiveInput.isEmpty()) {
            memberToEdit.setIsCompetitive(isCompetitiveInput.equalsIgnoreCase("y"));
        }

        System.out.print("Enter swim discipline (press Enter to keep current): ");
        String newSwimDiscipline = scanner.nextLine().trim();
        if (!newSwimDiscipline.isEmpty()) memberToEdit.setSwimDiscipline(newSwimDiscipline);

        System.out.print("Enter swim time (press Enter to keep current): ");
        String newSwimTime = scanner.nextLine().trim();
        if (!newSwimTime.isEmpty()) memberToEdit.setSwimTime(Double.parseDouble(newSwimTime));

        System.out.println("Member information updated successfully.");
        return true;
    }
}