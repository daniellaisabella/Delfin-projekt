package Model;

import java.util.ArrayList;

public class MemberList {
    private ArrayList<Member> members;

    public MemberList(ArrayList<Member> memberList) {
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
}

