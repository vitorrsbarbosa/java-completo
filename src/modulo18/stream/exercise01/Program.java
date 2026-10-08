package modulo18.stream.exercise01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import modulo18.stream.exercise01.entities.Product;

public class Program {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        String path = "src/modulo18/stream/exercise/files/file.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<Product> listOfProducts = collectFileToList(br);
            double avgPriceOfProducts = findAvgPrice(listOfProducts);

            List<String> namesListFromProducts = filterListBellowAvgPrice(listOfProducts, avgPriceOfProducts);

            printValues(avgPriceOfProducts, namesListFromProducts);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static List<Product> collectFileToList(BufferedReader br) throws IOException {
        List<Product> list = new ArrayList<>();
        String line = br.readLine();
        while (line != null) {
            String[] fields = line.split(",");
            list.add(new Product(fields[0], Double.parseDouble(fields[1])));
            line = br.readLine();
        }
        return list;
    }

    private static double findAvgPrice(List<Product> list) {
        double avgPrice = list.stream()
                .map(p -> p.getPrice())
                .reduce(0.0, (x, y) -> x + y) / list.size();
        return avgPrice;
    }

    private static List<String> filterListBellowAvgPrice(List<Product> list, double avgPrice) {
        Comparator<String> comparator = (string1, string2) -> string1.toUpperCase().compareTo(string2.toUpperCase());
        List<String> namesList = list.stream()
                .filter(p -> p.getPrice() < avgPrice)
                .map(p -> p.getName())
                .sorted(comparator.reversed())
                .collect(Collectors.toList());
        return namesList;
    }

    private static void printValues(double avgPrice, List<String> namesList) {
        System.out.println("---------------------------------");
        System.out.println("Avarage price: " + String.format("%.2f", avgPrice));
        System.out.println("---------------------------------");
        namesList.forEach(System.out::println);
    }

}