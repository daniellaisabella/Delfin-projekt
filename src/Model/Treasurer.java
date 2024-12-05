package Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Treasurer extends User {

    private double totalPaid; // Holder styr på faktiske betalinger

    public Treasurer(String username, String password) {
        super(username, password);
        this.totalPaid = 0; // Initialiser med 0
    }

    // Vis forventede betalinger baseret på medlemmernes kontingent
    public void viewExpectedPayments(ArrayList<Member> members) {
        System.out.println("\n--- Expected Payments ---");
        double totalExpected = calculateTotalExpected(members); // Udregner forventet betaling
        System.out.println("Members: " + members.size());
        System.out.println("Next payment due 31.12.2024:");
        System.out.println("Total Expected Payments: " + totalExpected + " DKK");
        System.out.println("Actual payments: " + totalPaid + " DKK");
        System.out.println("Outstanding payments: " + calculateArrears(members) + " DKK");
    }

    // Registrer modtaget betaling og opdater faktiske betalinger
    public void registerPayment(ArrayList<Member> members) {
        if (members == null || members.isEmpty()) {
            System.out.println("Error: No members available to calculate payments.");
            return; // Stop, hvis medlemslisten er tom
        }
        System.out.print("Enter received payment here: ");
        Scanner scanner = new Scanner(System.in);
        try {
            double payment = scanner.nextDouble();
            totalPaid += payment; // Tilføj betalingen til totalPaid
            System.out.println("Payment Received: " + payment + " DKK");
            System.out.println("Total Actual Payments Updated: " + totalPaid + " DKK");
            System.out.println("Outstanding Payments: " + calculateArrears(members) + " DKK"); // Opdater udestående betaling
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine(); // Ryd scanneren for forkert input
        }
    }

    // Vis faktisk betalinger
    public void bookkeeping() {
        System.out.println("\n--- Actual Payments ---");
        System.out.println("Total Actual Payments: " + totalPaid + " DKK");
    }

    // Udregn og vis restance (forventede betalinger minus faktiske betalinger)
    public double calculateArrears(ArrayList<Member> members) {
        if (members == null || members.isEmpty()) {
            System.out.println("Error: No members available to calculate arrears.");
            return 0; // Returner 0, hvis medlemslisten er tom
        }
        double totalExpected = calculateTotalExpected(members); // Udregner forventet betaling
        double arrears = totalExpected - totalPaid; // Beregn restance
        return arrears;
    }

    // Beregn samlet forventet betaling
    private double calculateTotalExpected(ArrayList<Member> members) {
        double totalExpected = 0;
        for (Member member : members) {
            totalExpected += member.getMembershipPrice();
        }
        return totalExpected;
    }

    @Override
    public void displayMenu() {
        System.out.println("\n--- Treasurer Menu ---");
        System.out.println("[1] View expected payments");
        System.out.println("[2] View actual payments");
        System.out.println("[3] Register received payment");
        System.out.println("[4] Calculate arrears");
        System.out.println("[0] Logout");
    }
}
