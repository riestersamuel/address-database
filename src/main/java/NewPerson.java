import java.util.Scanner;
public class NewPerson {
    String name, mail, number;

    //Konstruktor um eine neue Person hinzuzufügen
    public NewPerson(Scanner scannerA){
            System.out.println("Enter your name: ");
            this.name = scannerA.next();
            System.out.println(name);
            System.out.println("Enter your mail address: ");
            this.mail = scannerA.next();
            System.out.println("mail: "+mail);
            System.out.println("Enter your phone number: ");
            this.number = scannerA.next();
            System.out.println("phone: "+number);

        }
    }

