package team;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Employee {

    private String name;
    private String surname;
    private String work;
    private int id;

    public Employee(String name, String surname, String work, int id) {
        this.name = name;
        this.surname = surname;
        this.work = work;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getWork() {
        return work;
    }

    public int getId() {
        return id;
    }
    public void addEmployee ( Employee employee ) throws IOException {

        FileWriter file = new FileWriter("team.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(file);
        bufferedWriter.write(employee.getId()+", "+employee.getName()+","+employee.getSurname()+", "+employee.getWork());
        bufferedWriter.newLine();
        bufferedWriter.close();



    }
}
