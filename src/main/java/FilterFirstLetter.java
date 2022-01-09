import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class FilterFirstLetter {
    public static void filterfirst(Scanner scan) {
        //Filter für den Anfangsbuchstaben des Nachnamens
        String letter;
        System.out.println("\nEnter the first letter of the person's last name you're searching for: ");
        letter = scan.next();
        try {
            String myFileName = "address.txt";
            int line;
            //Neue Liste mit allen Einträgen der Textdatei wird aufgerufen
            List<String> allFileEntries = Files.readAllLines(Paths.get(myFileName));

            boolean atLeastOneMatchingEntry = false;
            for (int i = 0; i < allFileEntries.size(); i++) {
                String dataAtLineI = allFileEntries.get(i).toUpperCase();
                String[] newWord = dataAtLineI.split(" ");
                //Annahme: Wenn mind. 1 Objekt mit dem Buchstabe anfängt, dann keine Fehlermeldung, sonst Fehlermeldung
                //Also: Wenn nicht mind. ein Objekt mit dem Buchstabe anfängt -> Fehlermeldung
                if (newWord[1].startsWith(letter.toUpperCase())) {
                    atLeastOneMatchingEntry = true;
                    break;
                }
            }
            if (!atLeastOneMatchingEntry) {
                System.out.println("\nSorry, no matching entries were found.");
            }
            //Wenn es mindestens einen passenden Eintrag gibt, soll eine passende Nachricht und alle Einträge angezeigt werden.
            else {
                System.out.println("\nThese matching entries were found ... ");
                //Solange i kleiner ist als die Anzahl der Zeilen wird der Name gesucht
                for (int i = 0; i < allFileEntries.size(); i++) {
                    String myNextLine = allFileEntries.get(i).toUpperCase();
                    String[] newWord = myNextLine.split(" ");
                    if (newWord[1].startsWith(letter.toUpperCase())) {
                        line = i;//Zeile gefunden
                        System.out.println(allFileEntries.get(line));
                    }
                }

            }

            //Versuch 1: Wenn Buchstabe der gesucht wurde nicht existiert
            /*for (int i = 0; i < allFileEntries.size(); i++) {
                String myNextLine = allFileEntries.get(i);
                if (!(myNextLine.startsWith(letter.toUpperCase()))) {
                    System.out.println("Sorry, no matching entries were found!");
                    break;
                }
            }*/

        } catch (IOException ex) {
            //Fehlermeldung, wenn Datei nicht gefunden wird
            System.out.println("Error. Data not found." + ex.getMessage());
        }

    }
}