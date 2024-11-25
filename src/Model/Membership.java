package Model;

public class Membership extends Member {

    public Membership(String name, int age, boolean active, boolean junior, boolean fitnessEnthusiast) {
        super(name, age, active, junior, fitnessEnthusiast);
    }

    @Override
    public double calculateContingent() {
        return 0;
    }

    //PASSIVE - 500 DKK
    //ACTIVE JUNIOR - 1000 DKK
    //ACTIVE SENIOR - 1600 DKK
    //ACTIVE PENSIONIST - 1200 DKK
    //Constructor -

}