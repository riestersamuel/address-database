import java.util.Scanner;
public class DeletePerson {
    //Konstruktor um einen bereits vorhandenen Eintrag zu löschen
        String deletename;
        public DeletePerson() {
            try (final Scanner scan = new Scanner(System.in)) {
                System.out.println("Enter the name whose data should be deleted: ");
                this.deletename = scan.next();
                deletename = null;
                System.out.println("name has been deleted");
            }
        }
    }
