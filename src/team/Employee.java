package team;



import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Employee {

    private String name;
    private String surname;
    private String work;
    private int id;

    public Employee(int id, String name, String surname, String work) {
        this.name = name;
        this.surname = surname;
        this.work = work;
        this.id = id;
    }
    public Employee(){

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
        bufferedWriter.write(employee.getId()+", "+employee.getName()+", "+employee.getSurname()+", "+employee.getWork());
        bufferedWriter.newLine();
        bufferedWriter.close();



    }
    public String readEmployee() throws FileNotFoundException {
        String all = "";
        File file = new File("team.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()){
            String line = scanner.nextLine();
            all += line+"\n";
        }

        System.out.println(all);

        return all;
    }

    public void deleteEmployee(int number) throws IOException {

        File file = new File("team.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<Employee> list = new ArrayList();

        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String[] strings = line.split(", ");
            list.add(new Employee(Integer.parseInt(strings[0]),strings[1],strings[2],strings[3]));
        }

        PrintWriter printWriter = new PrintWriter("team.txt");
        printWriter.print("");
        printWriter.close();
        FileWriter file1 = new FileWriter("team.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(file1);


        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() != number) {
                bufferedWriter.write(list.get(i).getId() + ", " + list.get(i).getName() + ", " + list.get(i).getSurname() + ", " + list.get(i).getWork());
                bufferedWriter.newLine();
            }
        }
        bufferedWriter.close();
    }


}
