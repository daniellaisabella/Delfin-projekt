package UI;

import java.util.ArrayList;
import java.util.Scanner;

import DataSource.Filehandler;
import Model.*;

public class UserInterface {
    private Controller controller = new Controller();
    private Scanner scanner = new Scanner(System.in);
    private String loggedInRole;
    private Filehandler filehandler = new Filehandler();

    public UserInterface() {
    }

    public boolean load2() {
        ArrayList<Swimmer> loadedMembers = filehandler.loadMembers();
        if (loadedMembers != null) {
            controller.getMemberList().getMembers().addAll(loadedMembers);
            return true; // Loading successful
        } else {
            return false; // Loading failed
        }
    }

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
        scanner.close();
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
                case "Admin" -> displayAdminMenu();
                case "Treasurer" -> displayTreasurerMenu();
                case "Coach" -> displayCoachMenu();
                default -> {
                    System.out.println("Role not recognized: " + loggedInRole);
                    loggedIn = false;
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

        String membershipType = getMembershipTypeInput();
        String memberType = getMemberTypeInput();

        Swimmer newMember = new Swimmer(name, surName, age, address, phoneNumber, email, membershipType, memberType);
        controller.getMemberList().addMember(newMember);

        ArrayList<Member> members = controller.getMemberList().getMembers();
        if (filehandler.saveMember(members)) {
            System.out.println("Member added and saved successfully.");
        } else {
            System.out.println("\nMember added, but saving to file failed.");
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
            System.out.print("Membership type (active/passive): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("active") || input.equals("passive")) {
                return input;
            } else {
                System.out.println("Invalid input. Please enter 'active' or 'passive'.");
            }
        }
    }

    private String getMemberTypeInput() {
        while (true) {
            System.out.print("Member type (competition/fitness enthusiast): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("competition") || input.equals("fitness enthusiast")) {
                return input;
            } else {
                System.out.println("Invalid input. Please enter 'competition' or 'fitness enthusiast'.");
            }
        }
    }

    private void showMembers() {
        ArrayList<Member> members = controller.getMemberList().getMembers();

        System.out.println("Number of members in the list: " + members.size());
        if (members.isEmpty()) {
            System.out.println("No members on the list.");
        } else {
            System.out.println("Members on the list:");
            for (Member member : members) {
                System.out.println(member);
            }
        }
    }

    private void displayTreasurerMenu() {
        System.out.println("[1] View expected payments");
        System.out.println("[2] View actual payments");
        System.out.println("[3] View members in arrears");
    }

    private void handleTreasurerChoice(String choice) {
        switch (choice) {
            case "1" -> System.out.println("View expected payments (Not implemented)");
            case "2" -> System.out.println("View actual payments (Not implemented)");
            case "3" -> System.out.println("View members in arrears (Not implemented)");
            default -> System.out.println("Invalid choice.");
        }
    }

    private void displayCoachMenu() {
        System.out.println("[1] View swimmers");
        System.out.println("[2] View disciplines and competition times");
    }

    private void handleCoachChoice(String choice) {
        switch (choice) {
            case "1" -> System.out.println("View swimmers (Not implemented)");
            case "2" -> System.out.println("View disciplines and competition times (Not implemented)");
            default -> System.out.println("Invalid choice.");
        }
    }
}
