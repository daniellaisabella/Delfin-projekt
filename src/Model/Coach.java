package Model;

import java.util.Scanner;

public class Coach extends User {

    public Coach(String username, String password){
        super(username, password);
    }

    public void viewTopSwimmers(Scanner scanner, Controller controller) {
        System.out.println("Top 5 swimmers by Stroke type:");
        System.out.println("Choose swimming stroke: [1] Butterfly, [2] Crawl, [3] Backstroke, [4] Breaststroke ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        String swimStroke = switch (choice){
            case 1 -> "Butterfly";
            case 2 -> "Crawl";
            case 3 -> "Backstroke";
            case 4 -> "Breaststroke";
            default -> throw new IllegalArgumentException("Invalid choice");
        };


    }
}
