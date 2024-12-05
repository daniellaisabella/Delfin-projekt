package UI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DataSource.Filehandler;
import Model.*;

public class UserInterface {
    private Controller controller = new Controller();
    private Scanner scanner = new Scanner(System.in);
    private Filehandler filehandler = new Filehandler();
    //-----------------------------------
    private Coach coach;

    public UserInterface(Coach coach) {
        this.coach = coach;
    }

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
                        handleCoachChoice(Integer.parseInt(choice));
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


            System.out.println( members.size()+" members in Delfinklubben");
            System.out.println();
            for (Member member : members) {
                System.out.println(member);
            }
        }
    }
//--------------------------------------------COACH MENU----------------------------------------------------------
    private void displayCoachMenu() {
        System.out.println("\n--- Coach Menu ---");
        System.out.println("1. Register new swimmer");
        System.out.println("2. Register training result");
        System.out.println("3. Register competitive result");
        System.out.println("4. Register active stroke for a swimmer");
        System.out.println("5. Display swimmer info");
        System.out.println("6. Display team members");
        System.out.println("7. View all swimmers");
        System.out.println("8. View top 5 swimmers");
        System.out.println("0. Exit");
    }

    private void handleCoachChoice(int choice) {
        boolean running = true;
        while (running) {
            displayCoachMenu();
            choice = getIntInput("Enter your choice: ");
        }
        switch (choice) {
            case 1:
                registerSwimmer();
                break;
            case 2:
                registerTrainingResult();
                break;
            case 3:
                registerCompetitiveResult();
                break;
            case 4:
                registerActiveStroke();
                break;
            case 5:
                displaySwimmerInfo();
            break;
            case 6:
                displayTeamMembers();
            break;
            case 7:
                viewAllSwimmers();
            break;
            case 8:
                viewTop5Swimmers();
            break;
            case 0:
                break;
            default: System.out.println("Invalid choice. Please try again.");
        }
    }

    private void registerSwimmer() {
        String name = getStringInput("Enter swimmer's name: ");
        int age = getIntInput("Enter swimmer's age: ");
        String phone = getStringInput("Enter swimmer's phone number: ");
        SwimStroke stroke = selectSwimStroke();
        Swimmer swimmer = new Swimmer(name, age, phone);
        swimmer.addActiveStroke(stroke);
        coach.registerSwimmer(swimmer);
        System.out.println("Swimmer registered successfully.");
    }

    private void registerTrainingResult() {
        Swimmer swimmer = selectSwimmer();
        if (swimmer == null) return;
        LocalDate date = getDateInput("Enter training date (YYYY-MM-DD): ");
        double time = getDoubleInput("Enter time (in seconds): ");
        SwimStroke stroke = selectSwimStroke();
        coach.registerTrainingResult(swimmer, date, time, stroke);
        System.out.println("Training result registered successfully.");
    }

    private void registerCompetitiveResult() {
        Swimmer swimmer = selectSwimmer();
        if (swimmer == null) return;
        String location = getStringInput("Enter competition location: ");
        int placement = getIntInput("Enter placement: ");
        double time = getDoubleInput("Enter time (in seconds): ");
        LocalDate date = getDateInput("Enter competition date (YYYY-MM-DD): ");
        SwimStroke stroke = selectSwimStroke();
        coach.registerCompetitiveResult(swimmer, location, placement, time, date, stroke);
        System.out.println("Competitive result registered successfully.");
    }

    private void registerActiveStroke() {
        Swimmer swimmer = selectSwimmer();
        if (swimmer == null) return;
        SwimStroke stroke = selectSwimStroke();
        coach.registerActiveStroke(swimmer, stroke);
        System.out.println("Active stroke registered successfully.");
    }

    private void displaySwimmerInfo() {
        Swimmer swimmer = selectSwimmer();
        if (swimmer != null) {
            coach.displaySwimmerInfo(swimmer);
        }
    }

    private void displayTeamMembers() {
        System.out.println("Junior Team:");
        for (Swimmer swimmer : coach.getTeamMembers(Team.JUNIOR)) {
            System.out.println("- " + swimmer.getName());
        }
        System.out.println("\nSenior Team:");
        for (Swimmer swimmer : coach.getTeamMembers(Team.SENIOR)) {
            System.out.println("- " + swimmer.getName());
        }
    }
    private void viewAllSwimmers() {
        List<Swimmer> allSwimmers = coach.getAllSwimmers();
        System.out.println("All Swimmers:");
        for (Swimmer swimmer : allSwimmers) {
            System.out.println("- " + swimmer.getName() + " (" + swimmer.getTeam() + ")");
        }
    }
    private void viewTop5Swimmers() {
        System.out.println("========VIEW TOP 5 SWIMMERS============");
        Team team = selectTeam();
        SwimStroke stroke = selectSwimStroke();
        List<Swimmer> top5 = coach.getTop5Swimmers(team, stroke);
        System.out.println("Top 5 " + team + " swimmers in " + stroke + ":");
        for (int i = 0; i < top5.size(); i++) {
            Swimmer swimmer = top5.get(i);
            System.out.println((i + 1) + ". " + swimmer.getName() + " - Best time: " + swimmer.getBestTime(stroke));
        }
    }
    private Swimmer selectSwimmer() {
        List<Swimmer> allSwimmers = coach.getAllSwimmers();
        System.out.println("Select a swimmer:");
        for (int i = 0; i < allSwimmers.size(); i++) {
            Swimmer swimmer = allSwimmers.get(i);
            System.out.println((i + 1) + ". " + swimmer.getName() + " (" + swimmer.getTeam() + ")");
        }
        int choice = getIntInput("Enter the number of the swimmer: ");
        if (choice > 0 && choice <= allSwimmers.size()) {
            return allSwimmers.get(choice - 1);
        } else {
            System.out.println("Invalid selection.");
            return null;
        }
    }

    private SwimStroke selectSwimStroke() {
        System.out.println("Select swim stroke:");
        for (int i = 0; i < SwimStroke.values().length; i++) {
            System.out.println((i + 1) + ". " + SwimStroke.values()[i]);
        }
        int choice = getIntInput("Enter your choice: ");
        if (choice > 0 && choice <= SwimStroke.values().length) {
            return SwimStroke.values()[choice - 1];
        }
        return SwimStroke.BREASTSTROKE; // Default
    }

    private Team selectTeam() {
        System.out.println("Select team:");
        System.out.println("1. Junior Team");
        System.out.println("2. Senior Team");
        int choice = getIntInput("Enter your choice: ");
        return (choice == 1) ? Team.JUNIOR : Team.SENIOR;
    }

    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("That's not a valid number. Please try again.");
            scanner.next();
        }
        int result = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return result;
    }

    private double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("That's not a valid number. Please try again.");
            scanner.next();
        }
        double result = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        return result;
    }

    private LocalDate getDateInput(String prompt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        while (true) {
            try {
                String dateString = getStringInput(prompt);
                return LocalDate.parse(dateString, formatter);
            } catch (Exception e) {
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            }
        }
    }

    private void viewTopSwimmers() {
        System.out.println("Top swimmers functionality is not yet implemented.");
    }
//----------------------------------------------------------------------------------------
    private void displayTreasurerMenu() {
        System.out.println("[1] Payments and arrears");
        System.out.println("[2] Bookkeeping: register payments");

        System.out.println("[0] Logout");
    }

    private void handleTreasurerChoice(String choice) {
        Treasurer treasurer = new Treasurer("treasurer", "treasurer123");
        ArrayList<Member> members = controller.getMemberList().getMembers();

        switch (choice) {
            case "1" -> treasurer.viewExpectedPayments(members);
            case "2" -> treasurer.bookkeeping(members);

            default -> System.out.println("Invalid choice.");
        }
    }


}
