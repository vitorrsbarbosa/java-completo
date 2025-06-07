package modulo16.comparables;

import modulo16.comparables.entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        String path = "/home/barbosav/projects/java-completo/src/modulo16/comparables/files/names.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String employee = br.readLine();
            while(employee != null) {
                String[] filds = employee.split(",");
                String name = filds[0];
                double salary = Double.parseDouble(filds[1]);
                list.add(new Employee(name,salary));
                employee = br.readLine();
            }
            Collections.sort(list);
            for(Employee nextEmployee : list){
                System.out.println(nextEmployee.getName() + "," + nextEmployee.getSalary());
            }
        } catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
