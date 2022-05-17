package order;

import java.util.HashMap;

public class OrderDescription {

    private int orderNumber;
    private HashMap<Integer,Integer> dishMap;
    private int inOut;
    //private int total;


    public OrderDescription(int orderNumber, HashMap<Integer,Integer> dishMap, int inOut ) {
        this.orderNumber = orderNumber;
        this.dishMap = dishMap;
        this.inOut = inOut;
        //this.total = total;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public HashMap<Integer,Integer>  getDishes() {
        return dishMap;
    }

    public int getInOut() {
        return inOut;
    }

//    public int getTotal() {
//        return total;
//    }
}
