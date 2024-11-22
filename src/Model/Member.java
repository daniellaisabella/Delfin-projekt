package Model;

public abstract class Member {

    //Attributes
    private String name;
    private int age;
    private boolean active;
    private boolean junior;
    private boolean fitnessEnthusiast;
    // Medlemsskabs nr.?

    //Constructor -
    public Member(String name, int age, boolean active, boolean junior, boolean fitnessEnthusiast) {
        this.name = name;
        this.age = age;
        this.active = active;
        this.junior = junior;
        this.fitnessEnthusiast = fitnessEnthusiast;
    }

    //Constructor - Membership
    public Member( int age, boolean active, boolean junior, boolean fitnessEnthusiast) {
        this.age = age;
        this.active = active;
        this.junior = junior;
        this.fitnessEnthusiast = fitnessEnthusiast;
    }

}
