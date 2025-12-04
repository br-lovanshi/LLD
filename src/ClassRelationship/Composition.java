package ClassRelationship;
class Room{
}
class House{
    Room room; // without house rooms does not exists.

    House(Room room){
        this.room = room;
    }
}

public class Composition {
    public static void main(String[] args) {
        House house = new House(new Room());

    }
}


//Composition: Strong has-a relationship

/**
 * Composition (Strong "has-a"): An object is composed of other objects, and their lifecycles are tied.
 * A House is composed of Rooms. If you demolish the house, the rooms are destroyed with it.
 * Product - Order
 * Order - Payment
 */