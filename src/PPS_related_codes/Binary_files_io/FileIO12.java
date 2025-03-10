package PPS_related_codes.Binary_files_io;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileIO12 {


    public static void main(String[] args) throws IOException {

        // This program will store student registration information of some course.
        // The registration information will be entered by the user and stored in
        // binary file.

        long id;
        String fileName, courseName, firstName, lastName, jk;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the course name for which you wish to add student registration:");
        fileName  = sc.next();

        fileName = fileName + "_registeration.dat";

        ObjectOutputStream oos = null;

        oos = new ObjectOutputStream(new FileOutputStream(fileName));

        System.out.println("Please enter the student ID you wish to register in the course or -1 to terminate:");
        id = sc.nextLong();
        while(id != -1){
            System.out.println("Please enter first name and last name of the student:");
            firstName = sc.next();
            lastName = sc.next();

            oos.writeLong(id);
            oos.writeChar('\t');
            oos.writeChar('\t');
            oos.writeUTF(firstName);
            oos.writeChar(' ');
            oos.writeUTF(lastName);
            System.out.println("One student info was added to the file.");
            System.out.print("\nPlease enter the following student ID you wish " +
                    "to register in the course, or -1 to terminate: ");
            id = sc.nextLong();


        }
        System.out.println("Registration complete ");
        oos.close();


    }
}
/* The Output
Please enter the course name for which you wish to add student registration: Comp249
The registration information will be stored in a "binary" file called: Comp249_registeration.dat
Please enter the student ID you wish to register in the course or -1 to terminate: 9082320
Please enter first name and last name of the student: Mike Simon
One student info was added to the file.

Please enter the following student ID you wish to register in the course, or -1 to terminate: 7822340
Please enter first name and last name of the student: Linda Jackson
One student info was added to the file.

Please enter the following student ID you wish to register in the course, or -1 to terminate: 4532098
Please enter first name and last name of the student: Mark Rogers
One student info was added to the file.

Please enter the following student ID you wish to register in the course, or -1 to terminate: 8830916
Please enter first name and last name of the student: David Peterson
One student info was added to the file.

Please enter the following student ID you wish to register in the course, or -1 to terminate: -1
Registration completed.
*/
