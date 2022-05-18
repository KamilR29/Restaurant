package team;


import java.io.IOException;

public class Cook extends Employee{


    public Cook(String name, String surname, String work, int id) {
        super(name, surname, work, id);
    }

    @Override
    public void addEmployee(Employee employee) throws IOException {
        super.addEmployee(employee);
    }
}
