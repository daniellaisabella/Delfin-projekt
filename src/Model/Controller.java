package Model;
import DataSource.Filehandler;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Controller {
    private MemberList memberList;
    private Filehandler filehandler;

    public Controller() {
        memberList = new MemberList(new ArrayList<>());
        filehandler = new Filehandler();

    }

    public MemberList getMemberList() {
        return memberList;
    }
public void loadMembers() throws FileNotFoundException {

    ArrayList<Swimmer> loadedMembers = filehandler.loadMembers();
    if (loadedMembers!= null) {
        memberList.addMembers(loadedMembers);  // Update the memberlist  with the loaded members
    } else {
        System.out.println("No movies found in file.");
    }
}


    public void saveMember() throws FileNotFoundException {
        // Load existing movies from the file

        ArrayList<Swimmer> existingMembers = filehandler.loadMembers();  // Load existing movies

        // Get the current list of members from the memberlist (including newly added ones)
        ArrayList<Member> members = memberList.getMembers();  // Get current memberlist

        // Add new members that are not already in the file
        for (Member newMembers : members) {
            boolean exists = existingMembers.stream()
                    .anyMatch(movie -> movie.getName().equalsIgnoreCase(newMembers.getName()));  // Check if movie already exists

            if (!exists) {
                existingMembers.add((Swimmer) newMembers);  // Add the movie to the existing list if it doesn't exist
            }
        }

        // Save the updated member list back to the file

        filehandler.saveMember(existingMembers);

        // Log the number of movies saved
        System.out.println("Saving " + existingMembers.size() + " members to the file.");
    }




}
