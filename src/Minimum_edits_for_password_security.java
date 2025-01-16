import java.util.Scanner;
import java.util.*;
public class Minimum_edits_for_password_security {
    public static void main(String [] args){
        System.out.print("Enter the number of passwords in int: ");
        Scanner sc = new Scanner(System.in);
        int no_of_password = sc.nextInt();
        System.out.println("All the passwords must be 10 characters long");

        String [][] strings = new String[1][no_of_password];
        strings[0][0] = sc.next();
        strings[0][1] = sc.next();
        strings[0][2] = sc.next();
        strings[0][3] = sc.next();
        strings[0][4] = sc.next();


        System.out.println(Arrays.toString(strings[0]));
    }
}

//pass123
//Abcdefghij
//1234567890
//abc$5678
//P@ssw0rd1
