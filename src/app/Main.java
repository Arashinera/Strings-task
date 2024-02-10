package app;

import java.util.Scanner;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        System.out.println("Exercise №1 : ");
        getOutput(getRightProductData(wrongProductData()));

        System.out.println("Exercise №2 : ");
        getOutput(getCleanProductData(extraProductData()));

        System.out.println("Exercise №3 : ");
        getOutput(getCertainNameData(searchNamesData()));
    }

    private static String[] wrongProductData() {
        return new String[]{"brange", "plum", "tomato", "onibn", "grape"};
    }

    private static String[] extraProductData() {
        return new String[]{"orange", "plum", "tomato", "onion", "grape", "onion"};
    }

    private static String[] searchNamesData() {
        return new String[]{"Bob", "Alice", "Tom", "Lucy", "Bob", "Lisa"};
    }

    private static String getRightProductData(String[] items) {

        StringBuilder stringBuilderProduct = new StringBuilder();
        int count = 0;

        for (String name : items) {
            count++;
            if (name.equals("brange")) {
                name = name.replace("b", "o");
            } else if (name.equals("onibn")) {
                name = name.replace("b", "o");
            }
            stringBuilderProduct
                    .append(count)
                    .append(") ")
                    .append(name)
                    .append("\n");
        }

        return stringBuilderProduct.toString();
    }

    private static String getCleanProductData(String[] products) {

        StringBuilder stringBuilderProduct = new StringBuilder();
        int count = 0;

        for (String name : products) {

            if (!name.equals("onion")) {
                count++;
                stringBuilderProduct
                        .append(count)
                        .append(") ")
                        .append(name)
                        .append("\n");
            } else {
                int onionIndex = stringBuilderProduct.indexOf("onion");
                if (onionIndex != -1) {
                    stringBuilderProduct.delete(onionIndex, onionIndex + 5);
                }
            }
        }

        return stringBuilderProduct.toString();
    }

    private static String getCertainNameData(String[] searchName) {

        StringBuilder stringBuilderName = new StringBuilder();
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.ENGLISH);

        int count = 0;
        int namesCount = 0;
        System.out.println("Please, input the name you want to find :");
        String nameToFind = input.nextLine();

        for (String name : searchName) {

            if (name.equals(nameToFind)) {
                namesCount++;
                count++;
                stringBuilderName
                        .append(count)
                        .append(") ")
                        .append(name)
                        .append("\n");
            }
        }

        if (namesCount > 0) {
            System.out.printf("%nThe names were found : %d%n", namesCount);
        } else if (namesCount == 0) {
            System.out.printf("%nSorry, no results...%n");
        }

        input.close();
        return stringBuilderName.toString();
    }

    private static void getOutput(String output) {
        System.out.println(output);
    }
}