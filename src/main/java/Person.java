import java.util.Scanner;

public class Person {
    String name, mail, number;

    //Per Konstruktor
    public Person(){
        try (final Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter your name: ");
            final String name = scan.next();
            System.out.println(name);
            System.out.println("Enter your mail address: ");
            final String mail = scan.next();
            System.out.println("mail: "+mail);
            System.out.println("Enter your phone number: ");
            final String number = scan.next();
            System.out.println("phone: "+number);
        }
    }

    //... oder lieber per Methode?
    public static void addPerson(){
        try (final Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter your name: ");
            final String name = scan.next();
            System.out.println(name);
            System.out.println("Enter your mail address: ");
            final String mail = scan.next();
            System.out.println("mail: "+mail);
            System.out.println("Enter your phone number: ");
            final String number = scan.next();
            System.out.println("phone: "+number);
        }
    }
}
