import java.io.*;
import java.util.Scanner;

// Klasse um Text in einer Datei abzuspeichern
public class Writer {
    public Writer(Scanner scan) {
        //Klasse NewPerson wird aufgerufen, um neue Einträge zu erstellen.
        NewPerson person1 = new NewPerson(scan);
        String name = person1.name;
        String mail = person1.mail;
        String number = person1.number;

        try {
            // neuer Filewriter wird erstellt
            FileWriter myWriter = new FileWriter("address.txt",true);
            // // Die Einträge werden in einer Datei gespeichert.
            myWriter.write( name + ", mail: " + mail + ", number: " + number + " " + '\n');

            //schließt den Filewriter
            myWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
