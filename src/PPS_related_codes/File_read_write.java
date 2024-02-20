package PPS_related_codes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class File_read_write{
    public static void main(String[] args) {
        // Specify the path to your file
        String filePath = "/Users/deBauch_Casanova/Downloads/Sujith_learns_Java/src/new.txt";
        String f = "/Users/deBauch_Casanova/Downloads/Sujith_learns_Java/src/out.txt";

        try {
            FileReader fileReader = new FileReader(filePath);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(f);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.write("Hello, this is your new file content!");


            bufferedWriter.close();

            System.out.println("File created successfully at: " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//The new.txt and out.txt are are input and output files for testing.