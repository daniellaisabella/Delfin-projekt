package Model;

public class Swimmer extends Member {
    private String name;
    private int age;
    private String phoneNumber;
    private Team team;

    public Swimmer(String name, String surName, int age, String address, String phoneNumber, String mail, String membershipType, String memberType) {
        super(name, surName, age, address, phoneNumber, mail, membershipType, memberType);
        this.team = (age < 18) ? Team.JUNIOR : Team.SENIOR;
    }

    //---------------------------- Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}





