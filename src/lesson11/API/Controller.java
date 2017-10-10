package lesson11.API;

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
        for (int i = 0; i < api1.getAll().length; i++)
        {
            for (Room api2Room : api2.getAll())
            {
                if(api1.getAll()[i].getPersons() == api2Room.getPersons()
                        && api1.getAll()[i].getPrice() == api2Room.getPrice()
                        && api1.getAll()[i].getHotelName() == api2Room.getHotelName()
                        && api1.getAll()[i].getCityName() == api2Room.getCityName())
                    count++;
            }
        }

        Room[] sameRooms = new Room[count];
        count = 0;

        for (int i = 0; i < api1.getAll().length; i++)
        {
            for (Room api2Room : api2.getAll())
            {
                if(api1.getAll()[i].getPersons() == api2Room.getPersons()
                        && api1.getAll()[i].getPrice() == api2Room.getPrice()
                        && api1.getAll()[i].getHotelName() == api2Room.getHotelName()
                        && api1.getAll()[i].getCityName() == api2Room.getCityName())
                    sameRooms[count++] = api1.getAll()[i];
            }
        }

        return sameRooms;
    }
}
