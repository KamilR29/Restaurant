package summary;

import menu.Dish;
import order.OrderDescription;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Summary {

    int total;
    public  ArrayList<OrderDescription> summaryList = new ArrayList<>();

    public int sum() throws IOException {


        total = 0;

        File file1 = new File("menu.txt");
        Scanner scanner1 = new Scanner(file1);
        ArrayList<Dish> list1= new ArrayList();
        while (scanner1.hasNext()){
            String line1 = scanner1.nextLine();
            String[] strings = line1.split(", ");
            list1.add(new Dish(Integer.parseInt(strings[0]),strings[1],strings[2],Integer.parseInt(strings[3]),strings[4]));

        }


        for (int i = 0; i < summaryList.size(); i++) {

            for (int j = 0; j < summaryList.get(2).getDishes().size(); j++) {
                for (int k = 0; k < list1.size(); k++) {

                    if(summaryList.get(j).getDishes().get(0)==list1.get(k).getNumber()){
                        total += list1.get(k).getPrice();
                    }

                }


            }

        }
        return total;


    }

}
