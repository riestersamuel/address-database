import java.util.Scanner;

public class NewPerson {
    String name, mail, number;

    //Konstruktor um eine neue Person hinzuzufügen
    public NewPerson(Scanner scan) {
        System.out.println("Enter your name (please capitalize the first letter): ");
        this.name = scan.next();
        System.out.println("Enter your mail address (please write everything in small letters): ");
        this.mail = scan.next();
        System.out.println("Enter your phone number: ");
        this.number = scan.next();
        System.out.println("You successfully added this person.");
    }
}

