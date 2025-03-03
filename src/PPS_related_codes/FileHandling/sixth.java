package PPS_related_codes.FileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class sixth {
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/sujithkumaravel/Downloads/Sujith_Learns_Java/src/PPS_related_codes/FileHandling/sixth.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        // Read and process only the first 3 lines (long values)
        for (int i = 0; i < 3; i++) {
            String line = reader.readLine();
            if (line == null) {
                break; // Stop if fewer than 3 lines are available
            }
            // Assuming each line starts with a long value followed by whitespace and other text.
            String[] tokens = line.split("\\s+");
            try {
                long id = Long.parseLong(tokens[0]);
                System.out.println("Long value: " + id);
            } catch (NumberFormatException e) {
                System.out.println("Error parsing long from line: " + line);
            }
        }
        reader.close();
    }
}
