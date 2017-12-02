package final_project.controllers;

import final_project.models.Hotel;
import final_project.services.HotelService;

import java.io.IOException;
import java.util.ArrayList;

public class HotelController {
    private HotelService hotelService = new HotelService();

    public ArrayList<Hotel> findHotelByName(String name) throws Exception {
        return hotelService.findHotelByName(name);
    }

    public ArrayList<Hotel> findHotelByCity(String city) throws Exception {
        return hotelService.findHotelByCity(city);
    }
    public Hotel addHotel(Hotel hotel) throws Exception {
        return hotelService.addHotel(hotel);
    }

    public void deleteHotel(Hotel hotel) throws Exception {
        hotelService.deleteHotel(hotel);
    }

}
