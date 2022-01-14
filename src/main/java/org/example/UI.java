package org.example;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Mit dieser Klasse regeln wir alle Eingaben und Ausgaben
 */
public class UI {
    static Scanner scan = new Scanner(System.in);
    //static Filter filter = new Filter();

    /**
     * Filter instructions
     */
    public static void showFilterInstructions() {
        System.out.println("\nPlease select your filter. Enter number ...");
        System.out.println("0 to filter by the first letter of a person's last name.");
        System.out.println("1 to filter by several initial letters (also concerning the last name).");
        System.out.println("2 to filter by the first letter of a person's first name.");
        System.out.println("3 to return to main page.\n");
    }

    public static void noMatchingEntries() {
        System.out.println("\nSorry, no matching entries were found.");
    }

    public static void output(String s) {
        System.out.println(s);
    }

    /**
     * Scanner
     */
    public static String inputLine(String s) {
        scan = new Scanner(System.in);
        System.out.print(s);
        return scan.nextLine().trim();
    }

    public static String input(String s) {
        scan = new Scanner(System.in);
        System.out.print(s);
        return scan.next().trim();
    }

    public static int inputNumber(String s) {
        scan = new Scanner(System.in);

        System.out.print(s);
        String stringInput = scan.nextLine();
        int intName = -1;

        try {
            intName = Integer.parseInt(stringInput);
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Invalid input, please try something else.\n");
        }

        return intName;
    }

    public static void outputList(List<String> s) {
        for (int i = 0; i < s.size(); i++) {
            System.out.println(s.get(i));
        }

    }
}
