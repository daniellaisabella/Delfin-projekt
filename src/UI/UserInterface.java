package UI;

import java.util.ArrayList;
import java.util.Scanner;

import DataSource.Filehandler;
import Model.*;

public class UserInterface {
    private Controller controller = new Controller();
    private Scanner scanner = new Scanner(System.in);
    private Filehandler filehandler = new Filehandler();

    public void startProgram() {
        boolean running = true;
        while (running) {
            System.out.println("Welcome - Please login");
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            String loggedInRole = authenticate(username, password);
            if (loggedInRole != null) {
                System.out.println("Logged in as " + loggedInRole);
                runRoleMenu(loggedInRole);
            } else {
                System.out.println("Invalid credentials. Try again.");
            }
        }
    }

    private String authenticate(String username, String password) {
        if (username.equals("admin") && password.equals("admin123")) {
            return "Admin";
        } else if (username.equals("coach") && password.equals("coach123")) {
            return "Coach";
        } else if (username.equals("treasurer") && password.equals("treasurer123")) {
            return "Treasurer";
        }
        return null;
    }

    private void runRoleMenu(String role) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\n--- " + role + " Menu ---");
            switch (role) {
                case "Admin" -> {
                    displayAdminMenu();
                    String choice = scanner.nextLine();
                    if ("0".equals(choice)) {
                        loggedIn = false;
                    } else {
                        handleAdminChoice(choice);
                    }
                }
                case "Coach" -> {
                    displayCoachMenu();
                    String choice = scanner.nextLine();
                    if ("0".equals(choice)) {
                        loggedIn = false;
                    } else {
                        handleCoachChoice(choice);
                    }
                }
                case "Treasurer" -> {
                    displayTreasurerMenu();
                    String choice = scanner.nextLine();
                    if ("0".equals(choice)) {
                        loggedIn = false;
                    } else {
                        handleTreasurerChoice(choice);
                    }
                }
                default -> loggedIn = false;
            }
        }
    }

    private void displayAdminMenu() {
        System.out.println("[1] Register new member");
        System.out.println("[2] View all members");
        System.out.println("[0] Logout");
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

        System.out.print("First name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Surname: ");
        String surName = scanner.nextLine().trim();

        System.out.print("Age: ");
        int age = getIntInput();

        System.out.print("Address: ");
        String address = scanner.nextLine().trim();

        System.out.print("Phone number: ");
        int phoneNumber = getIntInput();

        System.out.print("Email address: ");
        String email = scanner.nextLine().trim();

        System.out.print("Membership type (active/passive): ");
        String membershipType = getMembershipTypeInput();

        System.out.print("Member type (competition/fitness enthusiast): ");
        String memberType = getMemberTypeInput();

        Swimmer newMember = new Swimmer(name, surName, age, address, phoneNumber, email, membershipType, memberType);
        controller.getMemberList().addMember(newMember);

        ArrayList<Member> members = controller.getMemberList().getMembers();
        if (controller.getFilehandler().saveMember(members)) {
            System.out.println("Member added successfully! Membership price: " + newMember.getMembershipPrice());
        } else {
            System.out.println("Failed to save member to file.");
        }
    }

    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer
        return input;
    }

    private String getMembershipTypeInput() {
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("active") || input.equals("passive")) {
                return input;
            }
            System.out.println("Invalid input. Please enter 'active' or 'passive'.");
        }
    }

    private String getMemberTypeInput() {
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("competition") || input.equals("fitness enthusiast")) {
                return input;
            }
            System.out.println("Invalid input. Please enter 'competition' or 'fitness enthusiast'.");
        }
    }

    private void showMembers() {
        ArrayList<Member> members = controller.getMemberList().getMembers();

        if (members.isEmpty()) {
            System.out.println("No members on the list.");
        } else {
            System.out.println("\n--- Member Details ---");


            System.out.println( members.size()+" members on the list");
            System.out.println();
            for (Member member : members) {
                System.out.println(member);
            }
        }
    }

    private void displayCoachMenu() {
        System.out.println("[1] View top swimmers by stroke");
        System.out.println("[0] Logout");
    }

    private void handleCoachChoice(String choice) {
        switch (choice) {
            case "1" -> viewTopSwimmers();
            default -> System.out.println("Invalid choice.");
        }
    }

    private void viewTopSwimmers() {
        System.out.println("Top swimmers functionality is not yet implemented.");
    }

    private void displayTreasurerMenu() {
        System.out.println("[1] View expected payments");
        System.out.println("[2] View actual payments");
        System.out.println("[3] Calculate arrears");
        System.out.println("[0] Logout");
    }

    private void handleTreasurerChoice(String choice) {
        Treasurer treasurer = new Treasurer("treasurer", "treasurer123");
        ArrayList<Member> members = controller.getMemberList().getMembers();

        switch (choice) {
            case "1" -> treasurer.viewExpectedPayments(members);
            case "2" -> treasurer.viewActualPayments(members);
            case "3" -> treasurer.calculateArrears(members);
            default -> System.out.println("Invalid choice.");
        }
    }
}
