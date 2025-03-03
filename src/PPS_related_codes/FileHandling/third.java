package PPS_related_codes.FileHandling;
import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class third {
    public static void main(String [] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/sujithkumaravel/Downloads/Sujith_Learns_Java/src/PPS_related_codes/FileHandling/third.txt"))) {
            writer.write("Hi");
            String[] line = sc.nextLine().split(" ");
            for (String string : line) {
                writer.write("\n" + string);
            }
            writer.close();
        }
        BufferedReader reader = new BufferedReader(new FileReader("/Users/sujithkumaravel/Downloads/Sujith_Learns_Java/src/PPS_related_codes/FileHandling/third.txt"));
        String line;
        while((line = reader.readLine()) != null){
            System.out.println(line);
        }

    }
}
