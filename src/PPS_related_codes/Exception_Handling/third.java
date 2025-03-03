package PPS_related_codes.Exception_Handling;
import java.util.Scanner;
import java.util.Random;


public class third {
    public static void main(String [] args) throws AgeLessThanZeroException {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        validateAge(age);

    }

    public static void validateAge(int age) throws AgeLessThanZeroException {
        if (age < 0){
            throw new  AgeLessThanZeroException();
        }
    }
}
