import java.io.*;

// Klasse um Text in einer Datei abzuspeichern
public class Writer {
    public Writer() {
        NewPerson person1 = new NewPerson();
        String name = person1.name;
        String mail = person1.mail;
        String number = person1.number;

        try {
            // neuer filewriter wird erstellt
            FileWriter myWriter = new FileWriter("filewriter.csv",true);
            // hier kann man den Text schreiben, der in der Datei gespeichert werden soll
            myWriter.write( name + ", " + mail + ", " + number + " " + '\n');

            //schließt den filewriter
            myWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
