package UI;
import java.io.FileNotFoundException;
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
        System.out.println("Type 'load' or '5' to load members from a file");
        System.out.println("Type 'save' or '6' to save members to a file");

        System.out.println("Type'delete' or '7' to delete a member from the list");
        System.out.println("Type 'exit' or '0' to exit the program");
    }

    public void startProgram() {
        boolean running = true;


        while (running) {
            System.out.print("Enter your choice: ");
            displayMenu();
            String choice = scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "add", "1" -> addMember();
                case "members", "2" -> showMembers();
                case "5", " load" -> {
                    try {
                        controller.loadMembers();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "6", "save" -> {
                    try {
                        controller.saveMember();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
//                case "delete", "7" -> {
//                    System.out.println("Enter member name to delete:");
//                    String name = scanner.nextLine().trim();
//                    controller.deleteMember(name);
//                    System.out.println("Member deleted successfully!");
//                }
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


        // evt. tilføj medlemsskabstype til member/swimmer
        Swimmer newMember = new Swimmer(name, surName, age, isActive, address, phoneNumber, isCompetitive, MembershipType.JUNIOR);
        controller.getMemberList().addMember(newMember);
        System.out.println("Member added successfully!");

        //medlemsskabstype og pris if no = passive 500 DK if yes junior? senior? retiree? + sout type + contingent
// opret ENUM konstant som kan printes i SOUT med contingent pris

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

    // Delete member from memberlist method
    private void deleteMovie() {
        System.out.print("Enter the title of the movie to delete: ");
        String title = scanner.nextLine().trim();
        controller.().deleteMovie(title);
        System.out.println("Movie deleted successfully.");
    }
}

