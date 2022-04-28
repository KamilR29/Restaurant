package menu;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Menu {


    public void createDish() throws IOException {
        int id;
        String name;
        String description;
        int price;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj nazwe dania: ");
        name = scanner.nextLine();
        System.out.print("Podaj opis dania: ");
        description = scanner.nextLine();
        System.out.print("Podaj cene dania: ");
        price = scanner.nextInt();
        System.out.print("Podaj ID dania: ");
        id = scanner.nextInt();
        Dish dish = new Dish(id,name,description,price);
        addToMenu(dish);


    }


    public void addToMenu( Dish dish) throws IOException {

        FileWriter file = new FileWriter("menu.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(file);
        bufferedWriter.write(dish.getNumber()+" "+dish.getName()+" "+dish.getDescription()+" "+dish.getPrice());
        bufferedWriter.newLine();
        bufferedWriter.close();



    }





}
