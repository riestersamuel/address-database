import org.w3c.dom.DOMStringList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class DeletePerson {
    //Konstruktor um einen bereits vorhandenen Eintrag zu löschen
        String deletename;
        public DeletePerson() {
            //NewPerson person = new NewPerson();

            try (final Scanner scan = new Scanner(System.in)) {
                System.out.println("Enter the name whose data should be deleted: ");
                this.deletename = scan.next();
                System.out.println(deletename+" will be deleted!");

                try {
                    //Zuerst zu löschende Zeile suchen
                    String myFileName = ".\\filewriter.csv";
                    int lineToBeDeleted = -1;

                    List<String> allFileEntries = Files.readAllLines(Paths.get(myFileName));

                    for(int i=0; i<allFileEntries.size(); i++)
                    {
                        String myNextLine = allFileEntries.get(i);
                        if(myNextLine.contains(deletename)) {
                            lineToBeDeleted = i;//Zeile gefunden
                            break;
                        }
                    }

                    if(lineToBeDeleted!=-1)
                    {
                        //Zeile gefunden, jetzt Eintrag löschen
                        allFileEntries.remove(lineToBeDeleted);
                        FileWriter myFileWriter = new FileWriter(myFileName);
                        BufferedWriter bufferedWriter = new BufferedWriter(myFileWriter);
                        //Komplette Datei schreiben, ohne den gelöschten Eintrag
                        for (String s : allFileEntries) {
                            bufferedWriter.write(s + "\n");
                        }
                        bufferedWriter.flush();
                    }
                }
                catch(IOException ex)
                { }

                /*Das kann gelöscht werden
                if (deletename==person.data[0]){
                    person.data[0]="empty";
                    person.data[1]="empty";
                    person.data[2]="empty";
                }*/
               /*this.deletename = null;
               System.out.println(deletename);*/
            }
        }
    }
