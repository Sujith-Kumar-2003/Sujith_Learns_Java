package PPS_related_codes.Exception_Handling;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Second {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int k;

        while(true){
            try{
                System.out.println("Enter a number between 1 and 10");
                k = Integer.parseInt(sc.nextLine());
                if (k >=1 && k < 10){
                    System.out.println("The code is good");
                    break;
                }
            }
            catch(InputMismatchException e){
                System.out.println("The value you entered is wrong");
                k = Integer.parseInt(sc.nextLine());

            }
        }
        System.out.println("the code completed");
    }
}
