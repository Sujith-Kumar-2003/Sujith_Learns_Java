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

            boolean hasUppercase = password.matches(".*[A-Z].*");
            boolean hasLowercase = password.matches(".*[a-z].*");
            boolean hasDigit = password.matches(".*[0-9].*");
            boolean hasSpecial = password.matches(".*[@#$%&*].*");

            int missingTypes = 0;
            if (!hasUppercase) missingTypes++;
            if (!hasLowercase) missingTypes++;
            if (!hasDigit) missingTypes++;
            if (!hasSpecial) missingTypes++;

            if (password.length() < 10) {
                editsRequired = Math.max(missingTypes, 10 - password.length());
            } else if (password.length() > 10) {
                editsRequired = password.length() - 10 + missingTypes;
            } else {
                editsRequired = missingTypes;
            }

            editArray[i] = editsRequired;
        }

        int minimum = Integer.MAX_VALUE;
        String bestPassword = "";
        for (int i = 0; i < no_of_password; i++) {
            if (editArray[i] < minimum) {
                minimum = editArray[i];
                bestPassword = passwords[i];
            }
        }

        System.out.println(bestPassword);
        System.out.println(minimum);

        sc.close();
    }
}

//4
//Password1
//abcd123
//$$secure$$
//S3cur3It!
