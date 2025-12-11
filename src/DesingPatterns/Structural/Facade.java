package DesingPatterns.Structural;

class ValetParking{

}
class FoodService{

}
class HouseKeeping{

}
class HotelFacade{

    ValetParking valetParking;
    FoodService foodService;
    HouseKeeping houseKeeping;
}
public class Facade {
    public static void main(String[] args) {
        HotelFacade hotelFacade = new HotelFacade();

    }
}
