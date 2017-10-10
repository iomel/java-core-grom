package lesson10.order;

import java.util.Date;

public class ElectronicsOrder extends Order{
    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    @Override
    void validateOrder() {
        // заказ возможен с городов: Киев, Одесса, Днепр, Харьков и в один из этих городов.
        // Минимальная цена заказа 100. Так же имя клиента который делает заказ может быть любым, а пол только женским
        if (getBasePrice() >= 100 && getCustomerOwned().getGender() == "Женский")
            if (getShipFromCity() == "Киев" || getShipFromCity() == "Одесса" || getShipFromCity() == "Днепр" || getShipFromCity() == "Харьков" )
                if (getShipToCity() == "Киев" || getShipToCity() == "Одесса" || getShipToCity() == "Днепр" || getShipToCity() == "Харьков" )
                    setDateConfirmed(new Date());
    }

    @Override
    void calculatePrice() {
        // Цена может состоит из цены товара и цены за доставку. Так же могут быть скидки.
        // Если доставка производится в любой город, кроме Киева и Одессы, то цена за доставку - 15% от суммы заказа.
        // В других случаях 10%. Так же если цена больше 1000 то скидка на заказ 5% после оплаты комиссии за доставку
        double shipment;
        double discount = 1;
        double totalPrice;

        if (getShipToCity() == "Киев" || getShipToCity() == "Одесса")
            shipment = 1.1;
        else
            shipment = 1.15;

        if (getBasePrice() > 1000)
            discount = 0.95;

        totalPrice = ( getBasePrice() * shipment ) * discount;
        setTotalPrice(totalPrice);
    }
}
