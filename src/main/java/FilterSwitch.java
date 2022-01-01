import java.io.IOException;
import java.util.Scanner;
//Klasse um einen Filter auszuwählen, um die Einträge zu filtern
public class FilterSwitch {
    //Das ist die Anleitung zum Aussuchen der Filter.
    public static void filterInstructions() {
        System.out.println("Enter number ...");
        System.out.println("0 to filter by the first letter");
        System.out.println("1 to filter by several initial letters");
        System.out.println("2 to filter by the end of the string");
        System.out.println("3 to return to main page.");
        System.out.println("");
    }

    public static void convertNumberToFilter(Scanner scan) throws IOException{
        //Der Nutzer soll eine Zahl eingegeben. Diese ruft dann die Methode mit dem Filter auf.
        System.out.println("Please enter a number: ");


        final int inputNumber = scan.nextInt();
        switch (inputNumber) {
            case 0:
                System.out.println("Starte Methode 0");
                final Filterfirstletter filteredentry = new Filterfirstletter();
                filterInstructions();
                break;
            case 1:
                System.out.println("Starte Methode 1");
                final Reader r = new Reader();
                //final FilterInitialLetters l = new FilterInitialLetters(scan);

                break;
            case 2:
                System.out.println("Starte Methode 2");
                final Filterlastletter lastletter = new Filterlastletter();
                filterInstructions();

                break;
            case 3:
                System.out.println("Starte Methode 3");
                final AdressDatabase a = new AdressDatabase();

                break;


            default:
                System.out.println("Sorry, this number doesn't do anything.");
        }


        if ((inputNumber > 0 && inputNumber < 3) || (inputNumber > 4 && inputNumber < 9)) {
            filterInstructions();
            convertNumberToFilter(scan);
        }
    }
}
