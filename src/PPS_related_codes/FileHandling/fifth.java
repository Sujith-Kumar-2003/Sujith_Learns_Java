package PPS_related_codes.FileHandling;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class fifth {
    public static void main(String [ ] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        // Nortice the true(append) in the next line this will add this to the previous file
        BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/sujithkumaravel/Downloads/Sujith_Learns_Java/src/PPS_related_codes/FileHandling/fifth.txt", true));
        System.out.println("Enter your first and last name: ");
        String name  = sc.nextLine();

        writer.write("Name: " + name);

        System.out.println("Enter the address: ");
        String address = sc.nextLine();
        writer.write("\n Address: "+ address);

        System.out.println("Enter the school name: ");
        String school = sc.nextLine();
        writer.write("\n School name : "+ school);
        writer.close();
    }

}
