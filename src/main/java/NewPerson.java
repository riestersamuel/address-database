import java.util.Scanner;
public class NewPerson {
    String name;
    String mail;
    String number;
    final String[] data = {"name","mail","number"};
    //Konstruktor um eine neue Person hinzuzufügen
    public NewPerson(){

        try (final Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter your name: ");
            this.name = scan.next();
            data[0]=this.name;
            System.out.println(name);
            System.out.println("Enter your mail address: ");
            this.mail = scan.next();
            data[1]=mail;
            System.out.println("mail: "+mail);
            System.out.println("Enter your phone number: ");
            this.number = scan.next();
            data[2]=number;
            System.out.println("phone: "+number);
        }
        }
    }

