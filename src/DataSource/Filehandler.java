package DataSource;

import Model.Member;
import Model.Swimmer;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class Filehandler {

    private static final String FILE_PATH = "src/DataSource/Members.csv";

    // Method to load members from a CSV file
    public ArrayList<Member> loadMembers() {
        ArrayList<Member> members = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            System.out.println("CSV file not found. Returning an empty list.");
            createEmptyCSVFile(); // Create an empty CSV file
            return members;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                String surname = data[1];
                int age = Integer.parseInt(data[2]); // Parse age as an integer
                boolean isActive = Boolean.parseBoolean(data[3]);
                String address = data[4];
                int phoneNumber = Integer.parseInt(data[5]);
                String mail = data[6];
                boolean isCompetetive = Boolean.parseBoolean(data[7]);
                members.add(new Swimmer(name, surname, age, isActive, address, phoneNumber, mail, isCompetetive));
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }

        return members;
    }

    // Method to create an empty CSV file with column headers
    private void createEmptyCSVFile() {
        try (PrintWriter writer = new PrintWriter(new File(FILE_PATH))) {
            writer.println("Name,Surname,Age,Active"); // Column headers
        } catch (IOException e) {
            System.out.println("Error creating CSV file: " + e.getMessage());
        }
    }

    // Method to save members to a CSV file
    public boolean saveMember(ArrayList<Member> members) {
        try (PrintWriter writer = new PrintWriter(new File(FILE_PATH))) {
            writer.println("Name,Surname,Age,Active"); // Write column headers
            for (Member member : members) {
                writer.printf("%s,%s,%d,%b%n",
                        member.getName(),
                        member.getSurname(),
                        member.getAge(), // Write age as an integer
                        member.isActive());
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error saving members: " + e.getMessage());
            return false;
        }
    }

    // Mock implementation for loading payments (update as necessary)
    public Map<String, Double> loadPayments() {
        return Map.of();
    }
}
