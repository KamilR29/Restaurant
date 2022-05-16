package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                ()->{

                    JFrame okno = new JFrame();
                    okno.setSize(800,600);
                    okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    JButton btn1 = new JButton();
                    btn1.setText("btn1");

                    JButton btn2 = new JButton();
                    btn2.setText("btn2");

                    JButton btn3 = new JButton();
                    btn3.setText("btn3");

                    GridBagLayout gbl = new GridBagLayout();
                    okno.setLayout(gbl);

                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.fill = GridBagConstraints.BOTH;
                    gbc.weightx = 0.1;
                    gbc.weighty = 0.1;

                    okno.add(btn1, gbc);

                    gbc.gridx = 3;
                    gbc.gridy = 0;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;

                    okno.add(btn2, gbc);

                    gbc.gridx = 1;
                    gbc.gridy = 0;
                    gbc.gridwidth = 2;
                    gbc.gridheight = 1;
                    gbc.weightx = 0.6;
                    gbc.weighty = 0.7;

                    okno.add(btn3, gbc);

                    JButton btn4 = new JButton();
                    btn4.setText("btn4");

                    btn4.addActionListener(
                            new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    System.out.println("Hello!");
                                }
                            }
                    );

                    btn3.addActionListener(
                            (e)->{
                                btn3.setText("Hello");
                            }
                    );

                    gbc.gridx = 0;
                    gbc.gridy = 1;
                    gbc.gridwidth = 4;

                    okno.add(btn4, gbc);


                    okno.setVisible(true);

                }
        );

    }
}
