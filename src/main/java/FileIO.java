import java.io.*;

public class FileIO {
    public static void main(String[] args) {
        String[] examplePerson = {"Samuel", "riestersamuel@icloud.com", "+4915128992346"};

        //Das Try-Catch-Teil ist nur formhalber da. Keine Ahnung was das genau macht (wahrscheinlich Fehler vorbeugen).
        try {
            BufferedWriter newWriter = new BufferedWriter(new FileWriter("database.txt"));

            //Hiermit schreiben wir in die Textdatei.
            newWriter.write("Test");
            newWriter.write("\nHi, das ist ne neue Linie. Beim ersten Mal newWriter.write() erzeugt es die Datei, aber immer danach wird sie überschrieben.\n");

            //Jetzt schreiben wir mal eine Stringarray ...
            for (int i = 0; i < examplePerson.length; i++) {
                newWriter.write(examplePerson[i] + " ");
            }

            //Man muss die Datei danach zwingend wieder schließen.
            newWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader newReader = new BufferedReader(new FileReader("database.txt"));
            //So lesen wir die erste Zeile der Datei aus:
            //System.out.println(newReader.readLine());
            //Wir wollen ja aber alle Zeilen sehen, also nutzen wir eine Loop.
            //Das Try-Catch-Gedöns dient wieder nur der Fehlervorbeugung.
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
