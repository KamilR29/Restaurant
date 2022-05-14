package main;


import menu.Dish;
import menu.Menu;
import menu.MenuInterface;


import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Menu menu = new Menu();
        boolean isEnd = false;
        Scanner scanner = new Scanner(System.in);


        while(isEnd == false) {

            System.out.println("0 - Zakoncz");
            System.out.println("1 - Dodaj danie");
            System.out.println("2 - Poakrz menu");
            System.out.println("3 - Skasuj z menu");
            System.out.println("4 - Zmien dostepnsc");
            System.out.print("Podaj numer: ");
            int number = scanner.nextInt();
            switch (number){
                
                case 1 -> menu.createDish();
                case 2 -> menu.readMenu();
                case 3 -> menu.deleteFromMenu();
                case 4 -> menu.changeAvailable();
                case 0 -> isEnd = true;

                default -> throw new IllegalStateException("Unexpected value: " + number);

            }

        }

    }
}
