import java.io.IOException;
import java.util.Scanner;

//Klasse um einen Filter auszuwählen, um die Einträge zu filtern.
public class FilterSwitch {
    //Das ist die Anleitung zum aussuchen der Filter.
    public static void filterInstructions() {
        System.out.println("\nPlease select your filter. Enter number ...");
        System.out.println("0 to filter by the first letter.");
        System.out.println("1 to filter by several initial letters.");
        System.out.println("2 to filter by the end of the string.");
        System.out.println("3 to return to main page.\n");
    }

    public static void convertNumberToFilter(Scanner scan) throws IOException {
        //Der Nutzer soll eine Zahl eingegeben. Diese ruft dann die Methode mit dem Filter auf.
        System.out.println("Please enter a number: ");


        final int inputNumber = scan.nextInt();
        switch (inputNumber) {
            case 0:
                final FilterFirstLetter filteredEntry = new FilterFirstLetter(scan);
                filterInstructions();
                convertNumberToFilter(scan);
                break;
            case 1:
                final FilterInitialLetters l = new FilterInitialLetters(scan);
                filterInstructions();
                convertNumberToFilter(scan);
                break;
            case 2:
                System.out.println("Starte Methode 2");
                final FilterLastLetter lastletter = new FilterLastLetter();
                filterInstructions();
                convertNumberToFilter(scan);
                break;
            case 3:
                System.out.println("Starte Methode 3");
                final AddressDatabase a = new AddressDatabase();
                break;


            default:
                System.out.println("Sorry, this number doesn't do anything.");
                filterInstructions();
                convertNumberToFilter(scan);
        }
    }
}
