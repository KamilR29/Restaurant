package summary;

import menu.Dish;
import order.OrderDescription;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Summary {




    public int sum(ArrayList<OrderDescription> summaryList) throws IOException {

        int sum = 0;

        for (int i = 0; i < summaryList.size(); i++) {
            sum+=summaryList.get(i).getTotal();
            System.out.println(sum);

        }
        System.out.println(sum);
        return sum;




    }

}
