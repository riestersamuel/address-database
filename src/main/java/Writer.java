import java.io.FileWriter;
import java.io.IOException;
// Klasse um Text in einer Datei abzuspeichern
public class Writer {
        public static void main(String[] args) {
            try {
                // neuer filewriter wird erstellt
                FileWriter myWriter = new FileWriter("filewriter.txt");
                // hier kann man den Text schreiben, der in der Datei gespeichert werden soll
                myWriter.write("neuer Text");
                //schließt den filewriter
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

