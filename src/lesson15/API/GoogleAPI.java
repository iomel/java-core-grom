package lesson15.API;

public class GoogleAPI implements API {
    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int count = 0;
        for (Room r : rooms)
            if(r.getPrice() == price && r.getPersons() == persons && r.getCityName().equals(city) && r.getHotelName().equals(hotel))
                count++;

        Room[] suitableRooms = new Room[count];
        count = 0;

        for (Room r : rooms)
            if(r.getPrice() == price && r.getPersons() == persons && r.getCityName().equals(city) && r.getHotelName().equals(hotel))
                suitableRooms[count++] = r;

        return suitableRooms;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}
