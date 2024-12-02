
package Model;

import DataSource.Filehandler;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Controller {
    private MemberList memberList;  // Manages the list of members
    private Filehandler filehandler;  // Handles file input/output

    public Controller() {
        memberList = new MemberList(new ArrayList<>());
        filehandler = new Filehandler();
    }

    public MemberList getMemberList() {
        return memberList;
    }

    // Load members from file and add them to the member list
    public void loadMembers() throws FileNotFoundException {
        ArrayList<Member> loadedMembers = filehandler.loadMembers();  // Load members from file
        if (loadedMembers != null && !loadedMembers.isEmpty()) {
            for (Member member : loadedMembers) {
                memberList.addMember(member);  // Update member list with individual members
            }
            System.out.println("Loaded " + loadedMembers.size() + " members from file.");
        } else {
            System.out.println("No members found in the file.");
        }
    }

    // Save the current list of members to the file
    public void saveMember() throws FileNotFoundException {
        // Get current list of members from memberList
        ArrayList<Member> members = memberList.getMembers();

        for (Member member : memberList.getMembers()) {
            if (member instanceof Swimmer) {
                members.add((Swimmer) member);
            }
        }
        // If there are no members to save, print a message and return
        if (members.isEmpty()) {
            System.out.println("No members to save.");
            return;
        }

        // Save members to file
        boolean success = filehandler.saveMember(members);

        if (success) {
            System.out.println("Saving " + members.size() + " members to the file.");
        } else {
            System.out.println("Failed to save members.");
        }
    }

    // Add a member to the member list
    public void addMember(Swimmer newMember) {
        memberList.addMember(newMember);
    }
}

//package Model;
//import java.util.ArrayList;
//
//public class Controller {
//    private MemberList memberList;
//    private Member members;
//
//    public Controller() {
//        memberList = new MemberList(new ArrayList<>());
//    }
//
//    public MemberList getMemberList() {
//        return memberList;
//    }
//
//    public Member getMemberByUsername(String username) {
//        for (Member member : memberList.getMembers()) {
//            if (member.getUsername().equalsIgnoreCase(username)) {
//                return member;
//            }
//        }
//        return null;
//    }
//}


