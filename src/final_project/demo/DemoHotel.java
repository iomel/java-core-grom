package final_project.demo;

import final_project.controllers.Controller;

public class DemoHotel {
    public static void main(String[] args) throws Exception{
        Controller controller = new Controller();
        controller.getHotels();

//        Hotel hotel1 = new Hotel("UK", "London", "Piccadilly");
//        controller.addHotel(hotel1);

        controller.deleteHotel(111474119);

        controller.getHotels();


    }

}
