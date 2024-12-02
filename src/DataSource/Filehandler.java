package DataSource;

import Model.Member;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class Filehandler {

    private static final String FILE_PATH = "members.csv";

    public ArrayList<Member> loadMembers() {
        ArrayList<Member> members = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            System.out.println("CSV file not found. Returning an empty list.");
            createEmptyCSVFile(); // Opret en tom CSV-fil
            return members;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Parse og tilføj medlemmer til listen (implementér parsing efter behov)
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }

        return members;
    }

    private void createEmptyCSVFile() {
        try (PrintWriter writer = new PrintWriter(new File(FILE_PATH))) {
            writer.println("Name,Surname,Age,Active"); // Kolonnenavne, tilpas efter dit format
        } catch (IOException e) {
            System.out.println("Error creating CSV file: " + e.getMessage());
        }
    }

    public boolean saveMember(ArrayList<Member> members) {
        try (PrintWriter writer = new PrintWriter(new File(FILE_PATH))) {
            for (Member member : members) {
                writer.printf("%s,%s,%d,%b%n",
                        member.getName(),
                        member.getSurname(),
                        member.getAge(),
                        member.isActive());
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error saving members: " + e.getMessage());
            return false;
        }
    }

    public Map<String, Double> loadPayments() {
        return Map.of();
    }
}
