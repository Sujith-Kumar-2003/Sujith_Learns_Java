package PPS_related_codes.FileHandling;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;



public class seventh{

    public static void main(String[] args)
    {

        String s;
        Scanner kb = new Scanner(System.in);
        Scanner sc = null;
        long id1, id2, id3;

        try
        {
            sc = new Scanner(new FileInputStream("/Users/sujithkumaravel/Downloads/Sujith_Learns_Java/src/PPS_related_codes/FileHandling/seventh.txt"));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Could not open input file for reading."
                    + " Please check if file exists.");
            System.out.print("Program will terminate.");
            System.exit(0);
        }
        // The format of the file is assumed to be known.
        // The file starts with a line indicating the course name, followed by
        // the list of students in the course (as ID# then First and Last Name)

        System.out.println("Will read the input file and display the first line, " +
                "followed by the first 3 IDs. ");
        System.out.println("\nThe first line of the file has the following text:");
        s = sc.nextLine();		// read the entire first line from the file then display it
        System.out.println(s);

        id1 = sc.nextLong();
        s = sc.nextLine();		// just read the rest of the line so we can go to the next line;
        // you can just indicate sc.nextLine(); since there is no need to
        // store the contents


        id2 = sc.nextLong();
        s = sc.nextLine();		// just read the rest of the line so we can go to the next line

        id3 = sc.nextLong();

        System.out.println("\nHere are the first 3 IDs in that course: ");
        System.out.println(id1);
        System.out.println(id2);
        System.out.println(id3);

    }
}
