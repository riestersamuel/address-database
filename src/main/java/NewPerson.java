import java.util.Scanner;

public class NewPerson {
    String name, mail, number;

    //Konstruktor um eine neue Person hinzuzufügen
    public NewPerson(Scanner scan) {
        System.out.println("Enter your name: ");
        this.name = scan.next();
        System.out.println(name);
        System.out.println("Enter your mail address: ");
        this.mail = scan.next();
        System.out.println("mail: " + mail);
        System.out.println("Enter your phone number: ");
        this.number = scan.next();
        System.out.println("phone: " + number);

    }
}

