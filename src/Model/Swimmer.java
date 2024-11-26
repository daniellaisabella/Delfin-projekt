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


    public Swimmer(String name, int age, String address, int phoneNumber, boolean isActive, boolean isCompetetive) {
        super(name, age, address, phoneNumber, isActive, isCompetetive);
    }

    @Override
    public double calculateContingent() {
        return 0;
    }
}
