package main;

import kitchen.Kitchen;
import menu.Dish;
import menu.Menu;
import menu.MenuInterface;
import order.Delete;
import order.Order;
import order.OrderDescription;
import summary.Summary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        Order order = new Order();
        OrderDescription orderDescription = new OrderDescription();
        Summary summary = new Summary();
        Menu menu = new Menu();
        Delete delete = new Delete();

        HashMap<Integer,Integer> dishMap = new HashMap<Integer,Integer>();
        ArrayList summaryList = new ArrayList();
        ArrayList totalSum = new ArrayList();
        ArrayList quantityList = new ArrayList();



        SwingUtilities.invokeLater(
                ()-> {

                    JFrame window = new JFrame();
                    window.setSize(800, 600);

                    try {
                        window.setDefaultCloseOperation(delete.delAll());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    window.setLayout(new GridLayout(2, 3));


                    JButton button1 = new JButton("Menu");
                    JButton button2 = new JButton("Customize Menu");
                    JButton button3 = new JButton("Order");
                    JButton button4 = new JButton("Waiting orders");
                    JButton button5 = new JButton("Summary");
                    JButton button6 = new JButton("Workers");


                    Color color = new Color(237, 140, 222);
                    button1.setBackground(color);
                    button2.setBackground(color);
                    button3.setBackground(color);
                    button4.setBackground(color);
                    button5.setBackground(color);
                    button6.setBackground(color);


                    window.add(button1);
                    window.add(button2);
                    window.add(button3);
                    window.add(button4);
                    window.add(button5);
                    window.add(button6);


                    button1.addActionListener(
                            e -> {
                                JFrame window12 = new JFrame();
                                window12.setSize(800, 600);
                                window12.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
                                window12.add(textArea);


                                window12.setVisible(true);

                            }
                    );
                    button2.addActionListener(
                            e -> {
                                JFrame window13 = new JFrame();
                                window13.setSize(800, 600);
                                window13.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                window13.setVisible(true);

                                window13.setLayout(new GridLayout(2, 2));

                                JButton buttonAddDish = new JButton("Add dish");
                                JButton buttonDeleteDish = new JButton("Delete dish");
                                JButton buttonChangeAvailable = new JButton("Change available");
                                JButton buttonCloseMenu = new JButton("CLOSE");
                                window13.add(buttonAddDish);
                                window13.add(buttonDeleteDish);
                                window13.add(buttonChangeAvailable);
                                window13.add(buttonCloseMenu);

                                buttonAddDish.addActionListener(
                                        e1 -> {
                                            JFrame windowAddDish = new JFrame();
                                            windowAddDish.setSize(800, 600);
                                            windowAddDish.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                            windowAddDish.setLayout(new GridLayout(1,2));
                                            JPanel panel1 = new JPanel();
                                            JPanel panel2 = new JPanel();
                                            windowAddDish.add(panel1);
                                            windowAddDish.add(panel2);
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
                                                    e11 -> {
                                                        int num = Integer.parseInt(number.getText());
                                                        String na = name.getText();
                                                        String des = description.getText();
                                                        int pr = Integer.parseInt(price.getText());
                                                        String av = available.getText();

                                                        Menu menu1 = new Menu();
                                                        try {
                                                            menu1.addToMenu(new Dish(num, na, des, pr,av));
                                                        } catch (IOException ex) {
                                                            ex.printStackTrace();
                                                        }
                                                        windowAddDish.dispose();

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

                                            windowAddDish.setVisible(true);
                                        }
                                );


                                buttonDeleteDish.addActionListener(
                                        f -> {
                                            JFrame windowDeleteDish = new JFrame();
                                            windowDeleteDish.setSize(800, 600);
                                            windowDeleteDish.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                            windowDeleteDish.setLayout(new GridLayout(1,2));
                                            JPanel panel1 = new JPanel();
                                            JPanel panel2 = new JPanel();
                                            windowDeleteDish.add(panel1);
                                            windowDeleteDish.add(panel2);
                                            panel1.setLayout(new GridLayout(6,1));

                                            JTextField number = new JTextField(5);
                                            panel1.add(number);
                                            JButton buttonAdd = new JButton("DELETE");
                                            panel1.add(buttonAdd);


                                            buttonAdd.addActionListener(
                                                    e12 -> {
                                                        int num = Integer.parseInt(number.getText());

                                                        Menu menu1 = new Menu();
                                                        try {
                                                            menu1.deleteFromMenu(num);
                                                        } catch (IOException ex) {
                                                            ex.printStackTrace();
                                                        }

                                                        windowDeleteDish.dispose();

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

                                            windowDeleteDish.setVisible(true);

                                        }
                                );
                                buttonChangeAvailable.addActionListener(
                                        e13 -> {
                                            JFrame windowChange = new JFrame();
                                            windowChange.setSize(800, 600);
                                            windowChange.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                            windowChange.setLayout(new GridLayout(1,2));
                                            JPanel panel1 = new JPanel();
                                            JPanel panel2 = new JPanel();
                                            windowChange.add(panel1);
                                            windowChange.add(panel2);
                                            panel1.setLayout(new GridLayout(6,1));

                                            JTextField number = new JTextField(5);

                                            panel1.add(number);



                                            JButton buttonChange = new JButton("CHANGE");
                                            panel1.add(buttonChange);

                                            buttonChange.addActionListener(
                                                    e131 -> {
                                                        int num = Integer.parseInt(number.getText());

                                                        Menu menu1 = new Menu();
                                                        try {
                                                            menu1.changeAvailable(num);
                                                        } catch (IOException ex) {
                                                            ex.printStackTrace();
                                                        }

                                                        windowChange.dispose();
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

                                            windowChange.setVisible(true);

                                        }
                                );
                                buttonCloseMenu.addActionListener(
                                        e14 -> window13.dispose()
                                );


                            }
                    );
                    button3.addActionListener(
                            e -> {
                                JFrame window1 = new JFrame();
                                window1.setSize(800, 600);
                                window1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                window1.setLayout(new GridLayout(1,2));

                                JPanel panel1 = new JPanel();
                                JPanel panel2 = new JPanel();

                                window1.add(panel1);
                                window1.add(panel2);

                                panel1.setLayout(new GridLayout(6,1));

                                JTextField number = new JTextField(5);
                                JTextField quantity = new JTextField();

                                panel1.add(number);
                                panel1.add(quantity);

                                JButton buttonAdd = new JButton("ADD TO ORDER");
                                JButton buttonIn = new JButton("ORDER ON SITE");
                                JButton buttonOut = new JButton("ORDER TAKE-OUT");

                                panel1.add(buttonAdd);
                                panel1.add(buttonIn);
                                panel1.add(buttonOut);


                                buttonAdd.addActionListener(
                                        e15 -> {

                                            int n  = Integer.parseInt(number.getText());
                                            int q = Integer.parseInt(quantity.getText());

                                            quantityList.add(q);
                                            summaryList.add(n);
                                            dishMap.put(n,q);

                                        }
                                );
                                buttonIn.addActionListener(
                                        e16 -> {

                                            int orderNumber = order.setNumber();

                                            try {
                                                order.addToOrder(orderNumber,dishMap,1);
                                            } catch (IOException ex) {
                                                ex.printStackTrace();
                                            }

                                            order.orderMainList.add(new OrderDescription(orderNumber,dishMap,1, order.total(summaryList,quantityList)));
                                            totalSum.add(order.total(summaryList,quantityList));


                                            for (int i = 0; i < summaryList.size(); i++) {

                                                summaryList.remove(i);
                                                quantityList.remove(i);

                                            }

                                            System.out.println(order.orderMainList);
                                        }
                                );

                                buttonOut.addActionListener(
                                        e17 -> {

                                            int orderNumber = order.setNumber();

                                            try {
                                                order.addToOrder(orderNumber,dishMap,0);
                                            } catch (IOException ex) {
                                                ex.printStackTrace();
                                            }

                                            order.orderMainList.add(new OrderDescription(orderNumber,dishMap,0, order.total(summaryList,quantityList)));
                                            totalSum.add(order.total(summaryList,quantityList));


                                            for (int i = 0; i < summaryList.size(); i++) {

                                                summaryList.remove(i);
                                                quantityList.remove(i);

                                            }

                                            System.out.println(order.orderMainList);
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

                                window1.setVisible(true);
                            }
                    );

                    button4.addActionListener(
                            e -> {
                                JFrame window14 = new JFrame();
                                window14.setSize(800, 600);
                                window14.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                Order order1 = new Order();
                                String line = null;

                                try {
                                    line = order1.readOrder();
                                } catch (FileNotFoundException ex) {
                                    ex.printStackTrace();
                                }

                                JTextArea textArea = new JTextArea();
                                textArea.append(line);
                                textArea.setEditable(false);
                                window14.add(textArea);

                                window14.setVisible(true);

                            }
                    );
                    button5.addActionListener(
                            e -> {
                                JFrame window15 = new JFrame();
                                window15.setSize(800, 600);
                                window15.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                Summary summary1 = new Summary();
                                int line = 0;
                                try {
                                    line = summary1.sum(totalSum);
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }

                                JTextArea textArea = new JTextArea();
                                textArea.append(String.valueOf(line));
                                textArea.setEditable(false);
                                window15.add(textArea);

                                window15.setVisible(true);

                            }
                    );
                    button6.addActionListener(
                            e -> {
                                JFrame window16 = new JFrame();
                                window16.setSize(800, 600);
                                window16.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                window16.setVisible(true);

                            }
                    );


                    window.setVisible(true);
                }
        );

        Kitchen kitchen = new Kitchen(order.orderMainList);
        kitchen.run();


    }

}
