package PPS_related_codes.FileHandling;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;


public class first {
    public static void main(String[] args) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("first.txt"))) {
            writer.write("This is written to the file");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
