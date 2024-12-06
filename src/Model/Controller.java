package Model;

import DataSource.Filehandler;

import java.util.ArrayList;

public class Controller {
    private MemberList memberList;
    private Filehandler filehandler;

    public Controller() {
        filehandler = new Filehandler();
        ArrayList<Swimmer> loadedMembers = filehandler.loadMembers();
        memberList = new MemberList(new ArrayList<>(loadedMembers));
    }

    public MemberList getMemberList() {
        return memberList;
    }

    public Filehandler getFilehandler() {
        return filehandler;
    }
}