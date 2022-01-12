import java.util.Scanner;

public class UI {
    static Filter filter = new Filter();
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

    public static void numberoutput() {
        System.out.println("Please enter a number: ");
    }

    public static void wrongNumber() {
        System.out.println("Invalid input, please try something else.");
    }
    public static void invalidInput(){
        System.out.println("Sorry, this number doesn't do anything.");
    }

    /**
     * Scanner
     */
    public static void scanletter(Scanner scan){
        String letter;
        letter = scan.next();
        System.out.println(filter.firstLetterFirstName(letter));
    }

}
