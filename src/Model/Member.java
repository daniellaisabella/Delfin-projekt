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



    // *** GETTER *** //

    public String getName() {
        return name;
    }

    public int getAge(){
        return age;
    }

    public boolean getActive(){
        return active;
    }

    public boolean getJunior(){
        return junior;
    }

    public boolean getFitnessEnthuisiast(){
        return fitnessEnthusiast;
    }

    // *** SETTER *** //

    public String setName() {
        return name;
    }

    public int setAge(){
        return age;
    }

    public boolean setActive(){
        return active;
    }

    public boolean setJunior(){
        return junior;
    }

    public boolean setFitnessEnthuisiast(){
        return fitnessEnthusiast;
    }

}
