import java.util.Scanner;
public class NewPerson {
    String name;
    String mail;
    String number;
    //public static void main(String[] args) {
    public NewPerson(){

        try (final Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter your name: ");
            this.name = scan.next();
            System.out.println(name);
            System.out.println("Enter your mail address: ");
            this.mail = scan.next();
            System.out.println("mail: "+mail);
            System.out.println("Enter your phone number: ");
            this.number = scan.next();
            System.out.println("phone: "+number);
        }
        }
    }

