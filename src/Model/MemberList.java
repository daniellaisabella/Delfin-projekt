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

    public void deleteMember(String phoneNumber) {
        members.removeIf(member -> (member.getPhoneNumber()) == (phoneNumber));
        if (controller.getFilehandler().saveMember(members)) {
            System.out.println("Member is deleted and changes are saved");
        } else {
            System.out.println("Failed to save changes.");
        }
    }

    public void updateMember(Member member) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).equals(member)) {
                members.set(i, member);
                break;
            }
        }
    }

}
