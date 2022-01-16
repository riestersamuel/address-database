package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Klasse um einen Filter auszuwählen, um die Einträge zu filtern.
 * Der Nutzer soll eine Zahl eingegeben. Diese ruft dann die Methode mit dem Filter auf.
 */
public class Filter {

    List<String> allFileEntries = new ArrayList<>();
    final String myFileName = "address.txt";
    boolean a = false;

    /**Der Konstruktor ruft die passende Methode auf, je nach Nutzer Eingabe.
     * case0 Es wird nach dem Anfangsbuchstaben des Nachnamens gefiltert.
     * case1 Es wird nach mehreren Anfangsbuchstaben des Nachnamens gefiltert.
     * case2 Es wird nach dem Anfangsbuchstaben des Vornamen gefiltert.
     * case3 Es wird die Startseite angezeigt
     */
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
            UI.output("Error");
        }

        do {
            int inputNumber = UI.inputNumber("Please enter a number: ");
            String instruction;
            List<String> l;
            switch (inputNumber) {
                case 0:
                    instruction = UI.input("Enter the first letter of the person's last name you're searching for:");
                    l = allFilter(1, "^[" + instruction.toUpperCase() + "].*");
                    UI.outputList(l);
                    UI.showFilterInstructions();
                    break;
                case 1:
                    instruction = UI.input("Enter the letters you're searching for (in the format L-S): ");
                    l = allFilter(1, "^[" + instruction.toUpperCase() + "].*");
                    UI.outputList(l);
                    UI.showFilterInstructions();
                    break;
                case 2:
                    instruction = UI.input("Enter the first letter of the person's first name you're searching for: ");
                    l = allFilter(0, "^" + instruction.toUpperCase() + ".*");// "^A.*"
                    UI.outputList(l);
                    UI.showFilterInstructions();
                    break;
                case 3:
                    AddressDatabase.showInstructions();
                    AddressDatabase.convertNumberToMethod();
                    a = true;
                    break;
                default:
                    UI.showFilterInstructions();
            }
        } while (!a);
    }

    /**
     * @param option gibt an an welchem Index im Array gefiltert werden soll (also ob Vor- oder Nachname)
     * @param regex  Kriterien (Buchstabe) nach denen gefiltert wird
     * @return gefilterte Einträge werden zurückgegeben
     */

    public List<String> allFilter(int option, String regex) {
        boolean atLeastOneMatchingEntry = false;
        List<String> entries = new ArrayList<>();
        for (int i = 0; i < allFileEntries.size(); i++) {
            String dataAtLineI = allFileEntries.get(i).toUpperCase();
            String[] newWord = dataAtLineI.split(" ");
            if (newWord[option].matches(regex)) {
                atLeastOneMatchingEntry = true;
                entries.add(allFileEntries.get(i));
            }
        }
        if (!atLeastOneMatchingEntry) {
            UI.noMatchingEntries();
        }
        return entries;
    }
}