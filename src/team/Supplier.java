package team;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Supplier extends Employee {

    private int tip;


    public Supplier(String name, String surname, String work, int id) {
        super(name, surname, work, id);
    }

    public int getTip() {
        return tip;
    }

    public void addSupplier (Supplier supplier ) throws IOException {



        FileWriter file = new FileWriter("team.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(file);
        bufferedWriter.write(supplier.getId()+", "+supplier.getName()+","+supplier.getSurname()+", "+supplier.getWork()+", "+supplier.getTip());
        bufferedWriter.newLine();
        bufferedWriter.close();



    }
}
