package PPS_related_codes.FileHandling;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class second {
    public static void main(String [ ] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/PPS_related_codes/FileHandling/second.txt"));
        writer.write("Hi");
        String [ ] names = {"Hi", "Sujith", "Dummy", "Java"};
        for(String name : names){
            writer.write("\n" + name);
        }

        writer.close();
    }
}
