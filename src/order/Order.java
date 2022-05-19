package order;


import menu.Dish;
import menu.Menu;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Order  {


     public  ArrayList<OrderDescription> orderMainList = new ArrayList<>();
     Menu menu = new Menu();
     public HashMap<Integer,Integer> dishMap = new HashMap<Integer,Integer>();


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
    public void addToOrder(int orderNumber, Map<Integer,Integer> dishMap, int inOut, int total ) throws IOException {

        FileWriter file = new FileWriter("order.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(file);
        bufferedWriter.write(orderNumber+"/ "+dishMap+"/ "+ inOut+"/ "+total);
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
    public int total(ArrayList summaryList,ArrayList quatityList){

        int sum = 0;

        ArrayList<Dish> list = new ArrayList<>();
        try {
            list = menu.readMoreMenu();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i <summaryList.size() ; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getNumber() == Integer.parseInt(String.valueOf(summaryList.get(i)))) {
                    sum += (list.get(j).getPrice()*Integer.parseInt(String.valueOf(quatityList.get(i))));
                    System.out.println(list.get(j).getNumber());
                    System.out.println(summaryList.get(i));


                }

            }
        }

        return sum;

    }
    public String readDone() throws FileNotFoundException {

        String all = "";
        File file = new File("done.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()){
            String line = scanner.nextLine();
            all += line+"\n";
        }
        System.out.println(all);

        return all;


    }


}
