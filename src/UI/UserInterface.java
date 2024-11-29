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
    private String loggedInRole;

    public void startProgram() {
        boolean running = true;
        while (running) {
            System.out.println("Welcome - Please login");
            System.out.println("Enter username");
            String username = scanner.nextLine();
            System.out.println("Enter password");
            String password = scanner.nextLine();

            loggeInRole = authenticate(username, password);
            if (loggedInRole != null) {
                System.out.println("Logged in as " + loggedInRole);
                runRoleMenu();
            } else {
                System.out.println("Invalid credentials. Try again.");
            }
        }
    }

    private String authenticate(String username, String password) {
        if (username.equals("admin") && password.equals("admin123")) {
            return "Admin";
        } else if (username.equals("treasurer") && password.equals("treasurer123")) {
            return "Treasurer";
        } else if (username.equals("coach") && password.equals("coach123")) {
            return "Coach";
        }
        return null;
    }

    private void runRoleMenu() {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\n--- " + loggedInRole + " Menu ---");
            switch (loggedInRole) {
                case "Administrator" -> displayAdminMenu();
                case "Kasserer" -> displayTreasurerMenu();
                case "Træner" -> displayCoachMenu();
            }

            System.out.print("Enter choice or 0 to log out: ");
            String choice = scanner.nextLine();
            if (choice.equals("0")) {
                loggedIn = false;
            } else {
                handleRoleChoice(choice);
            }
        }
    }

    private void displayAdminMenu() {
        System.out.println("[1] Register new member");
        System.out.println("[2] View all members");
    }

    private void displayTreasurerMenu() {
        System.out.println("[1] View expected payments");
        System.out.println("[2] View actual payments");
        System.out.println("[3] View members in arrears");
    }

    private void displayCoachMenu() {
        System.out.println("[1] View swimmers");
        System.out.println("[2] View disciplines and competition times");
    }

    private void handleRoleChoice(String choice) {
        switch (loggedInRole) {
            case "Administrator" -> handleAdminChoice(choice);
            case "Kasserer" -> handleTreasurerChoice(choice);
            case "Træner" -> handleCoachChoice(choice);
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
