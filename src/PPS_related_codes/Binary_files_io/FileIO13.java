package PPS_related_codes.Binary_files_io;
import java.util.*;
import java.io.*;

public class FileIO13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the binary file you want to display:");
        String fileName = sc.next();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            System.out.println("Here is the information stored in the file:");
            System.out.println("============================================");
            String s = ois.readUTF();
            System.out.println(s);

            while (true) {
                try {
                    long id = ois.readLong();
                    Character ch1 = ois.readChar();
                    Character ch2 = ois.readChar();

                    String firstName = ois.readUTF();
                    Character ch3 = ois.readChar();
                    String lastName = ois.readUTF();

                    System.out.println("ID: " + id);
                    System.out.println("First name: " + firstName);
                    System.out.println("Last name: " + lastName);
                    System.out.println("--------------------------------------------");
                } catch (EOFException e) {
                    System.out.println("Reached end of file.");
                    break;
                }
            }
            ois.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            System.exit(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
