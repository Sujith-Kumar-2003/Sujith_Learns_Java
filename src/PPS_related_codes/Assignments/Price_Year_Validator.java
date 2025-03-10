package PPS_related_codes.Assignments;//SUJITH KUMAR KUMARVEL 40281567, Jothi Basu LKV 40230416
// COMP6481 Assignment # Due Date
//Assignment-2
// Due 24 March
/**
 * The Price_Year_Validator class provides methods to validate price and year values.
 */
public class Price_Year_Validator {

    /**
     * Validates if the price is non-negative.
     *
     * @param price The price to validate.
     * @return true if the price is non-negative; false otherwise.
     */
    public static boolean isValidPrice(double price) {
        return price >= 0;
    }

    /**
     * Validates if the year is within the range [1995, 2024].
     *
     * @param year The year to validate.
     * @return true if the year is within the valid range; false otherwise.
     */
    public static boolean isValidYear(int year) { //Year 1995-2024
        return year >= 1995 && year <= 2024;
    }

    public static void main(String[] args) {
        // Test cases
        double price1 = 19.99;
        double price2 = -5.00;
        int year1 = 2000;
        int year2 = 2025;

        System.out.println("Price " + price1 + " is valid: " + isValidPrice(price1));
        System.out.println("Price " + price2 + " is valid: " + isValidPrice(price2));
        System.out.println("Year " + year1 + " is valid: " + isValidYear(year1));
        System.out.println("Year " + year2 + " is valid: " + isValidYear(year2));
    }
}
