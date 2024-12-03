package Model;

import java.util.Scanner;

public class Coach extends User {

    public Coach(String username, String password){
        super(username, password);
    }

    public void viewTopSeniorSwimmers(Scanner scanner, Controller controller) {
        System.out.println("Top 5 swimmers by Stroke type:");
        System.out.println("Choose swimming stroke: [1] Butterfly, [2] Crawl, [3] Back crawl, [4] Breaststroke ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        String swimStroke = switch (choice){
            case 1 -> "Butterfly";
            case 2 -> "Crawl";
            case 3 -> "Back crawl";
            case 4 -> "Breaststroke";
            default -> throw new IllegalArgumentException("Invalid choice");
        };


    }
    //------------------Top Junior Swimmers---------------------
    public void viewTopJuniorSwimmers(Scanner scanner, Controller controller) {
        System.out.println("Top 5 Junior swimmers by Stroke type:");
        System.out.println("Choose swim stroke: [1] Butterfly, [2] Crawl, [3] Back crawl, [4] Breaststroke ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        String swimStroke = switch (choice){
            case 1 -> "Butterfly";
            case 2 -> "Crawl";
            case 3 -> "Back crawl";
            case 4 -> "Breaststroke";
            default -> throw new IllegalArgumentException("Invalid choice");
        };


    }

    @Override
    public void displayMenu() {
        System.out.println("\n---- Coach Menu ----");
        System.out.println("1. View all members");
        System.out.println("2. View top swimmers by stroke category");
        System.out.println("3. Register and edit time performance");
        System.out.println("0. Exit");
    }

    
}
