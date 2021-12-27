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
        //Der Nutzer soll eine Zahl eingegeben. Diese ruft dann die entsprechende Methode auf.
        System.out.println("Please enter a number: ");
        final Scanner scan = new Scanner(System.in);
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
                instructions();
                convertNumberToMethod();
                break;
            case 2:
                System.out.println("Starte Methode 2");
                final Writer person = new Writer();
                // Die Klasse Writer wird aufgerufen, um die neuen Einträge in die Datei zu schreiben.
                instructions();
                convertNumberToMethod();
                break;
            case 3:
                System.out.println("Starte Methode 3");
                final DeletePerson deletePerson = new DeletePerson();
                instructions();
                convertNumberToMethod();
                break;
            case 4:
                System.out.println("Starte Methode 4");
                instructions();
                convertNumberToMethod();
                break;

            default:
                System.out.println("Sorry, this number doesn't do anything.");
                instructions();
                convertNumberToMethod();
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
        //Der Starttext und die Eingabe sollen automatisch nach dem Nutzen einer Methode wieder angezeigt werden
    }
}
