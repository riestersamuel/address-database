package org.example;

public class AddressDatabase {

    /**
     * Das hier wird einmalig automatisch beim Start des Programms aufgerufen, um es zum Laufen zu bringen.
     * Danach läuft es weiter, bis man es stoppt.
     */

    public static void main(String[] args) {
        welcome();
        showInstructions();
        convertNumberToMethod();
    }

    /**
     * Das ist die Anleitung zum Bedienen des Programms. Sie wird standardmäßig beim Starten des Programms angezeigt.
     */

    public static void welcome() {
        UI.output("Welcome to MyAddressBook\n" +

                "      __...--~~~~~-._   _.-~~~~~--...__\n" +
                "    //               `V'               \\\\ \n" +
                "   //                 |                 \\\\ \n" +
                "  //__...--~~~~~~-._  |  _.-~~~~~~--...__\\\\ \n" +
                " //__.....----~~~~._\\ | /_.~~~~----.....__\\\\\n" +
                "====================\\\\|//====================\n" +
                "                    `---`");
    }

    public static void showInstructions() {

        UI.output("\nEnter number ...");
        UI.output("0: to browse person entries.");
        UI.output("1: to toggle filtering person entries.");
        UI.output("2: to create a new person entry.");
        UI.output("3: to delete a person entry.");
        UI.output("4: to exit this program.\n");
    }

    /**
     * Der Nutzer soll eine Zahl eingegeben. Diese ruft dann die entsprechende Methode auf.
     * Gibt der Nutzer 1 ein, soll der Case 1 gestartet werden, bei 2 Case 2, und so weiter.
     * Falls der Nutzer etwas anderes als eine Zahl eingibt, soll sich die Methode neustarten.
     */

    static void convertNumberToMethod() {
        while (true) {
            int inputNumber;

            inputNumber = UI.inputNumber("Please enter a number: ");

            switch (inputNumber) {
                case 0 -> {
                    UI.output("\nCurrent person entries:");
                    UI.outputList(ReaderWriter.read());
                    showInstructions();

                }
                case 1 -> {
                    UI.showFilterInstructions();
                    Filter f = new Filter();
                    showInstructions();
                }
                case 2 -> {
                    ReaderWriter.write(new Person());
                    showInstructions();
                }
                case 3 -> {
                    Person.deleteThisPerson();
                    showInstructions();
                }
                case 4 -> {
                    UI.output("\nShutting down...");
                    System.exit(0);
                }
                default -> {
                   // UI.output("\nSorry, this input doesn't do anything.");
                    showInstructions();
                }
            }
        }
    }
}
