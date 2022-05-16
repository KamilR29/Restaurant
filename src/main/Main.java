package main;


import menu.Dish;
import menu.Menu;
import menu.MenuInterface;
import order.Order;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {

//        Menu menu = new Menu();
//        boolean isEnd = false;
//        Scanner scanner = new Scanner(System.in);
//
//
//        while(isEnd == false) {
//
//            System.out.println("0 - Zakoncz");
//            System.out.println("1 - Dodaj danie");
//            System.out.println("2 - Poakrz menu");
//            System.out.println("3 - Skasuj z menu");
//            System.out.println("4 - Zmien dostepnsc");
//            System.out.print("Podaj numer: ");
//            int number = scanner.nextInt();
//            switch (number){
//
//                case 1 -> menu.createDish();
//                case 2 -> menu.readMenu();
//                case 3 -> menu.deleteFromMenu();
//                case 4 -> menu.changeAvailable();
//                case 0 -> isEnd = true;
//
//                default -> throw new IllegalStateException("Unexpected value: " + number);
//
//            }
//
//        }
//
//        Order order = new Order();
//        order.setNumber();
//        order.showNumber();
//        boolean i = order.inOut();
//        System.out.println(i);
        SwingUtilities.invokeLater(
                ()-> {

                    JFrame window = new JFrame();
                    window.setSize(800, 600);
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    window.setLayout(new GridLayout(2, 3));

                    JButton button1 = new JButton("Menu");
                    JButton button2 = new JButton("Customize Menu");
                    JButton button3 = new JButton("Order");
                    JButton button4 = new JButton("Waiting orders");
                    JButton button5 = new JButton("Summary");
                    JButton button6 = new JButton("Workers");
                    window.add(button1);
                    window.add(button2);
                    window.add(button3);
                    window.add(button4);
                    window.add(button5);
                    window.add(button6);

                    button1.addActionListener(
                            new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    JFrame window = new JFrame();
                                    window.setSize(800, 600);
                                    window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                    MenuInterface menuInterface = new Menu();
                                    String line = null;
                                    try {
                                        line = menuInterface.readMenu();
                                    } catch (FileNotFoundException ex) {
                                        ex.printStackTrace();
                                    }

                                    JTextArea textArea = new JTextArea();
                                    textArea.append(line);
                                    textArea.setEditable(false);
                                    window.add(textArea);


                                    window.setVisible(true);

                                }
                            }
                    );
                    button2.addActionListener(
                            new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    JFrame window = new JFrame();
                                    window.setSize(800, 600);
                                    window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    window.setVisible(true);

                                    window.setLayout(new GridLayout(2, 2));

                                    JButton button1 = new JButton("Add dish");
                                    JButton button2 = new JButton("Delete dish");
                                    JButton button3 = new JButton("Show menu");
                                    JButton button4 = new JButton("Change available");
                                    window.add(button1);
                                    window.add(button2);
                                    window.add(button3);
                                    window.add(button4);

                                    button1.addActionListener(
                                            new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    JFrame window = new JFrame();
                                                    window.setSize(800, 600);
                                                    window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                                    window.setLayout(new GridLayout(1,2));
                                                    JPanel panel1 = new JPanel();
                                                    JPanel panel2 = new JPanel();
                                                    window.add(panel1);
                                                    window.add(panel2);
                                                    panel1.setLayout(new GridLayout(6,1));

                                                    JTextField number = new JTextField(5);
                                                    JTextField name = new JTextField(5);
                                                    JTextField description = new JTextField(5);
                                                    JTextField price = new JTextField(5);
                                                    JTextField available = new JTextField(5);
                                                    panel1.add(number);
                                                    panel1.add(name);
                                                    panel1.add(description);
                                                    panel1.add(price);
                                                    panel1.add(available);


                                                    JButton buttonAdd = new JButton("ADD");
                                                    panel1.add(buttonAdd);

                                                    buttonAdd.addActionListener(
                                                            new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent e) {
                                                                    int num = Integer.parseInt(number.getText());
                                                                    String na = name.getText();
                                                                    String des = description.getText();
                                                                    int pr = Integer.parseInt(price.getText());
                                                                    boolean av = Boolean.getBoolean(available.getText());

                                                                    Menu menu = new Menu();
                                                                    try {
                                                                        menu.addToMenu(new Dish(num, na, des, pr,av));
                                                                    } catch (IOException ex) {
                                                                        ex.printStackTrace();
                                                                    }
                                                                    window.dispose();




                                                                }
                                                            }
                                                    );


                                                    MenuInterface menuInterface = new Menu();
                                                    String line = null;
                                                    try {
                                                        line = menuInterface.readMenu();
                                                    } catch (FileNotFoundException ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    JTextArea textArea = new JTextArea();
                                                    textArea.append(line);
                                                    textArea.setEditable(false);
                                                    panel2.add(textArea);



                                                    window.setVisible(true);

                                                }
                                            }
                                    );
                                    button2.addActionListener(
                                            new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    JFrame window = new JFrame();
                                                    window.setSize(800, 600);
                                                    window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                                    window.setVisible(true);

                                                }
                                            }
                                    );
                                    button3.addActionListener(
                                            new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    JFrame window = new JFrame();
                                                    window.setSize(800, 600);
                                                    window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


                                                    window.setVisible(true);

                                                }
                                            }
                                    );
                                    button4.addActionListener(
                                            new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    JFrame window = new JFrame();
                                                    window.setSize(800, 600);
                                                    window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                                    window.setVisible(true);

                                                }
                                            }
                                    );


                                }
                            }
                    );
                    button3.addActionListener(
                            new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    JFrame window = new JFrame();
                                    window.setSize(800, 600);
                                    window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    window.setVisible(true);

                                }
                            }
                    );
                    button4.addActionListener(
                            new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    JFrame window = new JFrame();
                                    window.setSize(800, 600);
                                    window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    window.setVisible(true);

                                }
                            }
                    );
                    button5.addActionListener(
                            new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    JFrame window = new JFrame();
                                    window.setSize(800, 600);
                                    window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    window.setVisible(true);

                                }
                            }
                    );
                    button6.addActionListener(
                            new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    JFrame window = new JFrame();
                                    window.setSize(800, 600);
                                    window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    window.setVisible(true);

                                }
                            }
                    );


                    window.setVisible(true);
                }
        );
    }
}
