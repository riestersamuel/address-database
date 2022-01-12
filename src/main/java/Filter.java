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
    final List<String> allFileEntries;
    static int line;
    final String myFileName = "address.txt";


    public static void showFilterInstructions() {
        System.out.println("\nPlease select your filter. Enter number ...");
        System.out.println("0 to filter by the first letter of a person's last name.");
        System.out.println("1 to filter by several initial letters (also concerning the last name).");
        System.out.println("2 to filter by the first letter of a person's first name.");
        System.out.println("3 to return to main page.\n");
    }

    public Filter(Scanner scan) throws IOException {
        //try catch
        allFileEntries = Files.readAllLines(Paths.get(myFileName));

        //Der Nutzer soll eine Zahl eingegeben. Diese ruft dann die Methode mit dem Filter auf.
        System.out.println("Please enter a number: ");

        try {
            final int inputNumber = scan.nextInt();
            switch (inputNumber) {
                case 0:
                    // Wenn 0 eingegeben wird, wird nach dem Anfangsbuchstaben des Nachnamens gefiltert.
                    firstLetterLastName(scan);
                    showFilterInstructions();
                    Filter c = new Filter(scan);
                    break;
                case 1:
                    // Wenn 1 eingegeben wird, wird nach mehreren Anfangsbuchstaben des Nachnamens gefiltert
                    InitialLetters(scan);
                    showFilterInstructions();
                    Filter b = new Filter(scan);
                    break;
                case 2:
                    // Wenn 2 eingegeben wird, wird nach dem Anfangsbuchstaben des Vornamen gefiltert.
                    firstLetterFirstName(scan);
                    showFilterInstructions();
                    Filter a = new Filter(scan);

                    break;
                case 3:
                    // Wenn 3 eingegeben wird, wird die Startseite angezeigt.
                    AddressDatabase.showinstructions();
                    AddressDatabase.convertNumberToMethod();
                    Filter e = new Filter(scan);
                    break;
                default:
                    // Wenn eine ungültige Zahl eingegeben wird, wird eine Fehlermeldung ausgegeben.
                    System.out.println("Sorry, this number doesn't do anything.");
                    showFilterInstructions();
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

    private void firstLetterLastName(Scanner scan) {
        //Filter für den Anfangsbuchstaben des Nachnamens

        System.out.println("\nEnter the first letter of the person's last name you're searching for: ");
        letter = scan.next();
        for (int i = 0; i < allFileEntries.size(); i++) {
            String dataAtLineI = allFileEntries.get(i).toUpperCase();
            String[] newWord = dataAtLineI.split(" ");
            //Annahme: Wenn mind. 1 Objekt mit dem Buchstabe anfängt, dann keine Fehlermeldung, sonst Fehlermeldung
            //Also: Wenn nicht mind. ein Objekt mit dem Buchstabe anfängt -> Fehlermeldung
            if (newWord[1].startsWith(letter.toUpperCase())) {
                line = i;//Zeile gefunden
                System.out.println(allFileEntries.get(line));
                atLeastOneMatchingEntry = true;
            }
        }
        if (!atLeastOneMatchingEntry) {
            System.out.println("\nSorry, no matching entries were found.");
        }
    }

    private void InitialLetters(Scanner scan) {
        //Filter für einen Bereich von Anfangsbuchstaben des Nachnamens

        System.out.println("\nEnter the letters you're searching for (in the format L-S): ");
        /*Anfangs- und Endbuchstabe eingeben. Es werden die Namen gesucht deren Anfangsbuchstaben
         im Alphabet zwischen den eingegebenen Buchstaben liegen.*/
        letter = scan.next();
        for (int i = 0; i < allFileEntries.size(); i++) {
            String dataAtLineI = allFileEntries.get(i).toUpperCase();
            if (dataAtLineI.matches("^[" + letter.toUpperCase() + "].*")) {
                line = i;//Zeile gefunden
                System.out.println(allFileEntries.get(line));
                atLeastOneMatchingEntry = true;
            }
        }
        if (!atLeastOneMatchingEntry) {
            System.out.println("\nSorry, no matching entries were found.");
        }

    }

    private void firstLetterFirstName(Scanner scan) {
        System.out.println("\nEnter the first letter of the person's first name you're searching for: ");
        letter = scan.next();
        System.out.println("\nThese matching entries were found ... ");
        //Solange i kleiner ist als die Anzahl der Zeilen wird der Name gesucht
        for (int i = 0; i < allFileEntries.size(); i++) {
            String myNextLine = allFileEntries.get(i).toUpperCase();
            String[] newWord = myNextLine.split(" ");
            if (newWord[0].startsWith(letter.toUpperCase())) {
                line = i;//Zeile gefunden
                System.out.println(allFileEntries.get(line));
                atLeastOneMatchingEntry = true;
            }
        }
        if (!atLeastOneMatchingEntry) {
            System.out.println("\nSorry, no matching entries were found.");
        }

    }


}