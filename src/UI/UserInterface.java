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
}







