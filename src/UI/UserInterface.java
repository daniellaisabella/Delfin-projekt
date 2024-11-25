package UI;
import model.Controller;
import java.util.Scanner;

public class UserInterface {
    private Controller controller;
    private Scanner scanner;

    public UserInterface() {
        this.controller = new Controller();
        this.scanner = new Scanner(System.in);
    }

    void displayMenu() {
        System.out.println("\n---- Administration ----");
        System.out.println("Type 'add' to add a member to the swimming club");
        System.out.println("Type 'members' to show the member list");
    }

    public void startProgram() {
        boolean running = true;
        displayMenu();

        try {
            while (running) {
                String choice = scanner.nextLine().trim().toLowerCase();

                switch (choice) {

                    case "add", "1" -> addMember();
                    case "Members", "2" -> showMembers();
                }

                private void addMember() {
                    System.out.println("Enter member full name");
                    String name = scanner.nextLine().trim();

                    System.out.println("Enter member date of birth DD/MM/YYYY");
                    int age = scanner.nextInt();

                    System.out.println("Enter member address, streetname, housenumber, city, zipcode");
                    String address = scanner.nextLine().trim();

                    System.out.println("Enter member phonenumber");
                    int phoneNumber = scanner.nextInt();

                    System.out.println("Enter member member type, active or passive");
                    String memberType = scanner.nextLine().trim();
                }

                private void showMembers() {
                    ArraList<Member> members = controller.getMembersCollection().getMembers();

                    if (members.isEmpty()) {
                        System.out.println("No members on the list");
                    } else {
                        System.out.println("Members on the list: ");
                        for (Member member : member) ;
                        System.out.println();
                        System.out.println(member);
                    }
                }
            }
        }
    }










