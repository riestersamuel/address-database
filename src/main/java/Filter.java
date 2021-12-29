import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
public class Filter {
    public static void main(String[] args) {
        String letter;
        try (final Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter the letter you're searching for: ");
            letter = scan.next();
            try {
                //Zuerst Zeile mit Anfangsbuchstabe suchen
                String myFileName = ".\\filewriter.csv";
                int line = -1;

                //neue Liste mit allen Einträgen der Textdatei wird aufgerufen
                List<String> allFileEntries = Files.readAllLines(Paths.get(myFileName));

                //solange i kleiner ist als die Anzahl der Zeilen wird der Name gesucht
                for(int i=0; i<allFileEntries.size(); i++)
                {
                    String myNextLine = allFileEntries.get(i);
                    if(myNextLine.startsWith(letter)) {
                        line = i;//Zeile gefunden
                        System.out.println(allFileEntries.get(line));
                    }
                }

            }
            catch(IOException ex)
            { }
        }
    }
}