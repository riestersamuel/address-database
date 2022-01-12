import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//Klasse um einen Filter auszuwählen, um die Einträge zu filtern.
public class Filter {
    static boolean atLeastOneMatchingEntry = false;
    static String letter;

    static int line;

    public static void showFilterInstructions() {
        System.out.println("\nPlease select your filter. Enter number ...");
        System.out.println("0 to filter by the first letter of a person's last name.");
        System.out.println("1 to filter by several initial letters (also concerning the last name).");
        System.out.println("2 to filter by the first letter of a person's first name.");
        System.out.println("3 to return to main page.\n");
    }

    public Filter(Scanner scan) throws IOException {
        showFilterInstructions();
        String myFileName = "address.txt";
        //try catch
        List<String> allFileEntries = Files.readAllLines(Paths.get(myFileName));
        letter = scan.next();
        //Der Nutzer soll eine Zahl eingegeben. Diese ruft dann die Methode mit dem Filter auf.
        System.out.println("Please enter a number: ");

        try {
            final int inputNumber = scan.nextInt();
            switch (inputNumber) {
                case 0:
                    // Wenn 0 eingegeben wird, wird nach dem Anfangsbuchstaben des Nachnamens gefiltert.
                    firstLetterLastName();
                    showFilterInstructions();
                    Filter d = new Filter(scan);
                    break;
                case 1:
                    // Wenn 1 eingegeben wird, wird nach mehreren Anfangsbuchstaben des Nachnamens gefiltert
                    InitialLetters();
                    showFilterInstructions();
                    Filter a = new Filter(scan);
                    break;
                case 2:
                    // Wenn 2 eingegeben wird, wird nach dem Anfangsbuchstaben des Vornamen gefiltert.
                    firstLetterFirstName();
                    showFilterInstructions();
                    Filter b = new Filter(scan);
                    break;
                case 3:
                    // Wenn 3 eingegeben wird, wird die Startseite angezeigt.
                    AddressDatabase.showinstructions();
                    AddressDatabase.convertNumberToMethod();
                    break;


                default:
                    // Wenn eine ungültige Zahl eingegeben wird, wird eine Fehlermeldung ausgegeben.
                    System.out.println("Sorry, this number doesn't do anything.");
                    showFilterInstructions();
                    Filter c = new Filter(scan);
            }
        }
        // Exception für ungültige Benutzereingabe
        catch (InputMismatchException e) {
            // Fehlermeldung wird angegeben.
            System.out.println("Invalid input, please try something else.");
            scan.nextLine(); // Scanner-Puffer leeren
            showFilterInstructions(); // Filter Switch wird neu gestartet
            Filter d = new Filter(scan);

        }
    }

    private void firstLetterFirstName() {
        System.out.println("\nEnter the first letter of the person's first name you're searching for: ");

        for (int i = 0; i < allFileEntries.size(); i++) {
            String dataAtLineI = allFileEntries.get(i).toUpperCase();
            String[] newWord = dataAtLineI.split(" ");
            //Annahme: Wenn mind. 1 Objekt mit dem Buchstabe anfängt, dann keine Fehlermeldung, sonst Fehlermeldung
            //Also: Wenn nicht mind. ein Objekt mit dem Buhcstabe anfängt -> Fehlermeldung
            if (newWord[0].startsWith(letter.toUpperCase())) {
                atLeastOneMatchingEntry = true;
                break;
            }
        }
        if (!atLeastOneMatchingEntry) {
            System.out.println("\nSorry, no matching entries were found.");
        }
        //Wenn es mindestens einen passenden Eintrag gibt, soll eine passende Nachricht und alle Einträge angezeigt werden.
        else {
            System.out.println("\nThese matching entries were found ... ");
            //Solange i kleiner ist als die Anzahl der Zeilen wird der Name gesucht
            for (int i = 0; i < allFileEntries.size(); i++) {
                String myNextLine = allFileEntries.get(i).toUpperCase();
                String[] newWord = myNextLine.split(" ");
                if (newWord[0].startsWith(letter.toUpperCase())) {
                    line = i;//Zeile gefunden
                    System.out.println(allFileEntries.get(line));
                }
            }
        }
    }

    private static void InitialLetters() {
        //Filter für einen Bereich von Anfangsbuchstaben des Nachnamens

        System.out.println("\nEnter the letters you're searching for (in the format L-S): ");
        /*Anfangs- und Endbuchstabe eingeben. Es werden die Namen gesucht deren Anfangsbuchstaben
         im Alphabet zwischen den eingegebenen Buchstaben liegen.*/

        for (int i = 0; i < allFileEntries.size(); i++) {
            String dataAtLineI = allFileEntries.get(i).toUpperCase();
            if (dataAtLineI.matches("^[" + letter.toUpperCase() + "].*")) {
                atLeastOneMatchingEntry = true;
                break;
            }
        }
        // Wenn kein Eintrag mit dem eingegebenen Buchstabenbereich beginnt wird eine Fehlermeldung ausgegeben.
        if (!atLeastOneMatchingEntry) {
            System.out.println("\nSorry, no matching entries were found.");
        }
        //Wenn es mindestens einen passenden Eintrag gibt, soll eine passende Nachricht und alle Einträge angezeigt werden.
        else {
            System.out.println("\nThese matching entries were found:");
            //Solange i kleiner ist als die Anzahl der Zeilen wird der Name gesucht
            for (int i = 0; i < allFileEntries.size(); i++) {
                // die Textdatei wird zeilenweise ausgelesen und in Großbuchstaben umgewandelt
                String myNextLine = allFileEntries.get(i).toUpperCase();
                // Jedes Zeichen der Zeile, das durch ein Leerzeichen getrennt ist, wird als einzelner Sting in einem Array gespeichert.
                String[] newWord = myNextLine.split(" ");
                // Wenn der Sting am Index 0 mit einem der Buchstaben beginnt, wird die Zeile ausgegeben.
                if (newWord[1].matches("^[" + letter.toUpperCase() + "].*")) {
                    line = i;//Zeile gefunden
                    System.out.println(allFileEntries.get(line));
                }
            }
        }
    }

    private static void firstLetterLastName() {
        //Filter für den Anfangsbuchstaben des Nachnamens

        System.out.println("\nEnter the first letter of the person's last name you're searching for: ");

        for (int i = 0; i < allFileEntries.size(); i++) {
            String dataAtLineI = allFileEntries.get(i).toUpperCase();
            String[] newWord = dataAtLineI.split(" ");
            //Annahme: Wenn mind. 1 Objekt mit dem Buchstabe anfängt, dann keine Fehlermeldung, sonst Fehlermeldung
            //Also: Wenn nicht mind. ein Objekt mit dem Buchstabe anfängt -> Fehlermeldung
            if (newWord[1].startsWith(letter.toUpperCase())) {
                atLeastOneMatchingEntry = true;
                break;
            }
        }
        if (!atLeastOneMatchingEntry) {
            System.out.println("\nSorry, no matching entries were found.");
        }
        //Wenn es mindestens einen passenden Eintrag gibt, soll eine passende Nachricht und alle Einträge angezeigt werden.
        else {
            System.out.println("\nThese matching entries were found ... ");
            //Solange i kleiner ist als die Anzahl der Zeilen wird der Name gesucht
            for (int i = 0; i < allFileEntries.size(); i++) {
                String myNextLine = allFileEntries.get(i).toUpperCase();
                String[] newWord = myNextLine.split(" ");
                if (newWord[1].startsWith(letter.toUpperCase())) {
                    line = i;//Zeile gefunden
                    System.out.println(allFileEntries.get(line));
                }
            }
        }
    }
}
}