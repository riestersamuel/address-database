package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Klasse um Text in einer Datei abzuspeichern
 */
public class ReaderWriter {
    public static void write() {
        //Klasse NewPerson wird aufgerufen, um neue Einträge zu erstellen.
        Person person = new Person();
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
    public static void read() {

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

