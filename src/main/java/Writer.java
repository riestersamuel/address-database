import java.io.FileWriter;
import java.io.IOException;
// Klasse um Text in einer Datei abzuspeichern
public class Writer {
        public static void main(String[] args) {
            NewPerson person1 = new NewPerson();
            String name = person1.name;
            String mail = person1.mail;
            String number= person1.number;
            try {
                // neuer filewriter wird erstellt
                FileWriter myWriter = new FileWriter("filewriter.txt");
                // hier kann man den Text schreiben, der in der Datei gespeichert werden soll
                myWriter.write(name + ", " + mail + ", " + number);
                //schließt den filewriter
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

