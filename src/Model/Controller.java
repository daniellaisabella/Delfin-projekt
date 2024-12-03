
package Model;

import DataSource.Filehandler;

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
}