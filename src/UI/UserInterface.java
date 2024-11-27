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
        System.out.println("- [enter] the following number [1] to [register] a new member to the club");
        System.out.println("- [enter] the following number [2] to [view] the list of members");
        System.out.println("- [enter] the following number [0] to [exit] the program");
    }

    public void startProgram() {
        boolean running = true;
        displayMenu();
try{
        while (running) {
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
            if (running) displayMenu();
        }
    } finally {
        scanner.close();

        }
    }
    private void addMember() {
        System.out.println("[Please enter the following details to register a new member]");
        System.out.println("\nFirst name [Please include middle name if applicable]: ");
        String name = scanner.nextLine().trim();

        System.out.println("Surname: ");
        String surName = scanner.nextLine().trim();

        // ændringer tilføjes sammen imorgen ift. brug af java time import & parse
        System.out.println("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

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

    }
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
}