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

}
//    public int sumDish(ArrayList<> summaryList) throws IOException {
//
//        int sum = 0;
//
//        for (int i = 0; i < summaryList.size(); i++) {
//            sum+=summaryList.get(i).getTotal();
//            System.out.println(sum);
//
//        }
//        System.out.println(sum);
//        return sum;
//
//
//
//
//    }
//
//}
