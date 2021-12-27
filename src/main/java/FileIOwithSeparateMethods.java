import java.io.*;

//Das hier ist mehr oder weniger eine Kopie von FileIO, nur habe ich die Methoden aufgespaltet

public class FileIOwithSeparateMethods {
    public static void write(String dataInput) {
        try {
            BufferedWriter newWriter = new BufferedWriter(new FileWriter("database.txt"));
            newWriter.write(dataInput+"\n");
            newWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read(){
        try {
            BufferedReader newReader = new BufferedReader(new FileReader("database.txt"));
            String line;
            while ((line = newReader.readLine()) != null) {
                System.out.println(line);
            }
            newReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Diese Main Method existiert nur zu Testzwecken
    public static void main(String[] args) {
        String Test = "Samuel, g@mail.de, +41243125231";
        FileIOwithSeparateMethods.write(Test);
    }
}
