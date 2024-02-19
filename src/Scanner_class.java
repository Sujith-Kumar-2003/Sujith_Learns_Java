import java.util.Scanner;

public class Scanner_class {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String my_name;
        System.out.println("This uses a scanner class");
        System.out.println("Enter your name: ");
        my_name = sc.next();
        System.out.println("My name is " + my_name);
    }
}


