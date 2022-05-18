package menu;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu implements MenuInterface{


    public void addToMenu( Dish dish) throws IOException {

        FileWriter file = new FileWriter("menu.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(file);
        bufferedWriter.write(dish.getNumber()+", "+dish.getName()+", "+dish.getDescription()+", "+dish.getPrice()+", "+dish.isAvailable());
        bufferedWriter.newLine();
        bufferedWriter.close();

    }

    public String readMenu() throws FileNotFoundException {
        String all = "";
        File file = new File("menu.txt");
        Scanner scanner = new Scanner(file);

         while (scanner.hasNext()){
            String line = scanner.nextLine();
             all += line+"\n";
         }

         System.out.println(all);

       return all;
    }

    public void deleteFromMenu(int number) throws IOException {

        File file = new File("menu.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<Dish> list = new ArrayList();

        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String[] strings = line.split(", ");
            list.add(new Dish(Integer.parseInt(strings[0]),strings[1],strings[2],Integer.parseInt(strings[3]),strings[4]));
        }

        PrintWriter printWriter = new PrintWriter("menu.txt");
        printWriter.print("");
        printWriter.close();
        FileWriter file1 = new FileWriter("menu.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(file1);

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getNumber() != number) {
                bufferedWriter.write(list.get(i).getNumber() + ", " + list.get(i).getName() + ", " + list.get(i).getDescription() + ", " + list.get(i).getPrice()+", "+list.get(i).isAvailable());
                bufferedWriter.newLine();
            }
        }
        bufferedWriter.close();
    }

    public void changeAvailable(int number) throws IOException{
        File file = new File("menu.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<Dish> list = new ArrayList();

        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String[] strings = line.split(", ");
            list.add(new Dish(Integer.parseInt(strings[0]),strings[1],strings[2],Integer.parseInt(strings[3]),strings[4]));

        }

        PrintWriter printWriter = new PrintWriter("menu.txt");
        printWriter.print("");
        printWriter.close();
        FileWriter file1 = new FileWriter("menu.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(file1);

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getNumber() != number) {
                bufferedWriter.write(list.get(i).getNumber() + ", " + list.get(i).getName() + ", " + list.get(i).getDescription() + ", " + list.get(i).getPrice()+", "+list.get(i).isAvailable());
                bufferedWriter.newLine();
            }else if (list.get(i).getNumber() == number){

                if(list.get(i).isAvailable().equals("yes")){

                    bufferedWriter.write(list.get(i).getNumber() + ", " + list.get(i).getName() + ", " + list.get(i).getDescription() + ", " + list.get(i).getPrice()+", no");
                    bufferedWriter.newLine();


                }else if (list.get(i).isAvailable().equals("no")){

                    bufferedWriter.write(list.get(i).getNumber() + ", " + list.get(i).getName() + ", " + list.get(i).getDescription() + ", " + list.get(i).getPrice()+", yes");
                    bufferedWriter.newLine();

                }
            }
        }
        bufferedWriter.close();
    }

    public ArrayList<Dish> readMoreMenu() throws IOException {
        File file = new File("menu.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<Dish> list = new ArrayList();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] strings = line.split(", ");
            list.add(new Dish(Integer.parseInt(strings[0]), strings[1], strings[2], Integer.parseInt(strings[3]), strings[4]));

        }
        return list;

    }



}
