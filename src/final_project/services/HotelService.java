package final_project.services;

import final_project.dao.HotelDAO;
import final_project.models.Hotel;
import final_project.utils.Countries;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class HotelService {
    private HotelDAO hotelDAO = new HotelDAO();

    public ArrayList<Hotel> findHotelByName(String name) throws Exception {
        ArrayList<Hotel> hotels = new ArrayList<>();
        if (name == null)
            throw new IOException("findHotelByName error - hotel name is NULL!");

        for (Hotel hotel : hotelDAO.getAll())
            if(hotel.getHotelName().equals(name))
                hotels.add(hotel);
        return hotels;
    }

    public ArrayList<Hotel> findHotelByCity(String city) throws Exception {
        ArrayList<Hotel> hotels = new ArrayList<>();
        if (city == null)
            throw new IOException("findHotelByCity error - city is NULL!");

        for (Hotel hotel : hotelDAO.getAll())
            if(hotel.getCity().equals(city))
                hotels.add(hotel);
        return hotels;

    }
    public Hotel addHotel(Hotel hotel) throws Exception {
        validate(hotel);
        return hotelDAO.addHotel(hotel);
    }

    public void deleteHotel(Hotel hotel) throws Exception {
        if (hotel != null)
            hotelDAO.deleteHotel(hotel.getId());
    }

    private void validate(Hotel hotel)throws Exception {
        nullCheck(hotel);
        countryCheck(hotel.getCountry());
    }

    private void nullCheck(Hotel hotel) throws IOException {
        if (hotel == null)
            throw new IOException("HotelService.nullCheck error - hotel is NULL!");

        if (hotel.toString().contains("null") || hotel.toString().contains(",,"))
            throw new IOException("HotelService.nullCheck error - hotel has empty parameter! Hotel ID: " + hotel.getId());
    }

    private void countryCheck(String country) throws IOException{
        if(!Arrays.toString(Countries.values()).contains(country))
            throw new IOException("HotelService.countryCheck error - used country is out of allowed countries scope! ::" + country);

        if (Countries.valueOf(country) == Countries.Russia || Countries.valueOf(country) == Countries.Iran)
            throw new IOException("HotelService.countryCheck error - service is not allowed for the country " + country);
    }

}
