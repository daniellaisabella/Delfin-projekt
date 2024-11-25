package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MemberList {
    private ArrayList<Member> members;

    public membershipManagement() {
        this.members = new ArrayList<>();
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public ArrayList<Member> getMembers() {
        return members;
    }




}
