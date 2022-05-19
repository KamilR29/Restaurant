package summary;

import menu.Dish;
import order.OrderDescription;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Summary {




    public int sum(ArrayList totalSum) throws IOException {

        int sum = 0;

        for (int i = 0; i < totalSum.size(); i++) {
            sum+=Integer.parseInt(String.valueOf(totalSum.get(i)));
            System.out.println(sum);

        }
        System.out.println(sum);
        return sum;




    }
    public double tip(ArrayList totalSum) throws IOException {

        double tip = 0;

        for (int i = 0; i < totalSum.size(); i++) {
            tip+=(Integer.parseInt(String.valueOf(totalSum.get(i)))*0.1);
            System.out.println(tip);

        }

        return tip;




    }
}

