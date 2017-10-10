package lesson11.API;

public class TripAdvisorAPI implements API {

    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int count = 0;
        int maxPers = persons + 1;
        int minPers = persons - 1;

        for (Room r : rooms)
            if (r.getPrice() == price && r.getCityName() == city && r.getHotelName() == hotel) {
                if (r.getPersons() >= minPers && r.getPersons() <= maxPers)
                    count++;
            }

        Room[] suitableRooms = new Room[count];
        count = 0;

        for (Room r : rooms)
            if (r.getPrice() == price && r.getCityName() == city && r.getHotelName() == hotel) {
                if (r.getPersons() >= minPers && r.getPersons() <= maxPers)
                    suitableRooms[count++] = r;
            }
                return suitableRooms;

    }


    @Override
    public Room[] getAll() {
        return rooms;
    }
}
