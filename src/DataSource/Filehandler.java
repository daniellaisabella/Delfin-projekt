package DataSource;

import Model.Member;
import Model.Swimmer;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Filehandler {
    private final String filePath = "src/DataSource/Members.csv";

    // Læs medlemmer fra filen
    public ArrayList<Swimmer> loadMembers() {
        File file = new File(filePath);
        ArrayList<Swimmer> members = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            if (scanner.hasNextLine()) {
                scanner.nextLine(); // Spring over header
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                if (data.length == 8) {
                    String name = data[0];
                    String surName = data[1];
                    int age = Integer.parseInt(data[2]);
                    String membershipType = data[3].toLowerCase(); // "active" eller "passive"
                    String address = data[4];
                    String phoneNumber = data[5];
                    String mail = data[6];
                    String memberType = data[7].toLowerCase(); // "competition" eller "fitness enthusiast"

                    Swimmer swimmer = new Swimmer(name, surName, age, address, phoneNumber, mail, membershipType, memberType);
                    members.add(swimmer);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("CSV file not found. Creating a new file.");
            createEmptyFile();
        } catch (Exception e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }

        return members;
    }

    // Gem medlemmer til filen
    public boolean saveMember(ArrayList<Member> members) {
        File file = new File(filePath);
        try (PrintStream output = new PrintStream(new FileOutputStream(file, false))) {
            output.println("Name,Surname,Age,MembershipType,Address,Phone,Email,MemberType");

            for (Member member : members) {
                output.println(
                        member.getName() + "," +
                                member.getSurname() + "," +
                                member.getAge() + "," +
                                member.getMembershipType() + "," +
                                member.getAddress() + "," +
                                member.getPhoneNumber() + "," +
                                member.getMail() + "," +
                                member.getMemberType()
                );
            }
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

//    public void deleteMember(String phone) {
//

    // Opret en tom CSV-fil, hvis den ikke findes
    private void createEmptyFile() {
        File file = new File(filePath);
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(file, false))) {
            writer.println("Name,Surname,Age,MembershipType,Address,Phone,Email,MemberType");
        } catch (IOException e) {
            System.out.println("Could not create CSV file: " + e.getMessage());
        }
    }
}
