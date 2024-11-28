package UI;

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
        System.out.println("Type 'add' or '1' to add a member to the swimming club");
        System.out.println("Type 'members' or '2' to show the member list");
        System.out.println("Type 'exit' or '0' to exit the program");
    }

    public void startProgram() {
        boolean running = true;
        displayMenu();

        while (running) {
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "add", "1" -> addMember();
                case "members", "2" -> showMembers();
                case "edit member", "3" -> editMember();
                case "exit", "0" -> {
                    System.out.println("Exiting program...");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addMember() {
        System.out.println("Enter first name:");
        String name = scanner.nextLine().trim();

        System.out.println("Enter last name:");
        String surName = scanner.nextLine().trim();

        System.out.println("Enter member age:");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter member address (street name, house number, city, zipcode):");
        String address = scanner.nextLine().trim();

        System.out.println("Enter member phone number:");
        int phoneNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Is the member active? Yes or No:");
        boolean isActive = scanner.nextLine().trim().equalsIgnoreCase("yes");

        System.out.println("Is the member a competitive swimmer? Yes or No:");
        boolean isCompetitive = scanner.nextLine().trim().equalsIgnoreCase("yes");

        Swimmer newMember = new Swimmer(name, surName, age, isActive, address, phoneNumber, isCompetitive);
        controller.getMemberList().addMember(newMember);
        System.out.println("Member added successfully!");
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