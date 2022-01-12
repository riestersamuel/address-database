import java.io.*;
import java.util.Scanner;

/**
 * Klasse um Text in einer Datei abzuspeichern
 */
public class Writer {
    public static void write(Scanner scan) {
        //Klasse NewPerson wird aufgerufen, um neue Einträge zu erstellen.
        Person person = new Person(scan);
        String firstname = person.firstName;
        String mail = person.mail;
        String number = person.number;
        String secondname = person.secondName;

        try {
            // neuer Filewriter wird erstellt
            FileWriter myWriter = new FileWriter("address.txt", true);
            // Die Einträge werden in einer Datei gespeichert.
            myWriter.write(firstname + " " + secondname + ", mail: " + mail + ", number: " + number + " " + '\n');

            //schließt den Filewriter
            myWriter.close();

        } catch (IOException e) {
            System.out.println("Error. Data not found.");
            e.printStackTrace();
        }
    }
}
