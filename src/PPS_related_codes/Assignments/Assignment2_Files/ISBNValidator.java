package PPS_related_codes.Assignments.Assignment2_Files;//SUJITH KUMAR KUMARVEL 40281567
// COMP6481 Assignment # Due Date
//Assignment-2
/**
 * The ISBNValidator class provides methods to validate ISBN-10 and ISBN-13 numbers.
 */
public class ISBNValidator {

    public static boolean isValidISBN10(String isbn) {
        if (isbn == null || isbn.length() != 10) {
            return false;
        }

        try {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                if (isbn.charAt(i) == 'X' || isbn.charAt(i) == 'x') {
                    sum += 10 * (10 - i);
                } else {
                    sum += (isbn.charAt(i) - '0') * (10 - i);
                }
            }
            return sum % 11 == 0;
        } catch (NumberFormatException e) {
            return false;  //NumberFormatException = catches the error for non number input.
        }
    }

    public static boolean isValidISBN13(String isbn) {
        if (isbn == null || isbn.length() != 13) {
            return false;
        }

        try {
            int sum = 0;
            for (int i = 0; i < 13; i++) {
                int digit = isbn.charAt(i) - '0';
                sum += (i % 2 == 0) ? digit : digit * 3;
            }
            return sum % 10 == 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String isbn10 = "1593930348"; // Example valid ISBN-10
        String isbn13 = "9780470059029"; // Example valid ISBN-13

        System.out.println("ISBN-10 " + isbn10 + " is valid: " + isValidISBN10(isbn10));
        System.out.println("ISBN-13 " + isbn13 + " is valid: " + isValidISBN13(isbn13));
    }
}
