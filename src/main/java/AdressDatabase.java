public class AdressDatabase {

    //Das ist die Anleitung zum Bedienen des Programms. Sie wird standardmäßig beim Starten des Programms angezeigt.
    public static void basicInformation(){
        System.out.println("Press number ...");
        System.out.println("0 to browse person entries.");
        System.out.println("1 to toggle filtering person entries.");
        System.out.println("2 to create a new person entry.");
        System.out.println("3 to delete a person entry.");
        System.out.println("4 to exit this program.");
    }

    //Hiermit wandeln wir die vom Nutzer eingegebene Zahl in die Anwendung der entsprechenden Methode um.
    public static void convertNumberToMethod(int number) {
        switch (number) {
            /*Diese Methoden müssen erst noch geschrieben werden
            case 1: method; break;
            case 2: Person.createNewPersonEntry(); break;
            case 3: method; break;
            case 4: method; break;
            case 5: method; break;*/
        }
    }

    public static void main(String[] args) {
        basicInformation();
        String firstEntry = Person.createNewPersonEntry(0, "Samuel", "Riester", "riestersamuel@icloud.com", 12345);
        System.out.println(firstEntry);
    }
}
