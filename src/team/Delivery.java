package team;


import java.util.ArrayList;

public class Delivery extends Thread{


    public ArrayList deliveryList = new ArrayList();

    public Delivery(){

    }




    @Override
    public void run() {
        while (true){
            if (deliveryList.isEmpty()){
                System.out.println("waiting");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }else{
                System.out.println( "go");

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                deliveryList.remove(0);






            }



        }

    }
}
