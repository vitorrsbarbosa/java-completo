package modulo17.generics.intro;

import modulo17.generics.intro.services.PrintService;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintService<String> ps = new PrintService<>();
        System.out.print("How many values? ");
        int values = sc.nextInt();

        for( int i = 0; i < values; i++ ) {
            String value = sc.next();
            ps.addValue(value);
        }

        ps.print();
        System.out.println("First: " + ps.first());
        sc.close();
    }
}
