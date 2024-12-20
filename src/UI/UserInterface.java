package UI;

import DataSource.Filehandler;
import Model.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Controller controller = new Controller();
    private Scanner scanner = new Scanner(System.in);
    private Filehandler filehandler = new Filehandler();
    private Treasurer treasurer = new Treasurer("treasurer", "treasurer123", filehandler);
    private Coach coach = new Coach("coach", "coach123");


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
                        handleTreasurerChoice(choice, filehandler);
                    }
                }
                default -> loggedIn = false;
            }
        }
    }

    //-------------------------------ADMIN MENU----------------------------------------
    private void displayAdminMenu() {
        System.out.println("[1] Register new member");
        System.out.println("[2] View all members");
        System.out.println("[3] Delete member");
        System.out.println("[0] Logout");
    }

    private void handleAdminChoice(String choice) {
        switch (choice) {
            case "1" -> addMember();
            case "2" -> showMembers();
            case "3" -> deleteMember();
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

        System.out.print("Address (street name, house nr, zip code, city): ");
        String address = scanner.nextLine().trim();

        System.out.print("Phone number: ");
        String phoneNumber = scanner.nextLine().trim();

        System.out.print("Email address: ");
        String email = scanner.nextLine().trim();

        System.out.print("Membership type (active/passive): ");
        String membershipType = getMembershipTypeInput();

        System.out.print("Member type (competition/fitness enthusiast): ");
        String memberType = getMemberTypeInput();

        // Opretter en ny Swimmer

        Swimmer newMember = new Swimmer(name, surName, age, address, phoneNumber, email, membershipType, memberType);
        controller.getMemberList().addMember(newMember); // Tilføj medlem til listen

        // Gemmer medlemmer i fil
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


    private String getMemberTypeInput() {
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("competition") || input.equals("fitness enthusiast")) {
                return input;
            }
            System.out.println("Invalid input. Please enter 'competition' or 'fitness enthusiast'.");
        }
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

    //---------------------delete member----------------
    private void deleteMember() {
        System.out.println("Delete member by phone number");
        System.out.println();
        System.out.println("Do you want to see the member list? [yes/no]");
        String choice = scanner.nextLine().trim().toLowerCase();
        if (choice.equals("yes")) {
            showMembers();
        }
        System.out.println();
        System.out.println("Please enter the phone number of the member you want to delete:");
        System.out.println();

        String phoneNumber = scanner.nextLine().trim();
        controller.getMemberList().deleteMember(phoneNumber);
    }

    //---------------------------------------COACH MENU------------------------------------

    private void displayCoachMenu() {
        System.out.println("\n--- Coach Menu ---");
        System.out.println("1. Register new swimmer");
        System.out.println("2. Register training result");
        System.out.println("3. Register competitive result");
        System.out.println("4. Register active stroke for a swimmer");
        System.out.println("5. Display swimmer info");
        System.out.println("6. Display team members");
        System.out.println("7. View all competitive swimmers");
        System.out.println("8. View top 5 swimmers");
        System.out.println("9. View all training results"); // New option
        System.out.println("0. Exit");
    }

    private void handleCoachChoice(String choice) {
        switch (choice) {
            case "1" -> registerCompetitiveSwimmer();
            case "2" -> registerTrainingResult();
            case "3" -> registerCompetitiveResult();
            case "4" -> registerActiveStroke();
            case "5" -> displaySwimmerInfo();
            case "6" -> displayTeamMembers();
            case "7" -> viewAllCompetitiveSwimmers();
            case "8" -> viewTop5Swimmers();
            case "9" -> viewAllTrainingResults();
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }

    //------------------------------ register competitive swimmer
    private void registerCompetitiveSwimmer() {
        String name = getStringInput("Enter swimmer's name: ");
        String surname = getStringInput("Enter swimmer's surname: ");
        int age = getIntInput("Enter swimmer's age: ");
        String phone = getStringInput("Enter swimmer's phone number: ");
        String address = getStringInput("Enter swimmer's address: ");
        String mail = getStringInput("Enter swimmer's email: ");
        MembershipType membershipType = selectMembershipType();
        SwimStroke stroke = selectSwimStroke();
        Team team = (age < 18) ? Team.JUNIOR : Team.SENIOR;
        String tournamentAttendance = getStringInput("Has attended tournament (yes/no): ");
        CompetitiveSwimmer competitiveSwimmer = new CompetitiveSwimmer(name, surname, age, address, phone, mail, team, membershipType, tournamentAttendance);


        coach.registerCompetitiveSwimmer(competitiveSwimmer);
        controller.getMemberList().addMember((Member) competitiveSwimmer);

        // Save the updated memberList to the CSV file
        ArrayList<Member> members = controller.getMemberList().getMembers();
        if (controller.getFilehandler().saveMember(members)) {
            System.out.println("Swimmer registered successfully.");
        } else {
            System.out.println("Failed to save member to file.");
        }
    }

    //-------------------------- select memebership type
    private MembershipType selectMembershipType() {
        System.out.println("Select membership type:");
        System.out.println("1. Active");
        System.out.println("2. Passive");
        int choice = getIntInput("Enter your choice: ");
        switch (choice) {
            case 1:
                return MembershipType.ACTIVE;
            case 2:
                return MembershipType.PASSIVE;
            default:
                System.out.println("Invalid choice. Please try again.");
                return selectMembershipType();
        }
    }

    //------------------------------register training result
    private void registerTrainingResult() {
        CompetitiveSwimmer competitiveSwimmer = selectSwimmer();
        if (competitiveSwimmer == null) return;
        LocalDate date = getDateInput("Enter training date (YYYY-MM-DD): ");
        double time = getDoubleInput("Enter time (in seconds): ");
        SwimStroke stroke = selectSwimStroke();
        coach.registerTrainingResults(competitiveSwimmer, date, time, stroke);
        System.out.println("Training result registered successfully.");

        // Update the memberList with the new training result
        controller.getMemberList().updateMember(competitiveSwimmer);

        // Save the updated memberList to the CSV file
        ArrayList<Member> members = controller.getMemberList().getMembers();
        if (controller.getFilehandler().saveMember(members)) {
            System.out.println("Training result registered and saved successfully.");
        } else {
            System.out.println("Failed to save training result.");
        }
    }

    //------------------------------Register competitive results
    private void registerCompetitiveResult() {
        CompetitiveSwimmer competitiveSwimmer = selectSwimmer();
        if (competitiveSwimmer == null) return;
        String location = getStringInput("Enter competition location: ");
        int placement = getIntInput("Enter placement: ");
        double time = getDoubleInput("Enter time (in seconds): ");
        LocalDate date = getDateInput("Enter competition date (YYYY-MM-DD): ");
        SwimStroke stroke = selectSwimStroke();
        coach.registerCompetitiveResult(competitiveSwimmer, location, placement, time, date, stroke);
        System.out.println("Competitive result registered successfully.");

        // Update the memberList with the new competitive result
        controller.getMemberList().updateMember(competitiveSwimmer);

        // Save the updated memberList to the CSV file
        ArrayList<Member> members = controller.getMemberList().getMembers();
        if (controller.getFilehandler().saveMember(members)) {
            System.out.println("Competitive result registered and saved successfully.");
        } else {
            System.out.println("Failed to save competitive result.");
        }
    }
    //------------------------------register active stroke

    private void registerActiveStroke() {
        CompetitiveSwimmer competitiveSwimmer = (Model.CompetitiveSwimmer) selectSwimmer();
        if (competitiveSwimmer == null) return;
        SwimStroke stroke = selectSwimStroke();
        coach.registerActiveStroke(competitiveSwimmer, stroke);
        System.out.println("Active stroke registered successfully.");
        competitiveSwimmer.addActiveStroke(stroke);
    }
    //------------------------------display swimmer info

    private void displaySwimmerInfo() {
        CompetitiveSwimmer competitiveSwimmer = (Model.CompetitiveSwimmer) selectSwimmer();
        if (competitiveSwimmer != null) {
            coach.displaySwimmerInfo(competitiveSwimmer);
        }
    }
    //------------------------------Display team members-----------------

    private void displayTeamMembers() {
        System.out.println("Junior Team:");
        for (CompetitiveSwimmer competitiveSwimmer : coach.getTeamMembers(Team.JUNIOR)) {
            System.out.println("- " + competitiveSwimmer.getName());
        }
        System.out.println("\nSenior Team:");
        for (CompetitiveSwimmer competitiveSwimmer : coach.getTeamMembers(Team.SENIOR)) {
            System.out.println("- " + competitiveSwimmer.getName());
        }
    }

    //----------------------View all competitive swimmers---------------------
    private void viewAllCompetitiveSwimmers() {
        List<CompetitiveSwimmer> allSwimmers = coach.getAllSwimmers();
        System.out.println("All Swimmers:");
        for (CompetitiveSwimmer competitiveSwimmer : allSwimmers) {
            System.out.println("- " + competitiveSwimmer.getName() + " (" + competitiveSwimmer.getTeam() + ")");
        }
    }

    //-------------------------------view top 5 swimmers-------------------------
    private void viewTop5Swimmers() {
        System.out.println("========VIEW TOP 5 SWIMMERS============");
        Team team = selectTeam();
        SwimStroke stroke = selectSwimStroke();
        List<CompetitiveSwimmer> top5 = coach.getTop5Swimmers(team, stroke);
        System.out.println("Top 5 " + team + " swimmers in " + stroke + ":");
        for (int i = 0; i < top5.size(); i++) {
            CompetitiveSwimmer competitiveSwimmer = top5.get(i);
            System.out.println((i + 1) + ". " + competitiveSwimmer.getName() + " - Best time: " + competitiveSwimmer.getBestTime(stroke));
        }
    }
    //----------Internal sub menu-------------

    private CompetitiveSwimmer selectSwimmer() {
        List<CompetitiveSwimmer> allSwimmers = coach.getAllSwimmers();
        System.out.println("Select a swimmer:");
        for (int i = 0; i < allSwimmers.size(); i++) {
            CompetitiveSwimmer competitiveSwimmer = allSwimmers.get(i);
            System.out.println((i + 1) + ". " + competitiveSwimmer.getName() + " (" + competitiveSwimmer.getTeam() + ")");
        }
        int choice = getIntInput("Enter the number of the swimmer: ");
        if (choice > 0 && choice <= allSwimmers.size()) {
            return allSwimmers.get(choice - 1);
        } else {
            System.out.println("Invalid selection.");
            return null;
        }
    }
    //------------------------------select swim stroke

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
    //------------------------------select team

    private Team selectTeam() {
        System.out.println("Select team:");
        System.out.println("1. Junior Team");
        System.out.println("2. Senior Team");
        int choice = getIntInput("Enter your choice: ");
        return (choice == 1) ? Team.JUNIOR : Team.SENIOR;
    }
    //------------------------------string input

    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    //------------------------------ int input

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
    //------------------------------double input

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
    //------------------------------ view all training results

    private void viewAllTrainingResults() {
        CompetitiveSwimmer competitiveSwimmer = selectSwimmer();
        if (competitiveSwimmer != null) {
            List<TrainingResults> results = competitiveSwimmer.getTrainingResults();
            if (results.isEmpty()) {
                System.out.println("No training results found for " + competitiveSwimmer.getName());
            } else {
                System.out.println("Training results for " + competitiveSwimmer.getName() + ":");
                for (TrainingResults result : results) {
                    System.out.println("  Date: " + result.getDate());
                    System.out.println("  Stroke: " + result.getStroke());
                    System.out.println("  Time: " + result.getTimePerformance() + " seconds");
                    System.out.println("  ---");
                }
            }
        }
    }
    //------------------------------date input

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

//-----------------------------------Treasurere menu--------------------------------------------


    private void displayTreasurerMenu() {
        System.out.println("[1] Payments and arrears");
        System.out.println("[2] Bookkeeping: register payments");
        System.out.println("[0] Logout");
    }

    private void handleTreasurerChoice(String choice, Filehandler filehandler) {
        ArrayList<Member> members = controller.getMemberList().getMembers();

        if (members == null || members.isEmpty()) {
            System.out.println("No members available. Please add members first.");
            return;
        }

        switch (choice) {
            case "1" -> treasurer.viewExpectedPayments(members);
            case "2" -> treasurer.registerPayment(members, filehandler);
            default -> System.out.println("Invalid choice.");
        }
    }
}
