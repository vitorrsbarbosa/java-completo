package modulo17.Generics.problem01;

import java.util.Scanner;

import modulo17.Generics.problem01.services.PrintService;

public class Program {
    public static void main(String[] args) {
        /*
        Deseja-se fazer um programa que leia uma quantidade N, 
        e depois N números inteiros. Ao final, imprima esses 
        números de forma organizada conforme o exemplo. 
        Em seguida, informar qual foi o primeiro valor informado
        *
        *
        * 
        How many values? 3
        10
        8
        23
        [10, 8, 23]
        First value: 10
        */
        Scanner sc = new Scanner(System.in);

        PrintService<Integer> ps = new PrintService<>();
        System.out.print("How many values?");
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int value = sc.nextInt();
            ps.addValue(value);
        }
        ps.print();
        System.out.println("First value: " + ps.first());
        
        sc.close();
    }

}
