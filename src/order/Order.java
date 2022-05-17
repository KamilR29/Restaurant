package order;


import menu.Dish;
import menu.Menu;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Order {


     public  ArrayList<OrderDescription> orderMainList = new ArrayList<>();
     Menu menu = new Menu();


    public int setNumber(){

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HHmmss");
        String time =  dateFormat.format(date);
        int code = Integer.parseInt(time);
        return code;
    }


//    public ArrayList createListOfDish(){
//        ArrayList list = new ArrayList();
//        Scanner scanner = new Scanner(System.in);
//        boolean isEnd = false;
//        while (isEnd==false) {
//            System.out.print("Podaj numer dania: ");
//            int menuNumber = scanner.nextInt();
//            list.add(menuNumber);
//
//            System.out.println("Czy to wszystko? true/false :");
//            String isAll = scanner.nextLine();
//            if (isAll.equals("YES")) {
//                isEnd = true;
//            } else if (isAll.equals("NO")) {
//                isEnd = false;
//            }
//
//        }
//        return list;
//    }

//    public boolean inOut(){
//
//        boolean io = false;
//        System.out.println("Dostawa czy na miejscu: DOSTAWA/NAMIEJSCU ");
//        Scanner scanner = new Scanner(System.in);
//        String delOn = scanner.nextLine();
//        if(delOn.equals("DOSTAWA")){
//            io =true;
//        }else if(delOn.equals("NAMIEJSCU")){
//            io = false;
//        }
//        return io;
//    }
    public void addToOrder(int orderNumber, Map<Integer,Integer> dishMap, int inOut ) throws IOException {

        FileWriter file = new FileWriter("order.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(file);
        bufferedWriter.write(orderNumber+"/ "+dishMap+"/ "+ inOut);
        bufferedWriter.newLine();
        bufferedWriter.close();



    }
    public String readOrder() throws FileNotFoundException {

        String all = "";
        File file = new File("order.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()){
            String line = scanner.nextLine();
            all += line+"\n";
        }
        System.out.println(all);

        return all;


    }
    public void deleteFromOrder() throws IOException {
        File file = new File("order.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<OrderDescription> list = new ArrayList();
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String[] strings = line.split("/ ");
            HashMap<Integer, Integer> map = new HashMap<>();
            String[] strings1 = strings[1].split(",");
            for (int i = 0; i < strings1.length; i+=2) {
                map.put(Integer.parseInt(strings1[i]),Integer.parseInt(strings[i+1]));

            }

            //list.add(new OrderDescription(Integer.parseInt(strings[0]), map, Integer.parseInt(strings[2])));

        }
        //System.out.println("Podaj ID dania do skasowania: ");
        // Scanner scanner1 = new Scanner(System.in);
        //int delete = scanner1.nextInt();


        PrintWriter printWriter = new PrintWriter("order.txt");
        printWriter.print("");
        printWriter.close();
        FileWriter file1 = new FileWriter("order.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(file1);

        for (int i = 1; i < list.size(); i++) {

                bufferedWriter.write(list.get(i).getOrderNumber() + ", " + list.get(i).getDishes() + ", " + list.get(i).getInOut());
                bufferedWriter.newLine();

        }
        bufferedWriter.close();

    }
    public void addToDone(ArrayList<OrderDescription>list) throws IOException {

        FileWriter file = new FileWriter("done.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(file);
        bufferedWriter.write(list.get(0).getOrderNumber()+"/ "+list.get(0).getDishes()+"/ "+ list.get(0).getInOut());
        bufferedWriter.newLine();
        bufferedWriter.close();



    }
    public void addToOrderTwo(ArrayList<OrderDescription>list) throws IOException {

        PrintWriter printWriter = new PrintWriter("order.txt");
        printWriter.print("");
        printWriter.close();

        FileWriter file = new FileWriter("order.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(file);
        bufferedWriter.write(list.get(0).getOrderNumber()+"/ "+list.get(0).getDishes()+"/ "+ list.get(0).getInOut());
        bufferedWriter.newLine();
        bufferedWriter.close();



    }
    public void addToOrderThree() throws IOException {

        PrintWriter printWriter = new PrintWriter("order.txt");
        printWriter.print("");
        printWriter.close();




    }
    public int total(int n){
        int sum = 0;

        ArrayList<Dish> list = new ArrayList<>();
        try {
            list = menu.readMoreMenu();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getNumber() == n){
                sum += list.get(i).getPrice();
            }

        }

        return sum;

    }



}
