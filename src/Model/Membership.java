package Model;

public class Membership extends Member {
    private String membershipType; // "active" or "passive"

    public Membership(String name, String surname, int age, String address, String phoneNumber, String mail, String membershipType, String memberType) {
        super(name, surname, age, address, phoneNumber, mail, membershipType, memberType);
    }


    // Getter for membershipType
    public String getMembershipType() {
        return membershipType;
    }

    // Override toString for detailed member information
    @Override
    public String toString() {
        return String.format(

                "Name: %s %s, Age: %d, Membership Type: %s, Address: %s, Phone: %d, Email: %s",
                getName(), getSurname(), getAge(), membershipType, getAddress(), getPhoneNumber(), getMail()
        );
    }
}