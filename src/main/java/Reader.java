import java.io.FileReader;
import java.io.IOException;
// Klasse um Text aus einer Datei zu lesen
class Reader {
    public Reader() throws IOException {
        // erstellt einen filereader
        FileReader input = new FileReader( "filewriter.txt");

        // erstellt einen neuen Array mit Anzahl der Zeichen, die ausgegeben werden sollen
        char[] text = new char[100];

       while((input.read(text))>=0){
           // Text aus der Datei wird ausgegeben
           System.out.println(text);

        }

    }
}

