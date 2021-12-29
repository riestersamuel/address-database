import java.io.*;

// Klasse um Text in einer Datei abzuspeichern
public class Writer {
    public Writer() {
        //Klasse NewPerson wird aufgerufen, um neue Einträge zu erstellen.
        NewPerson person1 = new NewPerson();
        String name = person1.name;
        String mail = person1.mail;
        String number = person1.number;

        try {
            // neuer Filewriter wird erstellt
            FileWriter myWriter = new FileWriter("filewriter.txt",true);
            // // Die Einträge werden in einer Datei gespeichert.
            myWriter.write( name + ", " + mail + ", " + number + " " + '\n');

            //schließt den Filewriter
            myWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
