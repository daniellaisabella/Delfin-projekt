package Model;

import java.util.ArrayList;

public class Treasurer extends User {

    public Treasurer(String username, String password) {
        super(username, password);
    }

    // Vis forventede betalinger baseret på medlemmernes kontingent
    public void viewExpectedPayments(ArrayList<Member> members) {
        System.out.println("\n--- Expected Payments ---");
        double totalExpected = 0;

        for (Member member : members) {
            totalExpected += member.getMembershipPrice();
        }
        System.out.println("Members:" + members.size());
        System.out.println();
        System.out.println("- Next payment due 31.12.2024 -");
        System.out.println("Outstanding payments: " + calculateArrears(members) + " DKK");
    }

    // Vis faktisk betaling (f.eks. ved at simulere betalte medlemmer)
    public void bookkeeping(ArrayList<Member> members) {
        System.out.println("\n--- Actual Payments ---");
        double totalPaid = 0;

        // Simuler faktiske betalinger (her antager vi, at nogle medlemmer har betalt)
        for (Member member : members) {
            if (member.hasPaid()) { // Forudsætter, at `Member` har en `hasPaid`-metode
                System.out.printf("Name: %s %s, Membership Type: %s, Price Paid: %d%n",
                        member.getName(), member.getSurname(), member.getMembershipType(), member.getMembershipPrice());
                totalPaid += member.getMembershipPrice();
            }
        }

        System.out.println("Total Actual Payments: " + totalPaid + " DKK");

        System.out.println("debug register payments here - switch/scanner");


    }

    // Udregn og vis restance (forventede betalinger minus faktiske betalinger)
    public double calculateArrears(ArrayList<Member> members) {
        System.out.println("\n--- Arrears Calculation ---");
        double totalExpected = 0;
        double totalPaid = 0;

        for (Member member : members) {
            totalExpected += member.getMembershipPrice();
            if (member.hasPaid()) {
                totalPaid += member.getMembershipPrice();
            }
        }

        double arrears = totalExpected - totalPaid;
        System.out.println("Total Expected Payments: " + totalExpected + " DKK");
        System.out.println("Total Actual Payments: " + totalPaid + " DKK");
        System.out.println("Total Arrears (Outstanding Payments): " + arrears + " DKK");
        return totalExpected;
    }

    @Override
    public void displayMenu() {
        System.out.println("\n--- Treasurer Menu ---");
        System.out.println("[1] View expected payments");
        System.out.println("[2] View actual payments");
        System.out.println("[3] Calculate arrears");
        System.out.println("[0] Logout");
    }
}
