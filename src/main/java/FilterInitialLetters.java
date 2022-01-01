import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class FilterInitialLetters {
    public FilterInitialLetters(Scanner scan) {

        //für den Anfangsbuchstaben
        String letter;

        System.out.println("Enter the letters you're searching for (for example: L-S)");
        letter = scan.next();
        try {
            String myFileName = "address.txt";
            int line;

            //neue Liste mit allen Einträgen der Textdatei wird aufgerufen
            List<String> allFileEntries = Files.readAllLines(Paths.get(myFileName));

            //solange i kleiner ist als die Anzahl der Zeilen wird der Name gesucht
            for (int i = 0; i < allFileEntries.size(); i++) {
                String myNextLine = allFileEntries.get(i);
                if (myNextLine.matches("^[" + letter + "].*")) {
                    line = i;//Zeile gefunden
                    System.out.println(allFileEntries.get(line));
                }
            }
            // wenn Buchstabe der gesucht wurde nicht existiert
            for (int i = 0; i < 1; i++) {
                String myNextLine = allFileEntries.get(i);
                if (!(myNextLine.matches("^[" + letter + "].*"))) {
                    line = i;//Zeile gefunden
                    System.out.println("Sorry, this letter doesn't exist!");
                }
            }


        } catch (IOException ex) {
        }

    }

}



