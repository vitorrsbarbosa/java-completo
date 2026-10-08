package modulo18.stream.exercise02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import modulo18.stream.exercise02.entities.Employee;

public class Program {
    public static void main(String[] args) {
        run();
    }

    /*
     * Enter salary: 2000.00
     * 
     * Email of people whose salary is more than 2000.00:
     * anna@gmail.com
     * 
     * bob@gmail.com
     * 
     * maria@gmail.com
     * 
     * Sum of salary of people whose name starts with 'M': 4900.00
     */
    private static void run() {
        Scanner scanner = new Scanner(System.in);
        String path = "src/modulo18/stream/exercise02/files/file.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<Employee> listOfEmployees = collectFileToList(br);
            System.out.print("Enter salary: ");
            Double salary = scanner.nextDouble();
            System.out.print("Enter a starting letter: ");
            String letter = scanner.next();

            List<String> alfabeticalOrderEmails = organizeEmailsInAlfabeticalOrder(salary, listOfEmployees);
            Double sumOfSalary = calculateSumOfSalaryOfEmployeesWhoseNameStartsWithGivenLetter(letter, listOfEmployees);

            printValues(salary, letter, alfabeticalOrderEmails, sumOfSalary);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }

    private static List<Employee> collectFileToList(BufferedReader br) throws IOException {
        List<Employee> list = new ArrayList<>();
        String line = br.readLine();
        while (line != null) {
            String[] fields = line.split(",");
            list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
            line = br.readLine();
        }
        return list;
    }

    private static List<String> organizeEmailsInAlfabeticalOrder(Double salary, List<Employee> listOfEmployees) {
        Comparator<String> comparator = (string1, string2) -> string1.toUpperCase().compareTo(string2.toUpperCase());
        List<String> emailsList = listOfEmployees.stream()
                .filter(p -> p.getSalary() > salary)
                .map(p -> p.getEmail())
                .sorted(comparator)
                .collect(Collectors.toList());
        return emailsList;
    }

    private static Double calculateSumOfSalaryOfEmployeesWhoseNameStartsWithGivenLetter(String letter,
            List<Employee> listOfEmployees) {
        double sum = listOfEmployees.stream()
                .filter(e -> e.getName().toUpperCase().startsWith(letter.toUpperCase()))
                .map(Employee::getSalary)
                .reduce(0.0, (x, y) -> x + y);
        return sum;
    }

    private static void printValues(Double salary, String letter, List<String> alfabeticalOrderEmails, Double sumOfSalary) {
        System.out.println("Email of people whose salary is more than " + String.format("%.2f", salary) + ":");
        alfabeticalOrderEmails.forEach(System.out::println);

        System.out.println("Sum of salary of people whose name starts with the letter '" + letter.toUpperCase() + "'': "
                + String.format("%.2f", sumOfSalary));
    }
}