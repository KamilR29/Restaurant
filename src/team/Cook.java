package team;


import java.io.IOException;

public class Cook extends Employee{


    public Cook(int id,String name, String surname, String work) {
        super(id,name, surname, work);
    }

    @Override
    public void addEmployee(Employee employee) throws IOException {
        super.addEmployee(employee);
    }
}
