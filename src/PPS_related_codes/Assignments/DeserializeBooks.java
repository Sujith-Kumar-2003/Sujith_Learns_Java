package PPS_related_codes.Assignments;//SUJITH KUMAR KUMARVEL 40281567, Jothi Basu LKV 40230416
// COMP6481 Assignment # Due Date
//Assignment-2
// Due 24 March
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
/**
 * The DeserializeBooks class demonstrates deserialization of a list of books from a serialized file.
 */
public class DeserializeBooks {
    public static void main(String[] args) {
        String serializedFileName = "/Users/deBauch_Casanova/Downloads/PPS_ASSIGNMENT_2/PART_1_OP/Cartoon_Comics.csv.ser";

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(serializedFileName))) {
            // Read the list of books from the serialized file
            List<Book> books = (List<Book>) inputStream.readObject();

            // Print the deserialized books
            for (Book book : books) {
                System.out.println(book);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
