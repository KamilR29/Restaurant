package main;

import kitchen.Kitchen;
import menu.Dish;
import menu.Menu;
import menu.MenuInterface;
import order.Delete;
import order.Order;
import order.OrderDescription;
import summary.Summary;
import team.Delivery;
import team.Employee;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        Order order = new Order();
//        OrderDescription orderDescription = new OrderDescription();
//        Summary summary = new Summary();
//        Menu menu = new Menu();
        Delete delete = new Delete();
        Delivery delivery = new Delivery();


        ArrayList summaryList = new ArrayList();
        ArrayList totalSum = new ArrayList();
        ArrayList quantityList = new ArrayList();
        //ArrayList<OrderDescription> orderMainList1 = new ArrayList<>();






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
                                window12.setLayout(new GridLayout(2,1));
                                JLabel label = new JLabel("Maenu", SwingConstants.CENTER);
                                window12.add(label);

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
                                HashMap<Integer,Integer> dishMap = new HashMap<>();

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
                                JButton buttonLos = new JButton("RANDOM ORDER");

                                panel1.add(buttonAdd);
                                panel1.add(buttonIn);
                                panel1.add(buttonOut);
                                panel1.add(buttonLos);


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
                                                order.addToOrder(orderNumber,dishMap,1,order.total(summaryList,quantityList));
                                            } catch (IOException ex) {
                                                ex.printStackTrace();
                                            }

                                            order.orderMainList.add(new OrderDescription(orderNumber,dishMap,1, order.total(summaryList,quantityList)));
                                            totalSum.add(order.total(summaryList,quantityList));







                                            for (int i = 0; i < summaryList.size(); i++) {

                                                summaryList.remove(i);
                                                quantityList.remove(i);

                                            }
                                            for (int i = 0; i < dishMap.size(); i++) {
                                                dishMap.remove(dishMap.get(i));

                                            }


                                            System.out.println(order.orderMainList);

                                            window1.dispose();

                                        }
                                );

                                buttonOut.addActionListener(
                                        e17 -> {




                                            int orderNumber = order.setNumber();

                                            try {
                                                order.addToOrder(orderNumber,dishMap,0,order.total(summaryList,quantityList));
                                            } catch (IOException ex) {
                                                ex.printStackTrace();
                                            }

                                            order.orderMainList.add( new OrderDescription(orderNumber,dishMap,0, order.total(summaryList,quantityList)));
                                            totalSum.add(order.total(summaryList,quantityList));
                                            delivery.deliveryList.add(orderNumber);






                                            for (int i = 0; i < summaryList.size(); i++) {

                                                summaryList.remove(i);
                                                quantityList.remove(i);

                                            }
                                            for (int i = 0; i < dishMap.size(); i++) {
                                                dishMap.remove(dishMap.get(i));

                                            }


                                            System.out.println(order.orderMainList);

                                            window1.dispose();
                                        }
                                );
                                buttonLos.addActionListener(
                                        e1 -> {
                                            HashMap map = new HashMap();
                                            ArrayList list1 = new ArrayList();
                                            ArrayList list2 = new ArrayList();
                                            File file = new File("menu.txt");
                                            Scanner scanner = null;
                                            try {
                                                scanner = new Scanner(file);
                                            } catch (FileNotFoundException ex) {
                                                ex.printStackTrace();
                                            }
                                            ArrayList list = new ArrayList();

                                            while (scanner.hasNext()){
                                                String line = scanner.nextLine();
                                                String[] strings = line.split(", ");
                                                list.add(Integer.parseInt(strings[0]));
                                            }

                                            Random random = new Random();
                                            int r = random.nextInt(list.size())+1;

                                            for (int i = 0; i < r; i++) {
                                                map.put(list.get(i),1);
                                                list1.add(list.get(i));
                                                list2.add(1);


                                            }
                                            int n = random.nextInt(2);


                                            int orderNumber = order.setNumber();

                                            try {
                                                order.addToOrder(orderNumber,map,n,order.total(list1,list2));
                                            } catch (IOException ex) {
                                                ex.printStackTrace();
                                            }

                                            order.orderMainList.add( new OrderDescription(orderNumber,map,n, order.total(summaryList,quantityList)));
                                            totalSum.add(order.total(list1,list2));
                                            delivery.deliveryList.add(orderNumber);


                                            for (int i = 0; i < summaryList.size(); i++) {

                                                summaryList.remove(i);
                                                quantityList.remove(i);

                                            }

                                            System.out.println(order.orderMainList);

                                            window1.dispose();



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
                                window14.setLayout(new GridLayout(1,2));

                                JPanel panel1 = new JPanel();
                                JPanel panel2 = new JPanel();
                                panel1.setLayout(new GridLayout(2,1));
                                panel2.setLayout(new GridLayout(2,1));
                                JLabel labelWaiting = new JLabel("Waiting", SwingConstants.CENTER);
                                Border b1 = BorderFactory.createLineBorder(Color.black);
                                JLabel labelDone = new JLabel("Done", SwingConstants.CENTER);
                                panel1.add(labelWaiting);
                                panel2.add(labelDone);
                                window14.add(panel1);
                                window14.add(panel2);
                                panel1.setBorder(b1);
                                panel2.setBorder(b1);

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
                                panel1.add(textArea);


                                String line1 = null;

                                try {
                                    line1 = order1.readDone();
                                } catch (FileNotFoundException ex) {
                                    ex.printStackTrace();
                                }

                                JTextArea textArea1 = new JTextArea();
                                textArea1.append(line1);
                                textArea1.setEditable(false);
                                panel2.add(textArea1);

                                window14.setVisible(true);

                            }
                    );
                    button5.addActionListener(
                            e -> {
                                JFrame window15 = new JFrame();
                                window15.setSize(800, 600);
                                window15.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                window15.setLayout(new GridLayout(1,2));
                                Border b1 = BorderFactory.createLineBorder(Color.black);

                                JPanel panel1 = new JPanel();
                                JPanel panel2 = new JPanel();

                                panel1.setLayout(new GridLayout(2,1));
                                panel2.setLayout(new GridLayout(2,1));
                                window15.add(panel1);
                                window15.add(panel2);
                                JLabel label1 = new JLabel("Total",SwingConstants.CENTER);
                                JLabel label2 = new JLabel("Tip",SwingConstants.CENTER);
                                panel1.add(label1);
                                panel2.add(label2);
                                JTextArea textArea2 = new JTextArea();
                                panel1.setBorder(b1);
                                panel2.setBorder(b1);


                                Summary summary1 = new Summary();
                                int line = 0;
                                try {
                                    line = summary1.sum(totalSum);
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }

                                int line1 = 0;
                                try {
                                    line1= (int) summary1.tip(totalSum);
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }


                                JTextArea textArea = new JTextArea();
                                textArea.append(String.valueOf(line));
                                textArea.setEditable(false);
                                panel1.add(textArea);
                                textArea2.append(String.valueOf(line1));
                                textArea2.setEditable(false);
                                panel2.add(textArea2);

                                window15.setVisible(true);

                            }
                    );
                    button6.addActionListener(
                            e -> {
                                JFrame windowEmployee = new JFrame();
                                windowEmployee.setSize(800, 600);
                                windowEmployee.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                windowEmployee.setLayout(new GridLayout(1,2));

                                JButton buttonToAdd = new JButton("ADD WORKER");
                                JButton buttonToDelete = new JButton("DELETE WORKER");

                                windowEmployee.add(buttonToAdd);
                                windowEmployee.add(buttonToDelete);


                                buttonToAdd.addActionListener(
                                        e1 -> {
                                            JFrame windowToAdd = new JFrame();
                                            windowToAdd.setSize(800, 600);
                                            windowToAdd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                            windowToAdd.setLayout(new GridLayout(1,2));

                                            JPanel panel1 = new JPanel();
                                            JPanel panel2 = new JPanel();
                                            panel1.setLayout(new GridLayout(6,1));
                                            windowToAdd.add(panel1);
                                            windowToAdd.add(panel2);

                                            Employee employee = new Employee();

                                            JTextField txt1 = new JTextField();
                                            JTextField txt2 = new JTextField();
                                            JTextField txt3 = new JTextField();
                                            JTextField txt4 = new JTextField();

                                            JTextArea textArea = new JTextArea();
                                            panel2.add(textArea);



                                            JButton addWorker = new JButton("ADD");
                                            panel1.add(txt1);
                                            panel1.add(txt2);
                                            panel1.add(txt3);
                                            panel1.add(txt4);
                                            panel1.add(addWorker);




                                            addWorker.addActionListener(
                                                    e2 -> {
                                                        int id = Integer.parseInt(txt1.getText());
                                                        String name = txt2.getText();
                                                        String surname = txt3.getText();
                                                        String work = txt4.getText();

                                                        try {
                                                            employee.addEmployee(new Employee(id, name, surname, work));
                                                        } catch (IOException ex) {
                                                            ex.printStackTrace();

                                                        }

                                                        windowToAdd.dispose();





                                                    }
                                            );
                                            String line = null;
                                            try {
                                                line = employee.readEmployee();
                                            } catch (FileNotFoundException ex) {
                                                ex.printStackTrace();
                                            }


                                            textArea.append(line);
                                            textArea.setEditable(false);

                                            windowToAdd.setVisible(true);



                                        }
                                );
                                buttonToDelete.addActionListener(

                                        e3 -> {
                                            Employee employee = new Employee();
                                            JFrame windowToDelete = new JFrame();
                                            windowToDelete.setSize(800, 600);
                                            windowToDelete.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                            windowToDelete.setLayout(new GridLayout(1,2));

                                            JPanel panel1 = new JPanel();
                                            JPanel panel2 = new JPanel();
                                            windowToDelete.add(panel1);
                                            windowToDelete.add(panel2);
                                            panel1.setLayout(new GridLayout(6,1));
                                            JTextField idFiled = new JTextField();
                                            panel1.add(idFiled);
                                            JButton buttonDelete = new JButton("DELETE");
                                            panel1.add(buttonDelete);
                                            JTextArea textArea = new JTextArea();
                                            panel2.add(textArea);

                                            buttonDelete.addActionListener(
                                                    e4 ->{

                                                        int id = Integer.parseInt(idFiled.getText());


                                                        try {
                                                            employee.deleteEmployee(id);
                                                        } catch (IOException ex) {
                                                            ex.printStackTrace();

                                                        }
                                                        windowToDelete.dispose();

                                                    }
                                            );
                                            String line = null;
                                            try {
                                                line = employee.readEmployee();
                                            } catch (FileNotFoundException ex) {
                                                ex.printStackTrace();
                                            }


                                            textArea.append(line);
                                            textArea.setEditable(false);
                                            windowToDelete.setVisible(true);


                                        }
                                );





                                windowEmployee.setVisible(true);

                            }
                    );




                    window.setVisible(true);
                }
        );



        Kitchen kitchen = new Kitchen(order.orderMainList);
        kitchen.start();
        delivery.start();





    }

}
