package ClassRelationship;


class Address{
    Double id;
    String street;
    Integer streetHouseNo;

    Address(String street, Integer streetHouseNo){
        this.id = Math.random();
        this.street = street;
        this.streetHouseNo = streetHouseNo;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", streetHouseNo=" + streetHouseNo +
                '}';
    }
}

class User{
    Double id;
    String name;
    String type;
    Address address; // user has-a address, but without user also address exists

    User(String name, String type, Address address){
        this.id = Math.random();
        this.name = name;
        this.type = type;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", address=" + address +
                '}';
    }
}

public class Aggregation {
    public static void main(String[] args) {

        Address address = new Address("Ayodhya", 1);
        User user = new User("Ram", "User", address);
        System.out.println(user.toString());
    }
}


/*
 * Aggregation (Weak "has-a"): An object contains other objects, but they can exist independently.
 * A Department has Professors. If the department is closed, the professors still exist.
 */