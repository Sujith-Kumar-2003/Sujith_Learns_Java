import java.util.Scanner;

public class Minimum_edits_for_password_security {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no_of_password = sc.nextInt();

        String[] passwords = new String[no_of_password];
        for (int i = 0; i < no_of_password; i++) {
            passwords[i] = sc.next();
        }

        int[] editArray = new int[no_of_password];

        for (int i = 0; i < no_of_password; i++) {
            String password = passwords[i];
            int editsRequired = 0;

            // Condition 1: Check if the password length is exactly 10
            if (password.length() != 10) {
                editsRequired += Math.abs(password.length() - 10);

            }

            // Condition 2: Check for at least one uppercase letter
            if (!password.matches(".*[A-Z].*")) {
                editsRequired++;
            }

            // Condition 3: Check for at least one lowercase letter
            if (!password.matches(".*[a-z].*")) {
                editsRequired++;
            }

            // Condition 4: Check for at least one digit
            if (!password.matches(".*[0-9].*")) {
                editsRequired++;
            }

            // Condition 5: Check for at least one special character (@, #, $, %, &, *)
            if (!password.matches(".*[@#$%&*].*")) {
                editsRequired++;
            }

            editArray[i] = editsRequired;
        }
        int minimum = 10;
        String name = "";
        for ( int i = 0 ; i < no_of_password; i ++){
            if (editArray[i] < minimum){
                minimum = editArray[i];
                name = passwords[i];
            }
        }
        System.out.println(name);
        System.out.println(minimum);


        sc.close();
    }
}
