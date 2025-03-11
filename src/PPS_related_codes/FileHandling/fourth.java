package PPS_related_codes.FileHandling;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;



public class fourth{

    public static void main(String[] args) // Notice that the main() function is not declaring the exception
    {

        // Create an output stream object to write to a file
        // The "real" output file name will be called "Info.text";
        // notice that this can be any other name
        PrintWriter pw = null;		// Declare the object outside of the "try" block;
        // otherwise, it is only visible there
        // We also need to set to null; otherwise compiler will
        // complain about its utilization after the try-catch block
        // as being not initialized
        String s;
        Scanner kb = new Scanner(System.in);

        try
        {
            pw = new PrintWriter(new FileOutputStream("/Users/sujithkumaravel/Downloads/Sujith_Learns_Java/src/PPS_related_codes/FileHandling/Info.txt"));

        }
        catch(FileNotFoundException e) 			// Since we are attempting to write to the file
        {							   			// exception is automatically thrown if file cannot be created.
            System.out.println("Could not create a file to write to. "
                    + " Please check for problems such as directory permission"
                    + " or no available memory.");
            System.out.print("Program will terminate.");
            System.exit(0);
        }
        System.out.print("We need to store your information; Please enter your First and Last Name:");
        s = kb.nextLine();
        pw.println("Name: " + s);	// Write this info to the file

        System.out.print("\nPlease enter your Address: ");
        s = kb.nextLine();
        pw.println("Address: " + s);	// Write this info to the file

        System.out.print("\nPlease enter your School Name: ");
        s = kb.nextLine();
        pw.println("School Name: " + s);	// Write this info to the file

        pw.close();		// Close the file

        System.out.println("Thank you for filling your information.");
        System.out.println("Your information has been stored in a file called \"Info.txt\".");
    }
}
