package org.example.lab3;

/**
 * Hello world!
 *
 */
public class App {
    public static void printEvenNumbers(int from, int to) {
        System.out.printf("Printing  numbers in the range [%d,%d]\n", from, to);
        for (int i = from; i <= to; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void printNumbersDivisibleByThree(int from, int to) {
        System.out.printf("Printing numbers in the range [%d,%d]\n", from, to);
        for (int i = from; i <= to; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Error: At least three parameters expected, from, to, and base.");
            System.exit(1);
        }

        int from = Integer.parseInt(args[0]);
        int to = Integer.parseInt(args[1]);
        int base = Integer.parseInt(args[2]);

        if (base == 2) {
            printEvenNumbers(from, to);
        } else if (base == 3) {
            printNumbersDivisibleByThree(from, to);
        } else {
            System.out.println("Error: Invalid base. Base should be either 2 or 3.");
        }
    }
}
