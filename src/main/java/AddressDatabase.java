import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AddressDatabase {
    static final Scanner scan = new Scanner(System.in);

    /**
     * Das ist die Anleitung zum Bedienen des Programms. Sie wird standardmäßig beim Starten des Programms angezeigt.
     */
    public static void showinstructions() {
        System.out.println("\nEnter number ...");
        System.out.println("0 to browse person entries.");
        System.out.println("1 to toggle filtering person entries.");
        System.out.println("2 to create a new person entry.");
        System.out.println("3 to delete a person entry.");
        System.out.println("4 to exit this program.\n");
    }

    /**
     * Der Nutzer soll eine Zahl eingegeben. Diese ruft dann die entsprechende Methode auf.
     * Gibt der Nutzer 1 ein, soll der Case 1 gestartet werden, bei 2 Case 2, und so weiter.
     * Falls der Nutzer etwas anderes als eine Zahl eingibt, soll sich die Methode neustarten.
     */

    static void convertNumberToMethod() throws IOException {
        UI.numberoutput();
        //Falls der Nutzer etwas anderes als eine Zahl eingibt, soll sich die Methode neustarten.
        // Das haben wir mithilfe von einem Try-Catch-Block gemacht.
        try {
            final int inputNumber = scan.nextInt();
            switch (inputNumber) {
                case 0 -> {
                    System.out.println("\nCurrent person entries:");
                    //Die Klasse Reader wird aufgerufen, um die Einträge aus der Datei zu lesen.
                    Reader.read();
                    //Wir haben auch Code geschrieben, damit sich die Anleitung und das Bedienfeld automatisch
                    //selbst neu neustarten.
                    showinstructions();
                    convertNumberToMethod();
                }
                case 1 -> {
                    UI.showFilterInstructions();
                    Filter f = new Filter(scan);
                    showinstructions();
                    convertNumberToMethod();
                }
                case 2 -> {
                    //Die Klasse Writer wird aufgerufen, um die neuen Einträge in die Datei zu schreiben.
                    Writer.write(scan);
                    showinstructions();
                    convertNumberToMethod();
                }
                case 3 -> {
                    //Die Klasse DeletePerson wird aufgerufen, um Einträge zu löschen.
                    Person.deleteThisPerson(scan);
                    showinstructions();
                    convertNumberToMethod();
                }
                case 4 -> {
                    System.out.println("\nShutting down...");
                    System.exit(0);
                }
                default -> {
                    System.out.println("\nSorry, this number doesn't do anything.");
                    showinstructions();
                    convertNumberToMethod();
                }
            }
        }

        //Hier haben wir einen Catch der die Exception für ungültige Nutzereingabe auffängt.
        //Wenn das passiert, lassen wir den Scanner-Puffer leeren und starten das Programm neu.
        catch (InputMismatchException e) {
            System.out.println("Invalid input, please try something else.");
            scan.nextLine();
            showinstructions();
            convertNumberToMethod();
        }
    }

    /**
     * Das hier wird einmalig automatisch beim Start des Programms aufgerufen, um es zum Laufen zu bringen.
     * Danach läuft es weiter, bis man es stoppt.
     */
    public static void main(String[] args) throws IOException {
        showinstructions();
        convertNumberToMethod();
    }
}
