package Model;

import Model.Membership;
import Model.MembershipType;

public class Treasurer extends User {



        public Treasurer(String username, String password){
            super(username, password);
        }

    @Override
    public void displayMenu() {
        System.out.println("Welcome Treasurer!");
        System.out.println("1. View total income");
        System.out.println("2. View members in arrears");
        System.out.println("0. Exit");

    }


    }

