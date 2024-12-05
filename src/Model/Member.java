package Model;

public abstract class Member {
    private String name;
    private String surname;
    private int age;
    private String address;
    private String phoneNumber;
    private String mail;
    private String membershipType; // "active" or "passive"
    private String memberType;     // "competition" or "fitness enthusiast"
    private int membershipPrice;   // Price for membership
    private boolean hasPaid;       // Simulerer om medlemmet har betalt

    public Member(String name, String surname, int age, String address, String phoneNumber, String mail, String membershipType, String memberType) {
        this.name = capitalizeFirstLetter(name);
        this.surname = capitalizeFirstLetter(surname);
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.membershipType = validateMembershipType(membershipType);
        this.memberType = validateMemberType(memberType);
        this.membershipPrice = calculateMembershipPrice();
        this.hasPaid = false; // Default er, at medlemmet ikke har betalt
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

    private int calculateMembershipPrice() {
        if (membershipType.equals("passive")) {
            return 500; // Passive membership price
        } else if (age < 18) {
            return 1000; // Active junior price
        } else if (age < 60) {
            return 1600; // Active senior price
        } else {
            return 1200; // Active retiree price
        }
    }

    public boolean hasPaid() {
        return hasPaid;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
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

    public String getPhoneNumber() {
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

    public int getMembershipPrice() {
        return membershipPrice;
    }

    @Override
    public String toString() {
        return String.format(
          "Name: %s %s, Age: %d, Address: %s, Phone: %s, Email: %s, Membership Type: %s, Member Type: %s, Membership Price: %d",
                name, surname, age, address, phoneNumber, mail, membershipType, memberType, membershipPrice
        );
    }
}
