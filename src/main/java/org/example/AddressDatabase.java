package org.example;

public class AddressDatabase {

    /**
     * Das hier wird einmalig automatisch beim Start des Programms aufgerufen, um es zum Laufen zu bringen.
     * Danach läuft es weiter, bis man es stoppt.
     */

    public static void main(String[] args) {
        welcome();
        showinstructions();
        convertNumberToMethod();
    }

    /**
     * Das ist die Anleitung zum Bedienen des Programms. Sie wird standardmäßig beim Starten des Programms angezeigt.
     */

    public static void welcome(){
        System.out.println("Welcome to MyAddressBook\n" +

                "      __...--~~~~~-._   _.-~~~~~--...__\n" +
                "    //               `V'               \\\\ \n" +
                "   //                 |                 \\\\ \n" +
                "  //__...--~~~~~~-._  |  _.-~~~~~~--...__\\\\ \n" +
                " //__.....----~~~~._\\ | /_.~~~~----.....__\\\\\n" +
                "====================\\\\|//====================\n" +
                "                    `---`");
    }

    public static void showinstructions() {

        System.out.println("\nEnter number ...");
        System.out.println("0 to browse person entries.");
        System.out.println("1 to toggle filtering person entries.");
        System.out.println("2 to create a new person entry.");
        System.out.println("3 to delete a person entry.");
        System.out.println("4 to exit this program.\n");
    }

    /**
     * Der Nutzer soll eine Zahl eingegeben. Diese ruft dann die entsprechende Methode auf.
     * Gibt der Nutzer 1 ein, soll der Case 1 gestartet werden, bei 2 Case 2, und so weiter.
     * Falls der Nutzer etwas anderes als eine Zahl eingibt, soll sich die Methode neustarten.
     */

    static void convertNumberToMethod() {
        while(true){
            int inputNumber;

            inputNumber = UI.inputNumber("Please enter a number: ");

            switch (inputNumber) {
                case 0 -> {
                    System.out.println("\nCurrent person entries:");
                    ReaderWriter.read();
                    showinstructions();

                }
                case 1 -> {
                    UI.showFilterInstructions();
                    Filter f = new Filter();
                    showinstructions();
                }
                case 2 -> {
                    ReaderWriter.write();
                    showinstructions();
                }
                case 3 -> {
                    Person.deleteThisPerson();
                    showinstructions();
                }
                case 4 -> {
                    System.out.println("\nShutting down...");
                    System.exit(0);
                }
                default -> {
                    //System.out.println("\nSorry, this input doesn't do anything.");
                    showinstructions();
                }
            }
        }
    }
}
