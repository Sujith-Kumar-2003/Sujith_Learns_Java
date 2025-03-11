package PPS_related_codes.Binary_files_io;

import java.util.Scanner;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileIO12{


    public static void main(String[] args)
    {

        // This program will store student registration information of some course.
        // The registration information will be entered by the user and stored in
        // binary file.

        long id;
        String fileName, courseName, firstName, lastName, jk;


        Scanner kb = new Scanner(System.in);

        System.out.print("Please enter the course name for which you wish to add student registration: ");
        courseName = kb.next();

        // Construct file name based on the course name
        fileName = courseName + "_registeration.dat";
        System.out.println("The registration information will be stored in a \"binary\" file called: " +
                fileName);

        ObjectOutputStream oos = null;
        try
        {
            // Create an ObjectOutputStream to write into the binary file
            oos = new ObjectOutputStream(new FileOutputStream(fileName));

            // If this point is reached, then the stream was created successfully.
            // Place a string at the beginning of the file indicating the course number, then
            // ask the user to enter the registration information

            oos.writeUTF("This file includes the registration of " + courseName + ".");

            System.out.print("Please enter the student ID you wish to register in " +
                    "the course or -1 to terminate: ");
            id = kb.nextLong();
            while(id != -1)
            {

                jk = kb.nextLine();		// Clear the rest of the line
                System.out.print("Please enter first name and last name of the student: ");
                firstName = kb.next();
                lastName = kb.next();

                oos.writeLong(id);
                oos.writeChar('\t');	// Add two tabs
                oos.writeChar('\t');
                oos.writeUTF(firstName);
                oos.writeChar(' ');		// Add one space to separate the names
                oos.writeUTF(lastName);

                System.out.println("One student info was added to the file.");
                System.out.print("\nPlease enter the following student ID you wish " +
                        "to register in the course, or -1 to terminate: ");
                id = kb.nextLong();
            }

            System.out.println("Registration completed.");
            oos.close();		// Close the file
        }
        catch(IOException e)
        {
            System.out.println("Problem writing to output file " + fileName);
            System.out.println("Program will terminate.");
            System.exit(0);
        }
    }
}
