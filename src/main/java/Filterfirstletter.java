import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Filterfirstletter {
    public Filterfirstletter(Scanner scan) {
        //für den Anfangsbuchstaben
        String letter;
        System.out.println("Enter the letter you're searching for: ");
        letter = scan.next();
        try {
            String myFileName = "address.txt";
            int line;

            //neue Liste mit allen Einträgen der Textdatei wird aufgerufen
            List<String> allFileEntries = Files.readAllLines(Paths.get(myFileName));

            //solange i kleiner ist als die Anzahl der Zeilen wird der Name gesucht
            for (int i = 0; i < allFileEntries.size(); i++) {
                String myNextLine = allFileEntries.get(i);
                if (myNextLine.startsWith(letter)) {
                    line = i;//Zeile gefunden
                    System.out.println(allFileEntries.get(line));
                }
            }
            for (int i = 0; i < 1; i++) {
                String myNextLine = allFileEntries.get(i);
                if (!(myNextLine.startsWith(letter))) {
                    line = i;//Zeile gefunden
                    System.out.println("Sorry, this letter doesnt exist!");
                }
            }


        } catch (IOException ex) {
            System.out.println("Error Data not found");
        }

    }
}