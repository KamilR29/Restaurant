package team;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Waiter extends Employee{

    private int tip;


    public Waiter(String name, String surname, String work, int id,int tip) {
        super(name, surname, work, id);
        this.tip = tip;
    }

    public int getTip() {
        return tip;
    }

    public void addWaiter (Waiter waiter ) throws IOException {

        FileWriter file = new FileWriter("team.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(file);
        bufferedWriter.write(waiter.getId()+", "+waiter.getName()+","+waiter.getSurname()+", "+waiter.getWork()+", "+waiter.getTip());
        bufferedWriter.newLine();
        bufferedWriter.close();



    }


}
