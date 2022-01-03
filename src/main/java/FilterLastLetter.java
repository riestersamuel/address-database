import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

//Diese Klasse wird nicht genutzt und kann eigentlich gelöscht werden.

public class FilterLastLetter {

    public FilterLastLetter(Scanner scan) {
        //Für den letzten Buchstaben
        String letter;

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
                    String[] newLine = myNextLine.split(",");
                    if (newLine[0].endsWith(letter)) {
                        line = i;//Zeile gefunden
                        System.out.println(allFileEntries.get(line));
                    }
                }
                /*for (int i = 0; i < 1; i++) {
                    String myNextLine = allFileEntries.get(i);
                    if (!(myNextLine.endsWith(letter))) {
                        System.out.println("Sorry, no matching entries were found!");
                    }
                }*/

            } catch (IOException ex) {
                System.out.println("Error. Data not found.");
            }
        }
    }


