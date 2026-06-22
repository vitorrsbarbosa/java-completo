package modulo17.Generics.problem02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modulo17.Generics.problem02.entities.Product;
import modulo17.Generics.problem02.services.CalculationService;

public class Program {
	public static void main(String[] args) {
		/*
		 * Uma empresa de consultoria deseja avaliar a
		 * performance de produtos, funcionários, dentre
		 * outras coisas. Um dos cálculos que ela precisa
		 * é encontrar o maior dentre um conjunto de elementos.
		 * Fazer um programa que leia um conjunto de produtos
		 * a partir de um arquivo, conforme exemplo, e
		 * depois mostre o mais caro deles.
		 *
		 * Computer,890.50
		 * Iphone X, 910.00
		 * Tablet,550.00
		 *
		 * Most expensive: Iphone X, 910.00
		 */
		List<Product> list = new ArrayList<>();
		String path = "src/modulo17/Generics/problem02/misc/products.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();
			}
			String maiorNome = CalculationService.max(list.stream().map(p ->
			p.getName()).toList()); // ?????
			Double maiorValor = CalculationService.max(list.stream().map(p ->
			p.getPrice()).toList());

			Product x = CalculationService.max(list);
			System.out.println("Maior: " + maiorNome + ", " + String.format("%.2f", maiorValor));
			System.out.println("Max: " + x);
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
