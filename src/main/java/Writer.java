import java.io.FileWriter;
import java.io.IOException;
// Klasse um Text in einer Datei abzuspeichern
public class Writer {
        public Writer () {
            NewPerson person1 = new NewPerson();
            String name = person1.name;
            String mail = person1.mail;
            String number= person1.number;
            //Klasse NewPerson wird aufgerufen, um neue Einträge zu erstellen.
            try {
                // neuer Filewriter wird erstellt
                FileWriter myWriter = new FileWriter("filewriter.csv");
                // Die Einträge werden in einer Datei gespeichert.
                myWriter.write(name + ", " + mail + ", " + number);
                //schließt den Filewriter
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

