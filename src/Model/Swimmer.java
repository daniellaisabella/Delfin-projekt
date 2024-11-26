package Model;

public class Swimmer extends Member {
    // Attributes
    private String name;
    private String surName;
    private int age; // Determines if the member is junior or senior
    private boolean isActive; // Determines if the member participates actively
    private String address;
    private int phoneNumber;
    private boolean isCompetetive;


    public Swimmer(String name, String surName, int age, boolean isActive, String address, int phoneNumber, boolean isCompetetive) {
        super(name, surName, age, address, phoneNumber, isActive, isCompetetive);
    }

}
