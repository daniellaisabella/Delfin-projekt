package Model;

public abstract class Member {
    private String name;
    private String surname;
    private int age;
    private String address;
    private int phoneNumber;
    private String mail;
    private String membershipType; // "active" or "passive"
    private String memberType;     // "competition" or "fitness enthusiast"

    public Member(String name, String surname, int age, String address, int phoneNumber, String mail, String membershipType, String memberType) {
        this.name = capitalizeFirstLetter(name);
        this.surname = capitalizeFirstLetter(surname);
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.membershipType = validateMembershipType(membershipType);
        this.memberType = validateMemberType(memberType);
    }

    private String capitalizeFirstLetter(String word) {
        if (word == null || word.isEmpty()) {
            return "";
        }
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

    private String validateMembershipType(String type) {
        if (!type.equalsIgnoreCase("active") && !type.equalsIgnoreCase("passive")) {
            throw new IllegalArgumentException("Invalid membership type. Must be 'active' or 'passive'.");
        }
        return type.toLowerCase();
    }

    private String validateMemberType(String type) {
        if (!type.equalsIgnoreCase("competition") && !type.equalsIgnoreCase("fitness enthusiast")) {
            throw new IllegalArgumentException("Invalid member type. Must be 'competition' or 'fitness enthusiast'.");
        }
        return type.toLowerCase();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public String getMemberType() {
        return memberType;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s, Age: %d, Address: %s, Phone: %d, Email: %s, Membership Type: %s, Member Type: %s",
                name, surname, age, address, phoneNumber, mail, membershipType, memberType);
    }
}
