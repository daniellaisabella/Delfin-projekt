package DataSource;

import Model.Member;
import Model.Swimmer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Filehandler {
    private final String filePath = "src/DataSource/Members.csv";

    public ArrayList<Swimmer> loadMembers() {
        File file = new File(filePath);
        ArrayList<Swimmer> members = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            if (scanner.hasNextLine()) {
                scanner.nextLine(); // Skip header line
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                if (data.length == 8) {
                    String name = data[0];
                    String surName = data[1];
                    int age = Integer.parseInt(data[2]);
                    String membershipType = data[3].toLowerCase(); // "active" or "passive"
                    String address = data[4];
                    int phoneNumber = Integer.parseInt(data[5]);
                    String mail = data[6];
                    String memberType = data[7].toLowerCase(); // "competition" or "fitness enthusiast"

                    // Create a new Swimmer object
                    Swimmer swimmer = new Swimmer(name, surName, age, address, phoneNumber, mail, membershipType, memberType);
                    members.add(swimmer);
                }
            }

            System.out.println("Loaded " + members.size() + " members.");
        } catch (FileNotFoundException e) {
            System.out.println("CSV file not found. Returning an empty list.");
        } catch (Exception e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }

        return members;
    }

    public boolean saveMember(ArrayList<Member> members) {
        File file = new File(filePath);
        try (PrintStream output = new PrintStream(new FileOutputStream(file, false))) {
            // Write header line
            output.println("Name,Surname,Age,MembershipType,Address,Phone,Email,MemberType");

            System.out.println("Saving " + members.size() + " members to the file.");
            for (Member m : members) {
                // Cast to Swimmer since Member is abstract
                if (m instanceof Swimmer) {
                    Swimmer swimmer = (Swimmer) m;
                    output.println(
                            swimmer.getName() + "," +
                                    swimmer.getSurname() + "," +
                                    swimmer.getAge() + "," +
                                    swimmer.getMembershipType() + "," +
                                    swimmer.getAddress() + "," +
                                    swimmer.getPhoneNumber() + "," +
                                    swimmer.getMail() + "," +
                                    swimmer.getMemberType()
                    );
                }
            }
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
