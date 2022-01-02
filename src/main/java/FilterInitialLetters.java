import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class FilterInitialLetters {
    public FilterInitialLetters(Scanner scan) {

        //für den Anfangsbuchstaben
        String letter;

        System.out.println("\nEnter the letters you're searching for (in the following format L-S): ");
        letter = scan.next();
        System.out.println("\nThese matching entries were found:");
        try {
            String myFileName = "address.txt";
            int line;

            //neue Liste mit allen Einträgen der Textdatei wird aufgerufen
            List<String> allFileEntries = Files.readAllLines(Paths.get(myFileName));

            //solange i kleiner ist als die Anzahl der Zeilen wird der Name gesucht
            for (int i = 0; i < allFileEntries.size(); i++) {
                String myNextLine = allFileEntries.get(i).toUpperCase();
                if (myNextLine.matches("^[" + letter.toUpperCase() + "].*")) {
                    line = i;//Zeile gefunden
                    System.out.println(allFileEntries.get(line));
                }
            }
            // wenn Buchstabe der gesucht wurde nicht existiert
            for (int i = 0; i < 1; i++) {
                String myNextLine = allFileEntries.get(i);
                if (!(myNextLine.matches("^[" + letter.toUpperCase() + "].*"))) {
                    System.out.println("Sorry, no matching entries were found.");
                }
            }


        } catch (IOException ex) {
            System.out.println("Error. Data not found.");
        }

    }

}



