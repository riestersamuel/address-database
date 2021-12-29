import org.w3c.dom.DOMStringList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class DeletePerson {
    //Konstruktor um einen bereits vorhandenen Eintrag zu löschen
    String deletename;

    public DeletePerson(Scanner scan) {
        //Name eingeben, wessen Einträge gelöscht werden sollen
        System.out.println("Enter the name whose data should be deleted: ");
        this.deletename = scan.next();
        System.out.println(deletename + " will be deleted!");

        try {
            //Zuerst zu löschende Zeile suchen
            String myFileName = ".\\filewriter.csv";
            //bis jetzt ist die Zeile noch unentdeckt daher leer
            int lineToBeDeleted = -1;

            //neue Liste mit allen Einträgen der Textdatei wird aufgerufen
            List<String> allFileEntries = Files.readAllLines(Paths.get(myFileName));

            //solange i kleiner ist als die Anzahl der Zeilen wird der Name gesucht
            for (int i = 0; i < allFileEntries.size(); i++) {
                String myNextLine = allFileEntries.get(i);
                if (myNextLine.contains(deletename)) {
                    lineToBeDeleted = i;//Zeile gefunden
                    break;
                }
            }

            if (lineToBeDeleted != -1) {
                //Zeile gefunden, jetzt Eintrag löschen
                allFileEntries.remove(lineToBeDeleted);
                FileWriter myFileWriter = new FileWriter(myFileName);

                //Komplette Datei schreiben, ohne den gelöschten Eintrag
                for (String s : allFileEntries) {
                    myFileWriter.write(s + "\n");
                }
                //schreibt den Eintrag wieder auf die Festplatte
                myFileWriter.flush();
            }
        } catch (IOException ex) {
        }

    }
}
