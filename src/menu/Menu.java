package menu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu implements MenuInterface{


    public void createDish() throws IOException {
        int id;
        String name;
        String description;
        int price;
        boolean available;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj nazwe dania: ");
        name = scanner.nextLine();
        System.out.print("Podaj opis dania: ");
        description = scanner.nextLine();
        System.out.print("Podaj cene dania: ");
        price = scanner.nextInt();
        System.out.print("Podaj ID dania: ");
        id = scanner.nextInt();
        System.out.print("Podaj dostepnosc: ");
        available = scanner.nextBoolean();

        Dish dish = new Dish(id,name,description,price,available);
        addToMenu(dish);


    }


    public void addToMenu( Dish dish) throws IOException {

        FileWriter file = new FileWriter("menu.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(file);
        bufferedWriter.write(dish.getNumber()+", "+dish.getName()+", "+dish.getDescription()+", "+dish.getPrice()+", "+dish.isAvailable());
        bufferedWriter.newLine();
        bufferedWriter.close();



    }
    public void  readMenu() throws FileNotFoundException {

       File file = new File("menu.txt");
       Scanner scanner = new Scanner(file);

       while (scanner.hasNext()){
           String line = scanner.nextLine();
           System.out.println(line);
       }



    }
    public void deleteFromMenu() throws IOException {
        File file = new File("menu.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<Dish> list = new ArrayList();
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String[] strings = line.split(", ");
            list.add(new Dish(Integer.parseInt(strings[0]),strings[1],strings[2],Integer.parseInt(strings[3]),Boolean.getBoolean(strings[4])));

        }
        System.out.println("Podaj ID dania do skasowania: ");
        Scanner scanner1 = new Scanner(System.in);
        int delete = scanner1.nextInt();


        PrintWriter printWriter = new PrintWriter("menu.txt");
        printWriter.print("");
        printWriter.close();
        FileWriter file1 = new FileWriter("menu.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(file1);

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getNumber() != delete) {
                bufferedWriter.write(list.get(i).getNumber() + ", " + list.get(i).getName() + ", " + list.get(i).getDescription() + ", " + list.get(i).getPrice()+", "+list.get(i).isAvailable());
                bufferedWriter.newLine();
            }
        }
        bufferedWriter.close();

    }
    public void changeAvailable() throws IOException{
        File file = new File("menu.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<Dish> list = new ArrayList();
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String[] strings = line.split(", ");
            list.add(new Dish(Integer.parseInt(strings[0]),strings[1],strings[2],Integer.parseInt(strings[3]),Boolean.getBoolean(strings[4])));

        }
        System.out.println("Podaj ID dania do zmiany dostepnosci: ");
        Scanner scanner1 = new Scanner(System.in);
        int delete = scanner1.nextInt();


        PrintWriter printWriter = new PrintWriter("menu.txt");
        printWriter.print("");
        printWriter.close();
        FileWriter file1 = new FileWriter("menu.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(file1);

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getNumber() != delete) {
                bufferedWriter.write(list.get(i).getNumber() + ", " + list.get(i).getName() + ", " + list.get(i).getDescription() + ", " + list.get(i).getPrice()+", "+list.get(i).isAvailable());
                bufferedWriter.newLine();
            }else if (list.get(i).getNumber() == delete){

                if(list.get(i).isAvailable()==true){

                    bufferedWriter.write(list.get(i).getNumber() + ", " + list.get(i).getName() + ", " + list.get(i).getDescription() + ", " + list.get(i).getPrice()+", "+ false);
                    bufferedWriter.newLine();


                }else if (list.get(i).isAvailable()==false){

                    bufferedWriter.write(list.get(i).getNumber() + ", " + list.get(i).getName() + ", " + list.get(i).getDescription() + ", " + list.get(i).getPrice()+", "+ true);
                    bufferedWriter.newLine();


                }


            }
        }
        bufferedWriter.close();



    }





}
