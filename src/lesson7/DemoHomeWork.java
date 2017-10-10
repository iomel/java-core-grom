package lesson7;

import lesson6.Order;

import java.util.Date;

public class DemoHomeWork {
    Order createOrder() {
        return new Order(100,new Date(), false, null, "Dnepr", "Ukraine", "Buy");
    }

    Order createOrderAndCallMethods(){
        Order order = new Order(100,new Date(), true, new Date(), "Kiev", "Ukraine", "SomeValue");
        order.confirmOrder();
        order.checkPrice();
        order.isValidType();

        return order;

    }
}
