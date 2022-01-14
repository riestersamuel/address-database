package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class ReaderWriter {
    /**
     * Diese Methode erstellt neue Einträge in der Textdatei
     */
    public static void write() {

        Person person = new Person();
        String firstname = person.firstName;
        String mail = person.mail;
        String number = person.number;
        String secondname = person.lastName;

        try {

            FileWriter myWriter = new FileWriter("address.txt", true);
            // Die Einträge werden in einer Datei gespeichert.
            myWriter.write(firstname + " " + secondname + ", mail: " + mail + ", number: " + number + " " + '\n');
            myWriter.close();

        } catch (IOException e) {
            System.out.println("Error. Data not found.");
            e.printStackTrace();
        }
    }

    /**
     * Diese Methode ermöglicht das lesen der Einträge innerhalb der Textdatei
     */

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

