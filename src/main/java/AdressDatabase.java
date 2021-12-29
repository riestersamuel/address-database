import java.io.IOException;
import java.util.Scanner;

public class AdressDatabase {
    static final Scanner scan = new Scanner(System.in);

    //Das ist die Anleitung zum Bedienen des Programms. Sie wird standardmäßig beim Starten des Programms angezeigt.
    public static void instructions() {
        System.out.println("Enter number ...");
        System.out.println("0 to browse person entries.");
        System.out.println("1 to toggle filtering person entries.");
        System.out.println("2 to create a new person entry.");
        System.out.println("3 to delete a person entry.");
        System.out.println("4 to exit this program.");
        System.out.println("");
    }

    public static void convertNumberToMethod() throws IOException {
        //Der Nutzer soll eine Zahl eingegeben. Diese ruft dann die entsprechende Methode auf.
        System.out.println("Please enter a number: ");

        final int inputNumber = scan.nextInt();
        switch (inputNumber) {
            case 0:
                System.out.println("Starte Methode 0");
                final Reader reader = new Reader();
                // Die Klasse Reader wird aufgerufen, um die Einträge aus der Datei zu lesen.
                // Mit dem folgenden Code startet sich die Anleitung und das Bedienfeld automatisch selbst neu ...
                instructions();
                convertNumberToMethod();
                break;
            case 1:
                System.out.println("Starte Methode 1");
                //final Filterfirstletter filteredentry = new Filterfirstletter();
                //final Filterlastletter lastletter = new Filterlastletter();
                break;
            case 2:
                System.out.println("Starte Methode 2");
                final Writer person = new Writer(scan);
                // Die Klasse Writer wird aufgerufen, um die neuen Einträge in die Datei zu schreiben.
                instructions();
                convertNumberToMethod();
                break;
            case 3:
                System.out.println("Starte Methode 3");
                final DeletePerson deletePerson = new DeletePerson(scan);
                instructions();
                convertNumberToMethod();
                break;
            case 4:
                System.out.println("Shutting down...");
                break;
            default:
                System.out.println("Sorry, this number doesn't do anything.");
                instructions();
                convertNumberToMethod();
        }
    }

    public static void main(String[] args) throws IOException {
        instructions();
        convertNumberToMethod();
    }
}
