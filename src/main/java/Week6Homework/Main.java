package Week6Homework;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give an expression to be calculated without empty spaces: ");
        String input = scanner.nextLine();
        String[] parts = input.split("\\+");

        double totalCm = 0;
        for(String part : parts){
        String numberSecvence = part.replaceAll("[^0-9]","");
        String unitSecvence = part.replaceAll("[0-9]","");
        double value = Double.parseDouble(numberSecvence);

        totalCm += Distance.convertToCm(value, unitSecvence);
        }

        System.out.println(totalCm+" cm");

    }
}
