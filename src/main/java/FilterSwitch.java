import java.io.IOException;
import java.util.Scanner;

    //Klasse um einen Filter auszuwählen, um die Einträge zu filtern
    public class FilterSwitch {

        //Das ist die Anleitung zum Aussuchen der Filter.
        public static void filterInstructions() {
            System.out.println("Enter number ...");
            System.out.println("0 to filter by the first letter");
            System.out.println("1 to filter by several initial letters");
            System.out.println("2 to filter by the last letter");
            System.out.println("3 to return to main page.");
            System.out.println("");
        }

        public static void convertNumberToMethodFilter() throws IOException {
            //Der Nutzer soll eine Zahl eingegeben. Diese ruft dann die Methode mit dem Filter auf.

            System.out.println("Please enter a number: ");
            final Scanner scan = new Scanner(System.in);
            final int inputNumber = scan.nextInt();
            switch (inputNumber) {
                case 0:
                    System.out.println("Starte Methode 0");
                    final Filterfirstletter filteredentry = new Filterfirstletter();
                    filterInstructions();
                    convertNumberToMethodFilter();
                    break;
                case 1:
                    System.out.println("Starte Methode 1");

                    convertNumberToMethodFilter();
                    break;
                case 2:
                    System.out.println("Starte Methode 2");
                    final Filterlastletter lastletter = new Filterlastletter();
                    filterInstructions();
                    convertNumberToMethodFilter();
                    break;
                case 3:
                    System.out.println("Starte Methode 3");
                    final AdressDatabase a = new AdressDatabase();
                    filterInstructions();
                    convertNumberToMethodFilter();
                    break;


                default:
                    System.out.println("Sorry, this number doesn't do anything.");
            }



            if ((inputNumber > 0 && inputNumber < 3) || (inputNumber >4 && inputNumber <9)) {
                convertNumberToMethodFilter();
            }
        }


        public static void main(String[] args) throws IOException {
            filterInstructions();
            convertNumberToMethodFilter();
        }
    }


