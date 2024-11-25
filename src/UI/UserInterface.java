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
        System.out.println("\n---- Administation ----");
        System.out.println("Type 'add' to add a member to the swimming club");
        System.out.println("Type 'members' to show the member list");
    }

    public void startProgram() {
        boolean running = true;
        displayMenu();


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

                    System.out.println("Is the member active? Yes or No");
                    boolean isActive = scanner.nextLine().trim().equalsIgnoreCase("yes");

                    System.out.println("Is the member a competetive swimmer? Yes or No");
                    boolean isCompetetive = scanner.nextLine().trim().equalsIgnoreCase("yes");

                    Member newMember = new Member(name, age, address, phoneNumber, isActive, isCompetetive);
                    controller.getMemberList().addMember(newMember);
                    System.out.println("Member added successfully!);
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













