import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class FilterInitialLetters {
    public FilterInitialLetters(Scanner scan) {
        //Für einen Bereich von Anfangsbuchstaben des Nachnamens
        String letter;

        System.out.println("\nEnter the letters you're searching for (in the format L-S): ");
        letter = scan.next();
        try {
            String myFileName = "address.txt";
            int line;

            //Neue Liste mit allen Einträgen der Textdatei wird aufgerufen
            List<String> allFileEntries = Files.readAllLines(Paths.get(myFileName));

            //Versuch 2 aka Bugfix
            boolean atLeastOneMatchingEntry = false;
            for (int i = 0; i < allFileEntries.size(); i++) {
                String dataAtLineI = allFileEntries.get(i).toUpperCase();
                if (dataAtLineI.matches("^[" + letter.toUpperCase() + "].*")) {
                    atLeastOneMatchingEntry = true;
                    break;
                }
            }
            if (!atLeastOneMatchingEntry) {
                System.out.println("\nSorry, no matching entries were found.");
            }
            //Wenn es mindestens einen passenden Eintrag gibt, soll eine passende Nachricht und alle Einträge angezeigt werden.
            else {
                System.out.println("\nThese matching entries were found:");
                //Solange i kleiner ist als die Anzahl der Zeilen wird der Name gesucht
                for (int i = 0; i < allFileEntries.size(); i++) {
                    String myNextLine = allFileEntries.get(i).toUpperCase();
                    String[] newWord = myNextLine.split(" ");
                    if (newWord[1].matches("^[" + letter.toUpperCase() + "].*")) {
                        line = i;//Zeile gefunden
                        System.out.println(allFileEntries.get(line));
                    }
                }

                //Versuch 1: Wenn Buchstabe der gesucht wurde nicht existiert
            /*for (int i = 0; i < 1; i++) {
                String myNextLine = allFileEntries.get(i);
                if (!(myNextLine.matches("^[" + letter.toUpperCase() + "].*"))) {
                    System.out.println("Sorry, no matching entries were found.");
                }
            }*/
            }
        } catch (IOException ex) {//Fehlermeldung, wenn Datei nicht gefunden wird
            System.out.println("Error. Data not found.");
        }

    }

}



