package org.example;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

//Klasse um einen Filter auszuwählen, um die Einträge zu filtern.
public class Filter {
    static boolean atLeastOneMatchingEntry = false;

    List<String> allFileEntries = new ArrayList<>();
    static int line;
    final String myFileName = "address.txt";

    public Filter() {

        try {
            allFileEntries = Files.readAllLines(Paths.get(myFileName));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Fehler");
        }

        //Der Nutzer soll eine Zahl eingegeben. Diese ruft dann die Methode mit dem Filter auf.
        //UI.output("Please enter a number: ");

        try {
            //final int inputNumber = scan.nextInt();
            int inputNumber = UI.inputNumber("Please enter a number: ");
            switch (inputNumber) {
                case 0:
                    // Wenn 0 eingegeben wird, wird nach dem Anfangsbuchstaben des Nachnamens gefiltert.
                    firstLetterLastName();
                    UI.showFilterInstructions();
                    Filter c = new Filter();
                    break;
                case 1:
                    // Wenn 1 eingegeben wird, wird nach mehreren Anfangsbuchstaben des Nachnamens gefiltert
                    InitialLetters();
                    UI.showFilterInstructions();
                    Filter b = new Filter();
                    break;
                case 2:
                    // Wenn 2 eingegeben wird, wird nach dem Anfangsbuchstaben des Vornamen gefiltert.
                    firstLetterFirstName();
                    UI.showFilterInstructions();
                    Filter a = new Filter();

                    break;
                case 3:
                    // Wenn 3 eingegeben wird, wird die Startseite angezeigt.
                    AddressDatabase.showinstructions();
                    AddressDatabase.convertNumberToMethod();
                    Filter e = new Filter();
                    break;
                default:
                    // Wenn eine ungültige Zahl eingegeben wird, wird eine Fehlermeldung ausgegeben.
                    UI.output("Invalid input, please try something else.");
                    UI.showFilterInstructions();
            }
        }
        // Exception für ungültige Benutzereingabe
        catch (InputMismatchException e) {
            // Fehlermeldung wird angegeben.
            UI.output("Sorry, this number doesn't do anything.");
            //scan.nextLine(); // Scanner-Puffer leeren
            UI.showFilterInstructions(); // Filter Switch wird neu gestartet
            Filter d = new Filter();

        }
    }

    public void firstLetterLastName() {
        //Filter für den Anfangsbuchstaben des Nachnamens

        //System.out.println("\nEnter the first letter of the person's last name you're searching for: ");
        //letter = scan.next();

        String letter = UI.input("Enter the first letter of the person's last name you're searching for:");

        for (int i = 0; i < allFileEntries.size(); i++) {
            String dataAtLineI = allFileEntries.get(i).toUpperCase();
            String[] newWord = dataAtLineI.split(" ");
            //Annahme: Wenn mind. 1 Objekt mit dem Buchstabe anfängt, dann keine Fehlermeldung, sonst Fehlermeldung
            //Also: Wenn nicht mind. ein Objekt mit dem Buchstabe anfängt -> Fehlermeldung
            if (newWord[1].startsWith(letter.toUpperCase())) {
                line = i;//Zeile gefunden
                System.out.println(allFileEntries.get(line));
                atLeastOneMatchingEntry = true;
            }
        }
        if (!atLeastOneMatchingEntry) {
            System.out.println("\nSorry, no matching entries were found.");
        }
    }

    public void InitialLetters() {
        //Filter für einen Bereich von Anfangsbuchstaben des Nachnamens

        System.out.println("\nEnter the letters you're searching for (in the format L-S): ");
        /*Anfangs- und Endbuchstabe eingeben. Es werden die Namen gesucht deren Anfangsbuchstaben
         im Alphabet zwischen den eingegebenen Buchstaben liegen.*/
        //letter = scan.next();
        String letter = UI.input("Enter the letters you're searching for (in the format L-S): ");

        for (int i = 0; i < allFileEntries.size(); i++) {
            String dataAtLineI = allFileEntries.get(i).toUpperCase();
            if (dataAtLineI.matches("^[" + letter.toUpperCase() + "].*")) {
                line = i;//Zeile gefunden
                System.out.println(allFileEntries.get(line));
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

        //UI.scanletter(letter);
        //Solange i kleiner ist als die Anzahl der Zeilen wird der Name gesucht
        for (int i = 0; i < allFileEntries.size(); i++) {
            String myNextLine = allFileEntries.get(i).toUpperCase();
            String[] newWord = myNextLine.split(" ");
            if (newWord[0].startsWith(letter.toUpperCase())) {
                line = i;//Zeile gefunden
                //in einem array jeden wert speichern
                //kein printline mehr
                System.out.println(allFileEntries.get(line));
                atLeastOneMatchingEntry = true;
            }
        }
        if (!atLeastOneMatchingEntry) {
            System.out.println("\nSorry, no matching entries were found.");
        }
        return new String[0]; // TODO: richtige Werte zurückgeben
    }


}