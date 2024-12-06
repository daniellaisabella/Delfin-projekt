package Model;

public class Controller {
    private MemberList memberList;

    public Controller() {
        this.memberList = new MemberList(); // Initialiserer MemberList
    }

    public MemberList getMemberList() {
        return memberList;
    }

    public Filehandler getFilehandler() {
        return new Filehandler();
    }
}
