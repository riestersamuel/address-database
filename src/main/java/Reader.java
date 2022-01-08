import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//Nur zum Commiten
// Klasse um Text aus einer Datei zu lesen
class Reader {
    public static void read() throws IOException {
        try {

            BufferedReader newReader = new BufferedReader(new FileReader("address.txt"));
            String line;
            while ((line = newReader.readLine()) != null) {
                System.out.println(line);
            }
            newReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

