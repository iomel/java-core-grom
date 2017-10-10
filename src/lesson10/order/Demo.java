package lesson10.order;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        Customer cust1 = new Customer("Petya", "Киев", "Мужской");
        Customer cust2 = new Customer("Rita", "Днепр", "Женский");
        Customer cust3 = new Customer("Vasya", "Одесса", "Мужской");
        Customer cust4 = new Customer("Masha", "Харьков", "Женский");

        ElectronicsOrder eOrder1 = new ElectronicsOrder("TV", new Date(), "Киев", "Киев", 110, cust1, 12 );
        eOrder1.validateOrder();
        eOrder1.calculatePrice();
        eOrder1.confirmShipping();

        ElectronicsOrder eOrder2 = new ElectronicsOrder("TV", new Date(), "Киев", "Днепр", 1100, cust2, 12 );
        eOrder2.validateOrder();
        eOrder2.calculatePrice();
        eOrder2.confirmShipping();

        FurnitureOrder fOrder1 = new FurnitureOrder("TV-table", new Date(), "Киев", "Одесса", 600, cust3, "tvt1-UA");
        fOrder1.validateOrder();
        fOrder1.calculatePrice();
        fOrder1.confirmShipping();

        FurnitureOrder fOrder2 = new FurnitureOrder("Table", new Date(), "Одесса", "Харьков", 5600, cust4, "dt1-UA");
        fOrder2.validateOrder();
        fOrder2.calculatePrice();
        fOrder2.confirmShipping();

        System.out.println("Confirmation date: " + eOrder1.getDateConfirmed() + " Shipment date: " + eOrder1.getDateShipped() + " Total price: " + eOrder1.getTotalPrice());
        System.out.println("Confirmation date: " + eOrder2.getDateConfirmed() + " Shipment date: " + eOrder2.getDateShipped() + " Total price: " + eOrder2.getTotalPrice());
        System.out.println("Confirmation date: " + fOrder1.getDateConfirmed() + " Shipment date: " + fOrder1.getDateShipped() + " Total price: " + fOrder1.getTotalPrice());
        System.out.println("Confirmation date: " + fOrder2.getDateConfirmed() + " Shipment date: " + fOrder2.getDateShipped() + " Total price: " + fOrder2.getTotalPrice());

    }
}
