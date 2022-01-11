import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AddressDatabase {
    static final Scanner scan = new Scanner(System.in);

    //Das ist die Anleitung zum Bedienen des Programms. Sie wird standardmäßig beim Starten des Programms angezeigt.
    public static void showinstructions() {
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
        //Falls der Nutzer etwas anderes als eine Zahl eingibt, soll sich die Methode neustarten. Das haben wir mithilfe von einem Try-Catch-Block gemacht.
        try {
            final int inputNumber = scan.nextInt();
            switch (inputNumber) {
                case 0:
                    System.out.println("\nCurrent person entries:");
                    // Die Klasse Reader wird aufgerufen, um die Einträge aus der Datei zu lesen.
                    Reader.read();
                    // Mit dem folgenden Code startet sich die Anleitung und das Bedienfeld automatisch selbst neu ...
                    // Dies ist natürlich auch bei den anderen Cases der Fall.
                    showinstructions();
                    convertNumberToMethod();
                    break;
                case 1:
                    //Hiermit öffnet sich die Anleitung zu den Filtern. Der Nutzer kann wieder eine Zahl eingeben, um zu entscheiden, was er als Nächstes machen will.
                    Filter.showFilterInstructions();
                    Filter.convertNumberToFilter(scan);
                    showinstructions();
                    convertNumberToMethod();
                    break;
                case 2:
                    // Die Klasse Writer wird aufgerufen, um die neuen Einträge in die Datei zu schreiben.
                    Writer.write(scan);
                    showinstructions();
                    convertNumberToMethod();
                    break;
                case 3:
                    // Die Klasse DeletePerson wird aufgerufen, um Einträge zu löschen
                    DeletePerson.deleteThisPerson(scan);
                    showinstructions();
                    convertNumberToMethod();
                    break;
                case 4:
                    // Das Programm wird beendet
                    System.out.println("\nShutting down...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nSorry, this number doesn't do anything.");
                    showinstructions();
                    convertNumberToMethod();
            }
        } catch (InputMismatchException e) { //Exception für ungültige Nutzereingabe.
            System.out.println("Invalid input, please try something else.");
            scan.nextLine(); //Scanner-Puffer leeren
            showinstructions(); //Programm wird neu gestartet
            convertNumberToMethod();
        }
    }

    public static void main(String[] args) throws IOException {
        //Das hier wird einmalig automatisch beim Start des Programms aufgerufen, um es zum Laufen zu bringen.
        showinstructions();
        convertNumberToMethod();
    }
}
