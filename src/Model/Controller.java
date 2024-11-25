package Model;
import java.util.ArrayList;

public class Controller {
    private MemberList memberList;

    public Controller() {
        memberList = new MemberList(new ArrayList<>());
    }

    public MemberList getMemberList() {
        return memberList;
    }


}
