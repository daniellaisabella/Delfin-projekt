package UI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import DataSource.Filehandler;
import Model.*;

public class UserInterface {
    private Controller controller = new Controller();
    private Scanner scanner = new Scanner(System.in); // Scanner initialiseret korrekt
    private String loggedInRole; // Holder styr på, hvilken bruger der er logget ind
    private Filehandler filehandler = new Filehandler();

    //-----------------------Log in------------------------------
    public void startProgram() {
        boolean running = true;
        while (running) {
            System.out.println("Welcome - Please login");
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            loggedInRole = authenticate(username, password);
            if (loggedInRole != null) {
                System.out.println("Logged in as " + loggedInRole);
                runRoleMenu();
            } else {
                System.out.println("Invalid credentials. Try again.");
            }
        }
        scanner.close(); // Lukker scanner for at frigive ressourcer
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
    //-----------------------------------------------------------------
    private void runRoleMenu() {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\n--- " + loggedInRole + " Menu ---");
            switch (loggedInRole) {
                case "Admin" -> displayAdminMenu();
                case "Treasurer" -> displayTreasurerMenu();
                case "Coach" -> displayCoachMenu();
                default -> {
                    System.out.println("Role not recognized: " + loggedInRole); // Debug statement
                    loggedIn = false; // Exit if an invalid role is detected
                }
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

    private void handleRoleChoice(String choice) {
        switch (loggedInRole) {
            case "Admin" -> handleAdminChoice(choice);
            case "Treasurer" -> handleTreasurerChoice(choice);
            case "Coach" -> handleCoachChoice(choice);
            default -> System.out.println("Invalid role.");
        }
    }
    //-------------------Admin menu---------------------------
    // --- Administrator-funktioner ---
    private void displayAdminMenu() {
        System.out.println("[1] Register new member");
        System.out.println("[2] View all members");
    }

    private void handleAdminChoice(String choice) {
        switch (choice) {
            case "1" -> addMember();
            case "2" -> showMembers();
            default -> System.out.println("Invalid choice.");
        }
    }

    private void addMember() {
        System.out.println("\n[Please enter the following details to register a new member]");

        System.out.print("\nFirst name [Include middle name if applicable]: ");
        String name = scanner.nextLine().trim();

        System.out.print("Surname: ");
        String surName = scanner.nextLine().trim();

        System.out.print("Date of birth [DD-MM-YYYY]: ");
        LocalDate age = null;
        while (age== null) {
            try {
                String dobString = scanner.nextLine().trim();
                age = LocalDate.parse(dobString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use DD-MM-YYYY.");
            }
        }

        System.out.print("Address [Street name, number and city]: ");
        String address = scanner.nextLine().trim();

        System.out.print("Phone number: ");
        int phoneNumber = getIntInput();

        System.out.print("Email address: ");
        String email = scanner.nextLine().trim();

        System.out.print("Register as active membership? Y/N: ");
        boolean isActive = scanner.nextLine().trim().equalsIgnoreCase("y");

        System.out.print("Register member as a competitive swimmer? Y/N: ");
        boolean isCompetitive = scanner.nextLine().trim().equalsIgnoreCase("y");

        Swimmer newMember = new Swimmer(name, surName, age, isActive, address, phoneNumber,email, isCompetitive);
        // Tilføj medlem til listen
        controller.getMemberList().addMember(newMember);
        // Gem medlemmer i CSV-filen automatisk
        ArrayList<Member> members = controller.getMemberList().getMembers();
        if(filehandler.saveMember(members)) {
            System.out.println("Member added and saved successfully");
        } else {
        System.out.println("\nMember added, but saving to file failed");
    }
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
    //-----------------------------------------------------------------
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
    //---------------------------Treasury menu--------------------------
    // --- Kasserer-funktioner ---
    private void displayTreasurerMenu() {
        System.out.println("[1] View expected payments");
        System.out.println("[2] View actual payments");
        System.out.println("[3] View members in arrears");
    }

    private void handleTreasurerChoice(String choice) {
        switch (choice) {
            case "1" -> viewExpectedPayments();
            case "2" -> viewActualPayments();
            case "3" -> viewArrears();
            default -> System.out.println("Invalid choice.");
        }
    }

    private void viewExpectedPayments() {
        ArrayList<Swimmer> members = filehandler.loadMembers();
        double totalExpected = 0;
        for (Swimmer member : members) {
            totalExpected += Contingent.calculateContingent(member.getMembershipType());
        }
        System.out.println("Total expected fee payment: " + totalExpected + " DKK");
    }

    private void viewActualPayments() {
        Map<String, Double> payments = filehandler.loadPayments();
        if (payments.isEmpty()) {
            System.out.println("No payments are registered");
        } else {
            System.out.println("Actual payments:");
            payments.forEach((username, amount) ->
                    System.out.println("Member: " + username + ", Paid: " + amount + " DKK"));
        }
    }

    private void viewArrears() {
        ArrayList<Swimmer> members = filehandler.loadMembers();
        Map<String, Double> payments = filehandler.loadPayments();

        System.out.println("Members in debt");
        for (Swimmer member : members) {
            double expected = Contingent.calculateContingent(member.getMembershipType());
            double paid = payments.getOrDefault(member.getUsername(), 0.0);
            if (paid < expected) {
                System.out.printf("Member: %s, Expected: %.2f DKK, Paid: %.2f DKK, Outstanding: %.2f DKK%n",
                        member.getUsername(), expected, paid, expected - paid);
            }
        }
    }
    //----------------------Coach Menu------------------------------
    // --- Træner-funktioner ---
    private void displayCoachMenu() {
        System.out.println("[1] View swimmers");
        System.out.println("[2] View disciplines and competition times");
    }

    private void handleCoachChoice(String choice) {
        switch (choice) {
            case "1" -> showSwimmers();
            case "2" -> showCompetitionTimes();
            default -> System.out.println("Invalid choice.");
        }
    }

    private void showSwimmers() {
        ArrayList<Member> members = controller.getMemberList().getMembers();
        if (members.isEmpty()) {
            System.out.println("No swimmers found.");
        } else {
            System.out.println("Swimmers:");
            for (Member member : members) {
                if (member.isCompetitive()) {
                    System.out.println(member);
                }
            }
        }
    }

    private void showCompetitionTimes() {
        ArrayList<Member> members = controller.getMemberList().getMembers();
        System.out.println("Competition times:");
        for (Member member : members) {
            if (member instanceof Swimmer) {
                Swimmer swimmer = (Swimmer) member;
                System.out.println(swimmer.getName() + "'s competition times: " + swimmer.getCompetitiveResults());
            }
        }
    }
}
