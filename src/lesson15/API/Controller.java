package lesson15.API;

public class Controller {

    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel)
    {
        int count = 0;
        for (API a : apis)
        {
            Room[] apiRooms = a.findRooms(price, persons, city, hotel);
            count += apiRooms.length;
        }

        Room[] totalRooms = new Room[count];
        count = 0;

        for (API a : apis)
        {
            Room[] apiRooms = a.findRooms(price, persons, city, hotel);
            for (Room r : apiRooms)
                totalRooms[count++] = r;
        }
        return totalRooms;
    }

    public Room[] check(API api1, API api2)
    {
        int count = 0;
        for (Room api1Room : api1.getAll())
        {
            for (Room api2Room : api2.getAll())
            {
                if(api1Room.equals(api2Room))
                    count++;
            }
        }

        Room[] sameRooms = new Room[count];
        count = 0;

        for (Room api1Room : api1.getAll())
        {
            for (Room api2Room : api2.getAll())
            {
                if(api1Room.equals(api2Room))
                    sameRooms[count++] = api1Room;
            }
        }

        return sameRooms;
    }
}
