package org.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

//Klasse um einen Filter auszuwählen, um die Einträge zu filtern.
public class Filter {
    /**
     * Klasse um einen Filter auszuwählen, um die Einträge zu filtern.
     * Der Nutzer soll eine Zahl eingegeben. Diese ruft dann die Methode mit dem Filter auf.
     * @param line gesuchte Zeile
     * @param atLeastOneMatchingEntry falls kein passender Eintrag gefunden wird
     */
    static boolean atLeastOneMatchingEntry = false;

    List<String>  allFileEntries = new ArrayList<>();
    final String myFileName = "address.txt";
    boolean a = false;


    public Filter() {

        /**Der Konstruktor ruft die passende Methode auf, je nach Nutzer Eingabe.
         * case0 Es wird nach dem Anfangsbuchstaben des Nachnamens gefiltert.
         * case1 Es wird nach mehreren Anfangsbuchstaben des Nachnamens gefiltert.
         * case2 Es wird nach dem Anfangsbuchstaben des Vornamen gefiltert.
         * case3 Es wird die Startseite angezeigt
         * @param allFileEntries
         * @param inputNumber
         * @param a zurück zum Startmenü
         */

        try {
            allFileEntries = Files.readAllLines(Paths.get(myFileName));
        } catch (IOException e) {
            e.printStackTrace();
            UI.output("Fehler");
        }

        do {
        try {

            int inputNumber = UI.inputNumber("Please enter a number: ");
            switch (inputNumber) {
                case 0:
                    firstLetterLastName();
                    UI.showFilterInstructions();
                    break;
                case 1:
                    InitialLetters();
                    UI.showFilterInstructions();
                    break;
                case 2:
                    firstLetterFirstName();
                    UI.showFilterInstructions();
                    break;
                case 3:
                    AddressDatabase.showinstructions();
                    AddressDatabase.convertNumberToMethod();
                    a = true;
                    break;
                default:
                    // Wenn eine ungültige Zahl eingegeben wird, wird eine Fehlermeldung ausgegeben.
                    UI.output("Invalid input, please try something else.");
                    UI.showFilterInstructions();
            }
        }
        // Exception für ungültige Benutzereingabe
        catch (InputMismatchException e) {
            UI.output("Sorry, this number doesn't do anything.");
            UI.showFilterInstructions();
        }

        }while(!a);
    }

    public void firstLetterLastName() {

        String letter = UI.input("Enter the first letter of the person's last name you're searching for:");

        for (int i = 0; i < allFileEntries.size(); i++) {
            String dataAtLineI = allFileEntries.get(i).toUpperCase();
            String[] newWord = dataAtLineI.split(" ");
            if (newWord[1].startsWith(letter.toUpperCase())) {
                System.out.println(allFileEntries.get(i));
                atLeastOneMatchingEntry = true;
            }
        }
        if (!atLeastOneMatchingEntry) {
            System.out.println("\nSorry, no matching entries were found.");
        }
    }

    public void InitialLetters() {
        //Filter für einen Bereich von Anfangsbuchstaben des Nachnamens

        /*Anfangs- und Endbuchstabe eingeben. Es werden die Namen gesucht deren Anfangsbuchstaben
         im Alphabet zwischen den eingegebenen Buchstaben liegen.*/
        //letter = scan.next();
        String letter = UI.input("Enter the letters you're searching for (in the format L-S): ");

        for (int i = 0; i < allFileEntries.size(); i++) {
            String dataAtLineI = allFileEntries.get(i).toUpperCase();
            if (dataAtLineI.matches("^[" + letter.toUpperCase() + "].*")) {
                System.out.println(allFileEntries.get(i));
                atLeastOneMatchingEntry = true;
            }
        }
        if (!atLeastOneMatchingEntry) {
            System.out.println("\nSorry, no matching entries were found.");
        }

    }

     public String[] firstLetterFirstName() {
        //System.out.println("\nEnter the first letter of the person's first name you're searching for: ");

        String letter = UI.input("Enter the first letter of the person's first name you're searching for: ");
        List<String>  entries = new ArrayList<>();
        for (int i = 0; i < allFileEntries.size(); i++) {
            String myNextLine = allFileEntries.get(i).toUpperCase();
            String[] newWord = myNextLine.split(" ");
            if (newWord[0].startsWith(letter.toUpperCase())) {
                entries.add(allFileEntries.get(i)+"\n");
                atLeastOneMatchingEntry = true;
            }
        }
        if (!atLeastOneMatchingEntry) {
            UI.noMatchingEntries();
        }
        System.out.println(entries);
        return entries;
    }
}