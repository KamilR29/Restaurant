package order;

import menu.Dish;
import java.util.ArrayList;

public class OrderDescription {

    private int orderNumber;
    private ArrayList<Dish> dishes;
    private boolean inOut;

    public OrderDescription(int orderNumber, ArrayList<Dish> dishes, boolean inOut) {
        this.orderNumber = orderNumber;
        this.dishes = dishes;
        this.inOut = inOut;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public boolean isInOut() {
        return inOut;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setDishes(ArrayList<Dish> dishes) {
        this.dishes = dishes;
    }

    public void setInOut(boolean inOut) {
        this.inOut = inOut;
    }
}
