import java.io.IOException;
import java.util.Scanner;

public class AdressDatabase {

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
        //Der Nutzer soll eine Zahl eingegeben. Diese wird ruft dann die entsprechende Methode auf.
        System.out.println("Please enter a number: ");
        final Scanner scan = new Scanner(System.in);
        final int inputNumber = scan.nextInt();
        switch (inputNumber) {
            case 0:
                System.out.println("Starte Methode 0");
                final Reader reader = new Reader();
                break;
            case 1:
                System.out.println("Starte Methode 1");
                break;
            case 2:
                System.out.println("Starte Methode 2");
                final Writer person = new Writer();
                break;
            case 3:
                System.out.println("Starte Methode 3");
                final DeletePerson deletePerson = new DeletePerson();
                break;
            case 4:
                System.out.println("Starte Methode 4");
                break;

            default:
                System.out.println("Sorry, this number doesn't do anything.");
        }
        /*Mit dem folgenden Code startet sich die Methode automatisch selbst neu,
        wenn die eingegebene Zahl keiner Methode zugewiesen wurde*/
        if (!(inputNumber > 0 && inputNumber < 5)) {
            convertNumberToMethod();
        }
    }

    public static void main(String[] args) throws IOException {
        instructions();
        convertNumberToMethod();
    }
}
