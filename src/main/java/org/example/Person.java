package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Person {
    /**
     * Konstruktor um eine neue Person hinzuzufügen.
     *
     * @param firstName
     * @param lastName
     * @param mail
     * @param number
     */
    String firstName, lastName, mail, number;

    public Person() {

        this.firstName = UI.inputLine("Enter your first name: ");

        this.lastName = UI.inputLine("Enter your last name: ");

        this.mail = UI.inputLine("Enter your mail address: ");

        this.number = UI.inputLine("Enter your number: ");
        UI.output("You successfully added this person.");
    }

    /**
     * Konstruktor um eine neue Person hinzuzufügen.
     *
     * @param firstName Vorname
     * @param lastName Nachname
     * @param mail E-Mail Addresse
     * @param number Telefonnummer
     */
    public Person(String firstName, String lastName, String mail, String number){
        this.firstName=firstName;
        this.lastName=lastName;
        this.mail=mail;
        this.number=number;
    }

    /**
     * Diese Methode wird genutzt um einen bereits vorhandenen Eintrag zu löschen.
     * Der Eintrag wird durch Aufrufen einer Liste gesucht und anschließend die ganze Zeile gelöscht.
     *
     * @Param deleteName Name dessen Eintrag gelöscht werden soll
     * @Param myFileName enthält Einträge der Liste
     * @Param lineToBeDeleted gesuchter Index
     */

    public static void deleteThisPerson() {

        String deleteName;
        deleteName = UI.inputLine("Enter the first and last name of the person you want to delete: ");
        UI.output(deleteName + " has been deleted!");

        try {

            String myFileName = "address.txt";
            int lineToBeDeleted = -1;

            List<String> allFileEntries = Files.readAllLines(Paths.get(myFileName));

            for (int i = 0; i < allFileEntries.size(); i++) {
                String myNextLine = allFileEntries.get(i).toUpperCase();
                String[] newWord = myNextLine.split(",");
                if (newWord[0].contains(deleteName.toUpperCase())) {
                    lineToBeDeleted = i;
                    break;
                }
            }

            if (lineToBeDeleted != -1) {

                allFileEntries.remove(lineToBeDeleted);
                FileWriter myFileWriter = new FileWriter(myFileName);

                for (String s : allFileEntries) {
                    myFileWriter.write(s + "\n");
                }
                myFileWriter.flush();
            }
        } catch (IOException ex) {
            UI.output("Error. Data not found." + ex.getMessage());
        }
    }
}



