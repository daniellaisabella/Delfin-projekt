package Model;
import java.util.ArrayList;

public class Controller {
    private MemberList memberList;
    private Member members;

    public Controller() {
        memberList = new MemberList(new ArrayList<>());
    }

    public MemberList getMemberList() {
        return memberList;
    }

    public Member getMemberByUsername(String username) {
        for (Member member : memberList.getMembers()) {
            if (member.getUsername().equalsIgnoreCase(username)) {
                return member;
            }
        }
        return null;
    }
}


