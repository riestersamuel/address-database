import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Person {
    String firstName, secondName, mail, number;

    //Konstruktor um eine neue Person hinzuzufügen.
    public Person(Scanner scan) {
        System.out.println("Enter your first name: ");
        this.firstName = scan.next().trim();
        System.out.println("Enter your second name: ");
        scan.nextLine();
        this.secondName = scan.nextLine().trim();
        System.out.println("Enter your mail address: ");
        this.mail = scan.next().trim();
        System.out.println("Enter your phone number: ");
        scan.nextLine();
        this.number = scan.nextLine().trim();
        System.out.println("You successfully added this person.");
    }

    //Methode um einen bereits vorhandenen Eintrag zu löschen.
    public static void deleteThisPerson(Scanner scan) {
        String deleteName;
        System.out.println("Enter the first and last name of the person you want to delete: ");
        //Name eingeben, wessen Einträge gelöscht werden sollen.
        scan.nextLine();
        deleteName = scan.nextLine();
        // Name der Person, die gelöscht werden soll wird ausgegeben.
        System.out.println(deleteName + " has been deleted!");

        try {
            //Zuerst zu löschende Zeile suchen
            String myFileName = "address.txt";
            //Bis jetzt ist die Zeile noch unentdeckt daher leer
            int lineToBeDeleted = -1;

            //neue Liste mit allen Einträgen der Textdatei wird aufgerufen
            List<String> allFileEntries = Files.readAllLines(Paths.get(myFileName));

            //solange i kleiner ist als die Anzahl der Zeilen wird der Name gesucht
            for (int i = 0; i < allFileEntries.size(); i++) {
                String myNextLine = allFileEntries.get(i).toUpperCase();
                String[] newWord = myNextLine.split(",");
                if (newWord[0].contains(deleteName.toUpperCase())) {
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
        } catch (IOException ex) { //Fehler und Exceptions für uns als Entwickler offensichtlich machen
            System.out.println("Error. Data not found." + ex.getMessage());
        }
    }
}



