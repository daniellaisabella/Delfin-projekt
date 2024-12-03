package DataSource;
import Model.Member;
import Model.Swimmer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Filehandler {
    private final String filePath = "src/DataSource/Members.csv";
    ArrayList<Swimmer> members = new ArrayList<>();

    public ArrayList<Swimmer> loadMembers() {
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {

            scanner.nextLine();  // Skip the header line
            System.out.println();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                if (data.length == 8) {
                    String name = data[0];
                    String surName = data[1];
                    int age = Integer.parseInt(data[2]);
                    boolean isActive = Boolean.parseBoolean(data[3]);
                    String address = data[4];
                    int phoneNumber = Integer.parseInt(data[5]);
                    String mail = data[6];
                    boolean isCompetetive = Boolean.parseBoolean(data[7]);

                    members.add(new Swimmer(name, surName, age, isActive, address, phoneNumber, mail, isCompetetive));


                }
            }


            System.out.println("Loaded " + members.size() + " members from the CSV file.");
        } catch (FileNotFoundException e) {
            System.out.println("CSV file not found. Returning an empty list.");
        } catch (Exception e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
        return members;
    }


    public boolean saveMember(ArrayList<Member> members) {
        try (PrintStream output = new PrintStream(filePath)) {
            System.out.println("Saving " + members.size() + " movies to the file.");
            for (Member m : members) {
                output.println(m.getName() + "," + m.getSurname() + "," + m.getAge() + "," + m.isActive() + "," + m.getAddress() + "," + m.getPhoneNumber() + "," + m.getMail() + "," + m.isCompetitive());
            }
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;

        }
    }

    public Map<String, Double> loadPayments() {
        return Map.of();
    }
}



