import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class FilterFirstLetter {
    public FilterFirstLetter(Scanner scan) {
        //für den Anfangsbuchstaben
        String letter;
        System.out.println("\nEnter the first letter of the person's last name you're searching for: ");
        letter = scan.next();
        System.out.println("\nThese matching entries were found: ");
        try {
            String myFileName = "address.txt";
            int line;

            //neue Liste mit allen Einträgen der Textdatei wird aufgerufen
            List<String> allFileEntries = Files.readAllLines(Paths.get(myFileName));

                //solange i kleiner ist als die Anzahl der Zeilen wird der Name gesucht
                for (int i = 0; i < allFileEntries.size(); i++) {
                    String myNextLine = allFileEntries.get(i).toUpperCase();
                    String[] newWord = myNextLine.split(" ");
                    if (newWord[1].startsWith(letter.toUpperCase())) {
                        line = i;//Zeile gefunden
                        System.out.println(allFileEntries.get(line));
                    }

                }

            // wenn Buchstabe der gesucht wurde nicht existiert
            for (int i = 0; i < allFileEntries.size(); i++) {
                String myNextLine = allFileEntries.get(i);
                if (!(myNextLine.startsWith(letter.toUpperCase()))) {
                    System.out.println("Sorry, no matching entries were found!");
                    break;
                }
            }

        //Fehlermeldung,wenn Datei nicht gefunden wird
        } catch (IOException ex) {
            System.out.println("Error. Data not found.");
        }

    }
}