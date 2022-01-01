import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AddressDatabase {
    static final Scanner scan = new Scanner(System.in);

    //Das ist die Anleitung zum Bedienen des Programms. Sie wird standardmäßig beim Starten des Programms angezeigt.
    public static void instructions() {
        System.out.println("\nEnter number ...");
        System.out.println("0 to browse person entries.");
        System.out.println("1 to toggle filtering person entries.");
        System.out.println("2 to create a new person entry.");
        System.out.println("3 to delete a person entry.");
        System.out.println("4 to exit this program.\n");
    }

    public static void convertNumberToMethod() throws IOException {
        //Der Nutzer soll eine Zahl eingegeben. Diese ruft dann die entsprechende Methode auf.
        System.out.println("Please enter a number: ");
        try{
        final int inputNumber = scan.nextInt();
        switch (inputNumber) {
            case 0:
                System.out.println("\nCurrent person entries:");
                // Die Klasse Reader wird aufgerufen, um die Einträge aus der Datei zu lesen.
                final Reader reader = new Reader();
                // Mit dem folgenden Code startet sich die Anleitung und das Bedienfeld automatisch selbst neu ...
                // Dies ist natürlich auch bei den anderen Cases der Fall.
                instructions();
                convertNumberToMethod();
                break;
            case 1:
                FilterSwitch.filterInstructions();
                FilterSwitch.convertNumberToFilter(scan);
                /*final Filterfirstletter filteredentry = new Filterfirstletter();
                final Filterlastletter lastletter = new Filterlastletter();*/
                instructions();
                convertNumberToMethod();
                break;
            case 2:
                System.out.println("\nYou want to add a new person.");
                final Writer person = new Writer(scan);
                // Die Klasse Writer wird aufgerufen, um die neuen Einträge in die Datei zu schreiben.
                instructions();
                convertNumberToMethod();
                break;
            case 3:
                System.out.println("\nYou want to delete an entry.");
                final DeletePerson deletePerson = new DeletePerson(scan);
                instructions();
                convertNumberToMethod();
                break;
            case 4:
                System.out.println("\nShutting down...");
                break;
            default:
                System.out.println("\nSorry, this number doesn't do anything.");
                instructions();
                convertNumberToMethod();
        }
        }
        catch(InputMismatchException e){
            System.out.println("Invalid Input!");
        }
    }

    public static void main(String[] args) throws IOException {
        instructions();
        convertNumberToMethod();
    }
}
