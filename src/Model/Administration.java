package Model;

public class Administration extends User {

    public Administration(String username, String password){
        super(username, password);
    }

    @Override
    public void displayMenu() {
        System.out.println("Welcome Administration!");
        System.out.println("1. View all members");
        System.out.println("2. Register a new member");
        System.out.println("3. Manage user permission");
        System.out.println("0. Exit");
    }

}


