package org.example;
import java.util.Scanner;
public class newperson {
    public static void main(String[] args) {
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
