package DataSource;

import Model.Swimmer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Filehandler {
    private final String filePatch = "Members.txt";
    ArrayList<Swimmer> members = new ArrayList<>();

    public ArrayList<Swimmer> loadMembers() {

        try {
            // Check if file exists before trying to read
            if (!Files.exists(Paths.get(filePatch))) {
                System.out.println("File not found. Returning an empty member list.");
                return members;
            }

            try (Stream<String> lines = Files.lines(Paths.get(filePatch))) {
                lines.forEach(line -> {
                    String[] data = line.split(",");
                    if (data.length == 7) {
                        String name = data[0];
                        String surName = data[1];
                        LocalDate age = LocalDate.parse(data[2], DateTimeFormatter.ISO_LOCAL_DATE);
                        boolean isActive = Boolean.parseBoolean(data[3]);
                        String address = data[4];
                        int phoneNumber = Integer.parseInt(data[5]);
                        boolean isCompetetive = Boolean.parseBoolean(data[6]);


                        members.add(new Swimmer(name, surName, age, isActive, address, phoneNumber, isCompetetive));


                    }
                });
            }


            System.out.println("Loaded " + members.size() + " members from the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return members;

    }

    public boolean saveMember(ArrayList<Swimmer> members) {
        try (PrintStream output = new PrintStream(new File(filePatch))) {
            System.out.println("Saving " + members.size() + " movies to the file.");
            for (Swimmer m : members) {
                output.println(m.getName() + "," + m.getSurName() + "," + m.getAge() + "," + m.isActive() + "," + m.getAddress() + "," + m.getPhoneNumber() + "," + m.isCompetetive());
            }
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;

        }
    }
}



