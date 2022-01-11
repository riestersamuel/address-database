import java.util.Scanner;

public class NewPerson {
    String firstName, secondName, mail, number;

    //Konstruktor um eine neue Person hinzuzufügen.
    public NewPerson(Scanner scan) {
        System.out.println("Enter your first name: ");
        this.firstName = scan.next().trim();
        System.out.println("Enter your second name: ");
        scan.nextLine();
        this.secondName = scan.nextLine().trim();
        System.out.println("Enter your mail address: ");
        this.mail = scan.next().trim();
        System.out.println("Enter your phone number: ");
        scan.nextLine();
        this.number = scan.nextLine().trim();
        System.out.println("You successfully added this person.");
    }
}

