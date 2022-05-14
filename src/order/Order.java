package order;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {

    private int number;

    public Order() {
        this.number = setNumber();
    }

    public int setNumber(){

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HHmmss");
        String time =  dateFormat.format(date);
        int code = Integer.parseInt(time);
        return code;
    }
    public void showNumber(){
        System.out.println(number);
    }


}
