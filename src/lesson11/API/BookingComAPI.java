package lesson11.API;

public class BookingComAPI implements API {

    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int count = 0;
        int maxPrice = price + 100;
        int minPrice = 0;

        if (price > 100)
            minPrice = price - 100;

        for (Room r : rooms)
            if (r.getPersons() == persons && r.getCityName() == city && r.getHotelName() == hotel) {
                if (r.getPrice() >= minPrice && r.getPrice() <= maxPrice)
                    count++;
            }

        Room[] suitableRooms = new Room[count];
        count = 0;

        for (Room r : rooms)
            if (r.getPersons() == persons && r.getCityName() == city && r.getHotelName() == hotel) {
                if (r.getPrice() >= minPrice && r.getPrice() <= maxPrice)
                    suitableRooms[count++] = r;
            }
        return suitableRooms;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}
