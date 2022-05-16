package order;


import menu.Dish;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Order {



    public int setNumber(){

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HHmmss");
        String time =  dateFormat.format(date);
        int code = Integer.parseInt(time);
        return code;
    }


    public ArrayList createListOfDish(){
        ArrayList list = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        boolean isEnd = false;
        while (isEnd==false) {
            System.out.print("Podaj numer dania: ");
            int menuNumber = scanner.nextInt();
            list.add(menuNumber);

            System.out.println("Czy to wszystko? true/false :");
            String isAll = scanner.nextLine();
            if (isAll.equals("YES")) {
                isEnd = true;
            } else if (isAll.equals("NO")) {
                isEnd = false;
            }

        }
        return list;
    }

    public boolean inOut(){
        
        boolean io = false;
        System.out.println("Dostawa czy na miejscu: DOSTAWA/NAMIEJSCU ");
        Scanner scanner = new Scanner(System.in);
        String delOn = scanner.nextLine();
        if(delOn.equals("DOSTAWA")){
            io =true;
        }else if(delOn.equals("NAMIEJSCU")){
            io = false;
        }
        return io;
    }
//    public void addToOrder( ArrayList<Dish>) throws IOException {
//
//        FileWriter file = new FileWriter("menu.txt", true);
//        BufferedWriter bufferedWriter = new BufferedWriter(file);
//        bufferedWriter.write(dish.getNumber()+", "+dish.getName()+", "+dish.getDescription()+", "+dish.getPrice()+", "+dish.isAvailable());
//        bufferedWriter.newLine();
//        bufferedWriter.close();
//
//
//
//    }



}
