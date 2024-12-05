package UI;

import java.util.ArrayList;
import java.util.Scanner;

import DataSource.Filehandler;
import Model.*;

public class UserInterface {
    private Controller controller = new Controller();
    private Scanner scanner = new Scanner(System.in);
    private Filehandler filehandler = new Filehandler();
    private Treasurer treasurer = new Treasurer("treasurer", "treasurer123"); // Flyttet her for at genbruge instansen

    public void startProgram() {
        boolean running = true;
        while (running) {
            System.out.println("Welcome - login");
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
        // Add member functionality...
    }

    private void showMembers() {
        ArrayList<Member> members = controller.getMemberList().getMembers();
        if (members.isEmpty()) {
            System.out.println("No members on the list.");
        } else {
            System.out.println("\n--- Member Details ---");
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
        // Handle coach choices...
    }

    private void displayTreasurerMenu() {
        System.out.println("[1] Payments and arrears");
        System.out.println("[2] Bookkeeping: register payments");
        System.out.println("[0] Logout");
    }

    private void handleTreasurerChoice(String choice) {
        ArrayList<Member> members = controller.getMemberList().getMembers();

        if (members == null || members.isEmpty()) {
            System.out.println("No members available. Please add members first.");
            return;
        }

        switch (choice) {
            case "1" -> treasurer.viewExpectedPayments(members);
            case "2" -> treasurer.registerPayment(members); // Genbruger den vedvarende Treasurer-instans
            default -> System.out.println("Invalid choice.");
        }
    }
}
