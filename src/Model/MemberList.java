package Model;

import java.util.ArrayList;

public class MemberList {
    private ArrayList<Member> members;
    private Controller controller;

    // Konstruktør der tager controller som parameter
    public MemberList(ArrayList<Member> memberList, Controller controller) {
        this.controller = controller;  // Brug den controller, der bliver sendt ind
        this.members = memberList;
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public Member getMemberByUsername(String username) {
        return null;
    }

    public void deleteMember(String phoneNumber) {
        members.removeIf(member -> Integer.parseInt(member.getPhoneNumber()) == Integer.parseInt(phoneNumber));
        if (controller.getFilehandler().saveMember(members)) {
            System.out.println("Member is deleted and changes are saved");
        } else {
            System.out.println("Failed to save changes.");
        }
    }
}
