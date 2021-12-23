public class Person {

    //Die Methode um einen neuen Eintrag bzw. eine neue Person hinzuzufügen
    public static String createNewPersonEntry(int personNumber, String firstName, String secondName, String email, int phone){
        return personNumber + ": " + firstName + " " + secondName + ", email: " + email + ", phone: " + phone;
    }
}
