package task4;

import java.util.Scanner;

public class Reverse {

    public static void main(String[] args) {

    String source;
    System.out.println("Please write words you want to translate: ");
    Scanner readText = new Scanner(System.in);
    source = readText.nextLine();

    for(String part : source.split("//s")) {
        System.out.print(new StringBuilder(part).reverse().toString());
        System.out.print(" ");
        }

    try {
    }
    finally {
        readText.close();
        }
    }
}
