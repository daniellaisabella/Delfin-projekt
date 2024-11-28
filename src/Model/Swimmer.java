package Model;

import java.time.LocalDate;

public class Swimmer extends Member {
    // Attributes
    private String name;
    private String surName;
    private LocalDate age; // Determines if the member is junior or senior
    private boolean isActive; // Determines if the member participates actively
    private String address;
    private int phoneNumber;
    private String mail;
    private boolean isCompetetive;


    public Swimmer(String name, String surName, LocalDate age, boolean isActive, String address, int phoneNumber,String mail, boolean isCompetetive) {
        super(name, surName, age, address, phoneNumber,mail, isActive, isCompetetive);
    }

}
