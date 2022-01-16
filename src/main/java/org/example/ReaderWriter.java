package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReaderWriter {
    /**
     * Diese Methode erstellt neue Einträge in der Textdatei
     */
    public static void write(Person person) {

        String firstname = person.firstName;
        String mail = person.mail;
        String number = person.number;
        String secondname = person.lastName;

        try {

            FileWriter myWriter = new FileWriter("address.txt", true);
            // Die Einträge werden in einer Datei gespeichert.
            myWriter.write(firstname + " " + secondname + ", mail: " + mail + ", number: " + number + '\n');
            myWriter.close();

        } catch (IOException e) {
            System.out.println("Error. Data not found.");
            e.printStackTrace();
        }
    }

    /**
     * Diese Methode ermöglicht das lesen der Einträge innerhalb der Textdatei
     * @return Textdatei Einträge
     */
    public static List<String> read() {

        List<String> entries = new ArrayList<>();
        try {
            BufferedReader newReader = new BufferedReader(new FileReader("address.txt"));
            String line;
            while ((line = newReader.readLine()) != null) {
                entries.add(line);
            }
            newReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }

    public static void removeEntries() {
        try {
            FileWriter fw = new FileWriter("address.txt");
            fw.write("");
            fw.close();
        } catch ( IOException ioex ) {
            System.out.println("Fehler");
        }
    }
}

