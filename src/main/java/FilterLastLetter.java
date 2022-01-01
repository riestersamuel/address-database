import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class FilterLastLetter {

    public FilterLastLetter() {
        //für den Endbuchstaben
        String letter;
        try (final Scanner scan = new Scanner(System.in)) {
            System.out.println("\nEnter the last letter you're searching for: ");
            letter = scan.next();
            System.out.println("\nThese are your entries ending with this letter: ");
            try {
                String myFileName = "address.txt";
                int line;

                //neue Liste mit allen Einträgen der Textdatei wird aufgerufen
                List<String> allFileEntries = Files.readAllLines(Paths.get(myFileName));

                //solange i kleiner ist als die Anzahl der Zeilen wird der Name gesucht
                for (int i = 0; i < allFileEntries.size(); i++) {
                    String myNextLine = allFileEntries.get(i);
                    if (myNextLine.endsWith(letter)) {
                        line = i;//Zeile gefunden
                        System.out.println(allFileEntries.get(line));
                    }
                }

            } catch (IOException ex) {
                System.out.println("Error. Data not found.");
            }
        }
    }
}

