import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

//Klasse um einen Filter auszuwählen, um die Einträge zu filtern.
public class FilterSwitch {
    //Das ist die Anleitung zum Aussuchen der Filter.
    public static void filterInstructions() {
        System.out.println("\nPlease select your filter. Enter number ...");
        System.out.println("0 to filter by the first letter of a person's last name.");
        System.out.println("1 to filter by several initial letters (also concerning the last name).");
        System.out.println("2 to filter by the first letter of a person's first name.");
        System.out.println("3 to return to main page.\n");
    }

    public static void convertNumberToFilter(Scanner scan) throws IOException {
        //Der Nutzer soll eine Zahl eingegeben. Diese ruft dann die Methode mit dem Filter auf.
        System.out.println("Please enter a number: ");

        try{
            final int inputNumber = scan.nextInt();
        switch (inputNumber) {
            case 0:
                final FilterFirstLetter filter1 = new FilterFirstLetter(scan);
                filterInstructions();
                convertNumberToFilter(scan);
                break;
            case 1:
                final FilterInitialLetters filter2 = new FilterInitialLetters(scan);
                filterInstructions();
                convertNumberToFilter(scan);
                break;
            case 2:
                final FilterFirstLetterOfFirstName filter3 = new FilterFirstLetterOfFirstName(scan);
                filterInstructions();
                convertNumberToFilter(scan);
                break;
            case 3:
                AddressDatabase.instructions();
                AddressDatabase.convertNumberToMethod();
                break;


            default:
                System.out.println("Sorry, this number doesn't do anything.");
                filterInstructions();
                convertNumberToFilter(scan);
        }
        }
        // Exception für ungültige Benutzereingabe
        catch(InputMismatchException e){
            System.out.println("Invalid input, please try something else.");
            scan.nextLine(); // Scanner-Puffer leeren
            filterInstructions(); // Filter Switch wird neu gestartet
            convertNumberToFilter(scan);
        }
    }
}
