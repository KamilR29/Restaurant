package order;

import menu.Dish;
import java.util.ArrayList;

public class OrderDescription {

    int orderNumber;
    ArrayList<Dish> dishes;
    boolean inOut;

    public OrderDescription(int orderNumber, ArrayList<Dish> dishes, boolean inOut) {
        this.orderNumber = orderNumber;
        this.dishes = dishes;
        this.inOut = inOut;
    }
}
