package kitchen;

import order.Order;
import order.OrderDescription;

import java.io.IOException;
import java.util.ArrayList;

public class Kitchen implements Runnable{

    Order order = new Order();
    ArrayList<OrderDescription> list;

    public Kitchen(ArrayList<OrderDescription> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true){
            if (list.isEmpty()){
                System.out.println(list);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }else{
                System.out.println(list);

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    order.addToDone(list);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                list.remove(0);

                if(list.isEmpty()){
                    try {
                        order.addToOrderThree();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else {
                    try {
                        order.addToOrderTwo(list);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }



        }

    }
}
