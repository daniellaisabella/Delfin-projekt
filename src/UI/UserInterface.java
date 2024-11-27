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
        System.out.println("1. Enter the following number [1] or 'add' or to register a new member to the club");
        System.out.println("2. Enter the following number [2] or 'members' to view the list of members");
        System.out.println("3. Enter the following number [3] or 'exit' to exit the program");
    }

    public void startProgram() {
        boolean running = true;
        displayMenu();

        while (running) {
            String choice = scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "add", "1" -> addMember();
                case "members", "2" -> showMembers();
                case "exit", "0" -> {
                    System.out.println("Exiting program...");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addMember() {
        System.out.println("[Please enter the following details to register a new member]");
        System.out.println("\nFirst name: ");
        String name = scanner.nextLine().trim();

        System.out.println("Surname: ");
        String surName = scanner.nextLine().trim();

        System.out.println("Date of birth [DD-MM-YYYY]: ");
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
}