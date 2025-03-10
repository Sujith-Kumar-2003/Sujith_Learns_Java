package PPS_related_codes.Assignments;

// -----------------------------------------------------
// Assignment 2
// Written by: Sujith Kumar Kumaravel (40281567)
// -----------------------------------------------------

//SUJITH KUMAR KUMARVEL 40281567
// COMP6481 Assignment # Due Date

//Assignment-2
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class processes book records from input files and performs various operations.
 */
public class BookRecordProcessor {
    private static final String INPUT_FILE_NAMES = "/Users/sujithkumaravel/Downloads/Sujith_Learns_Java/src/PPS_related_codes/Assignments/part1_input_file_names.txt";
    private static final String[] GENRES = {"CCB", "HCB", "MTV", "MRB", "NEB", "OTR", "SSM", "TPA"};
    private static final String[] GENRE_FILE_NAMES = {"Cartoons_Comics.csv.txt", "Hobbies_Collectibles.csv.txt",
            "Movies_TV_Books.csv.txt", "Music_Radio_Books.csv.txt", "Nostalgia_Eclectic_Books.csv.txt",
            "Old_Time_Radio_Books.csv.txt", "Sports_Sports_Memorabilia.csv.txt", "Trains_Planes_Automobiles.csv.txt"};
    private static final String[] BINARY_FILE_NAMES = {"Cartoons_Comics.csv.ser", "Hobbies_Collectibles.csv.ser",
            "Movies_TV_Books.csv.ser", "Music_Radio_Books.csv.ser", "Nostalgia_Eclectic_Books.csv.ser",
            "Old_Time_Radio_Books.csv.ser", "Sports_Sports_Memorabilia.csv.ser", "Trains_Planes_Automobiles.csv.ser"};

    private static Book[] currentArray;
    private static int currentIndex = 0;

    public static void main(String[] args) {
        do_part1();
        do_part2();
        do_part3();
    }
    /**
     * Processes the input files specified in the configuration file.
     * Missing files are reported as warnings.
     */
    public static void do_part1() {
        String[] missingFiles = new String[16];
        int missingFileCount = 0;

        try {
            BufferedReader inputFilesReader = new BufferedReader(new FileReader(INPUT_FILE_NAMES));
            int numFiles = Integer.parseInt(inputFilesReader.readLine().trim());

            for (int i = 0; i < numFiles; i++) {
                String fileName = inputFilesReader.readLine().trim();
                if (!new java.io.File(fileName).exists()) {
                    missingFiles[missingFileCount++] = fileName;
                    System.out.println("WARNING: " + fileName + " is not found!");
                    continue;
                }
                processFile(fileName);
            }

            inputFilesReader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Processes each record in the input file and writes it to the corresponding genre file.
     * Syntax errors are recorded in a separate file.
     * @param fileName The name of the input file to process.
     */
    private static void processFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                try {
                    processRecord(line);
                } catch (MissingFieldException | TooFewFieldsException | TooManyFieldsException | UnknownGenreException e) {
                    recordSyntaxError(fileName, e.getMessage(), line);
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Processes a single book record and writes it to the corresponding genre file.
     * @param record The book record to process.
     * @throws MissingFieldException If any required field is missing in the record.
     * @throws TooManyFieldsException If there are too many fields in the record.
     * @throws TooFewFieldsException If there are too few fields in the record.
     * @throws UnknownGenreException If the genre of the book is unknown.
     */
    private static void processRecord(String record) throws MissingFieldException,TooManyFieldsException,TooFewFieldsException,UnknownGenreException {
        String[] fields = record.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        if (record.endsWith(",")) {
            throw new MissingFieldException("MissingFieldException", "Missing year", record);
        }
        if (fields.length < 6) {
            throw new TooFewFieldsException("TooFewFieldsException", "Too few fields", record);
        }
        if (fields.length > 6) {
            throw new TooManyFieldsException("TooManyFieldsException", "Too many fields", record);
        }
        String title = fields[0].trim();
        String authors = fields[1].trim();
        String priceStr = fields[2].trim();
        String isbn = fields[3].trim();
        String genre = fields[4].trim();
        String yearStr = fields[5].trim();

        if (title.isEmpty()) {
            throw new MissingFieldException("MissingFieldException", "Missing title", record);
        }
        if (authors.isEmpty()) {
            throw new MissingFieldException("MissingFieldException", "Missing authors", record);
        }
        if (priceStr.isEmpty()) {
            throw new MissingFieldException("MissingFieldException", "Missing price", record);
        }
        if (isbn.isEmpty()) {
            throw new MissingFieldException("MissingFieldException", "Missing isbn", record);
        }
        if (genre.isEmpty()) {
            throw new MissingFieldException("MissingFieldException", "Missing genre", record);
        }
        if (yearStr.isEmpty()) {
            throw new MissingFieldException("MissingFieldException", "Missing year", record);
        }
        if (!Arrays.asList(GENRES).contains(genre)) {
            throw new UnknownGenreException("UnknownGenreException", "Unknown genre", record);
        }


        writeRecordToFile(record, genre);
    }
    /**
     * Writes a book record to the corresponding genre file.
     * @param record The book record to write.
     * @param genre The genre of the book.
     */
    private static void writeRecordToFile(String record, String genre) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(getGenreFileName(genre), true));
            writer.write(record);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Records a syntax error encountered while processing a file.
     * @param fileName The name of the file where the error occurred.
     * @param error The syntax error message.
     * @param record The record causing the error.
     */
    private static void recordSyntaxError(String fileName, String error, String record) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("syntax_error_file.txt", true));
            writer.write("syntax error in file: " + fileName);
            writer.newLine();
            writer.write("====================");
            writer.newLine();
            writer.write("Error: " + error);
            writer.newLine();
            writer.write("Record: " + record);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Returns the file name corresponding to the given genre.
     * @param genre The genre of the book.
     * @return The file name corresponding to the genre.
     */
    private static String getGenreFileName(String genre) {
        for (int i = 0; i < GENRES.length; i++) {
            if (GENRES[i].equals(genre)) {
                return GENRE_FILE_NAMES[i];
            }
        }
        return null;
    }
    /**
     * The exception that is thrown when there are too many fields in a record.
     */
    public static class TooManyFieldsException extends Exception {
        public TooManyFieldsException(String type, String message, String record) {
            super(type + ": " + message + "\nRecord: " + record);
        }
    }
    /**
     * The exception that is thrown when there are too few fields in a record.
     */
    public static class TooFewFieldsException extends Exception {
        public TooFewFieldsException(String type, String message, String record) {
            super(type + ": " + message + "\nRecord: " + record);
        }
    }
    /**
     * The exception that is thrown when a required field is missing in a record.
     */
    public static class MissingFieldException extends Exception {
        public MissingFieldException(String type, String message, String record) {
            super(type + ": " + message + "\nRecord: " + record);
        }
    }
    /**
     * The exception that is thrown when the genre of a record is unknown.
     */
    public static class UnknownGenreException extends Exception {
        public UnknownGenreException(String type, String message, String record) {
            super(type + ": " + message + "\nRecord: " + record);
        }
    }
    /**
     * Processes all genre files and converts them into binary format.
     */
    public static void do_part2() {
        for (int i = 0; i < GENRE_FILE_NAMES.length; i++) {
            String genreFileName = GENRE_FILE_NAMES[i];
            String binaryFileName = BINARY_FILE_NAMES[i];
            processGenreFile(genreFileName, binaryFileName);
        }
    }
    /**
     * Processes a single genre file and converts it into binary format.
     * @param genreFileName The name of the genre file.
     * @param binaryFileName The name of the binary file to write to.
     */
    private static void processGenreFile(String genreFileName, String binaryFileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(genreFileName));
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(binaryFileName));

            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    Book book = processBookRecord(line);
                    out.writeObject(book);
                } catch (MissingFieldException | BadIsbn10Exception | BadIsbn13Exception | BadPriceException | BadYearException e) {
                    recordSemanticError(e.getMessage(), line);
                }
            }

            out.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Processes a single book record and converts it into a Book object.
     * @param record The book record to process.
     * @return The Book object created from the record.
     * @throws MissingFieldException If any required field is missing in the record.
     * @throws BadIsbn10Exception If the ISBN-10 is invalid.
     * @throws BadIsbn13Exception If the ISBN-13 is invalid.
     * @throws BadPriceException If the price is invalid.
     * @throws BadYearException If the year is invalid.
     */
    private static Book processBookRecord(String record) throws MissingFieldException,BadIsbn10Exception,BadIsbn13Exception,BadPriceException,BadYearException {
        String[] fields = record.split(",");
        if (fields.length != 6) {
            throw new MissingFieldException("Missing field", "Expected 6 fields", record);
        }

        String title = fields[0];
        String authors = fields[1];
        double price;
        price = Double.parseDouble(fields[2]);
        String isbn = fields[3];
        String genre = fields[4];
        int year;
        year = Integer.parseInt(fields[5]);

        if (isbn.length() == 10) {
            if (!isValidIsbn10(isbn))
                throw new BadIsbn10Exception("Invalid ISBN-10", "Invalid ISBN-10 format", record);
        }

        if (isbn.length() == 13) {
            if (!isValidIsbn13(isbn))
                throw new BadIsbn13Exception("Invalid ISBN-13", "Invalid ISBN-13 format", record);
        }

        if (!isValidPrice(price)) {
            throw new BadPriceException("Invalid price", "Price must be non-negative", record);
        }

        if (!isValidYear(year)) {
            throw new BadYearException("Invalid year", "Year must be between 1995 and 2024", record);
        }

        return new Book(title, authors, price, isbn, genre, year);
    }
    /**
     * Checks if the provided ISBN-10 is valid.
     * @param isbn The ISBN-10 to validate.
     * @return {@code true} if the ISBN-10 is valid, {@code false} otherwise.
     */
    private static boolean isValidIsbn10(String isbn) {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (10 - i) * Character.getNumericValue(isbn.charAt(i));
        }
        //sum += (isbn.charAt(9) == 'X') ? 10 : Character.getNumericValue(isbn.charAt(9));
        //sum += Character.getNumericValue(isbn.charAt(9));
        return sum % 11 == 0;
    }
    /**
     * Checks if the provided ISBN-13 is valid.
     * @param isbn The ISBN-13 to validate.
     * @return {@code true} if the ISBN-13 is valid, {@code false} otherwise.
     */
    private static boolean isValidIsbn13(String isbn) {
        int sum = 0;
        for (int i = 0; i < 13; i++) {
            sum += (i % 2 == 0) ? Character.getNumericValue(isbn.charAt(i)) : 3 * Character.getNumericValue(isbn.charAt(i));
        }
        return sum % 10 == 0;
    }
    /**
     * Checks if the provided price is valid.
     * @param price The price to validate.
     * @return {@code true} if the price is valid (non-negative), {@code false} otherwise.
     */
    private static boolean isValidPrice(double price) {
        return price >= 0;
    }
    /**
     * Checks if the provided year is within the valid range.
     * @param year The year to validate.
     * @return {@code true} if the year is within the range 1995 to 2024, {@code false} otherwise.
     */
    private static boolean isValidYear(int year) {
        return year >= 1995 && year <= 2024;
    }
    /**
     * Records a semantic error encountered while processing a book record.
     * @param error The semantic error message.
     * @param record The record causing the error.
     */
    private static void recordSemanticError(String error, String record) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("semantic_error_file.txt", true));
            writer.write("Semantic error: " + error + "\n");
            writer.write("Record: " + record + "\n\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Exception thrown when an invalid ISBN-10 is encountered.
     */
    public static class BadIsbn10Exception extends Exception {
        public BadIsbn10Exception(String type, String message, String record) {
            super(type + ": " + message + "\nRecord: " + record);
        }
    }
    /**
     * Exception thrown when an invalid ISBN-13 is encountered.
     */
    public static class BadIsbn13Exception extends Exception {
        public BadIsbn13Exception(String type, String message, String record) {
            super(type + ": " + message + "\nRecord: " + record);
        }
    }
    /**
     * Exception thrown when an invalid price is encountered.
     */
    public static class BadPriceException extends Exception {
        public BadPriceException(String type, String message, String record) {
            super(type + ": " + message + "\nRecord: " + record);
        }
    }
    /**
     * Exception thrown when an invalid year is encountered.
     */
    public static class BadYearException extends Exception {
        public BadYearException(String type, String message, String record) {
            super(type + ": " + message + "\nRecord: " + record);
        }
    }

    static int choice = 1;
    public static void do_part3() {
        currentArray = new Book[0];
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n");
            System.out.println("-----------------------------");
            System.out.println("Main Menu");
            System.out.println("-----------------------------");
            System.out.println("v View the selected file: " + BINARY_FILE_NAMES[choice - 1]);
            System.out.println("s Select a file to view");
            System.out.println("x Exit");
            System.out.print("Enter Your Choice: ");
            String choice = scanner.nextLine();
            switch (choice.toLowerCase()) {
                case "v":
                    viewCurrentArray();
                    break;
                case "s":
                    selectFile(scanner);
                    break;
                case "x":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    /**
     * Allows the user to view records in the current array.
     * Prompts the user to enter a number (n) to view the next n records, or 0 to exit.
     * Continues looping until the user chooses to exit.
     * Uses the displayRecords() method to display the records.
     */
    private static void viewCurrentArray() {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        while (true) {
            System.out.println();
            System.out.println("-----------------------------");
            System.out.println("Viewing: " + BINARY_FILE_NAMES[choice - 1]);
            System.out.println("-----------------------------");
            System.out.println("Enter a number (n) to view the next n records, or 0 to exit:");
            System.out.print("Enter Your Choice: ");
            try {
                n = Integer.parseInt(scanner.nextLine());
                if (n == 0) {
                    System.out.println("Exiting viewing...");
                    return;
                }
                displayRecords(n);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
    /**
     * Displays records from the current array based on the specified number (n).
     * If n is positive, displays the next n records from the current index.
     * If n is negative, displays the previous n records from the current index.
     * Handles cases where the start or end of the array is reached.
     * Updates the currentIndex accordingly.
     *
     * @param n The number of records to display.
     */
    private static void displayRecords(int n) {
        int start = Math.max(0, currentIndex - Math.abs(n) + 1);
        int end = Math.min(currentArray.length - 1, currentIndex + Math.abs(n) - 1);

        if (n > 0) {
            for (int i = currentIndex; i <= end; i++) {
                System.out.println(currentArray[i]);
                currentIndex = i;
            }
            if (end == currentArray.length - 1) {
                System.out.println("EOF has been reached.");
            }
        } else {
            for (int i = currentIndex; i >= start; i--) {
                System.out.println(currentArray[i]);
                currentIndex = i;
            }
            if (start == 0) {
                System.out.println("BOF has been reached.");
            }
        }
    }

    /**
     * Displays a submenu for selecting a binary file.
     * Lists all available binary files along with the number of records they contain.
     * Prompts the user to enter their choice, allowing them to select a file or exit.
     * Validates user input to ensure a valid choice is made.
     * Updates the currentIndex and currentArray based on the selected file.
     *
     * @param scanner The Scanner object used to receive user input.
     */
    private static void selectFile(Scanner scanner) {
        while (true) {
            System.out.println("-----------------------------");
            System.out.println("File Sub-Menu");
            System.out.println("-----------------------------");
            for (int i = 0; i < BINARY_FILE_NAMES.length; i++) {
                File file = new File(".", BINARY_FILE_NAMES[i]);
                System.out.println((i + 1) + " " + BINARY_FILE_NAMES[i] + " (" + countObjectsInFile(file) + " records)");
            }
            System.out.println(BINARY_FILE_NAMES.length + 1 + " Exit");
            System.out.print("Enter Your Choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > BINARY_FILE_NAMES.length + 1) {
                    System.out.println("Invalid choice. Please try again.");
                    continue;
                }
                if (choice == BINARY_FILE_NAMES.length + 1) {
                    System.out.println("Exiting file selection...");
                    return;
                }
                currentIndex = 0;
                currentArray = deserializeArrayFromFile(BINARY_FILE_NAMES[choice - 1]);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
    /**
     * Counts the number of objects (records) stored in a binary file.
     * Opens an ObjectInputStream to read objects from the file.
     * Counts objects until the end of the file is reached.
     * Catches IOException and ClassNotFoundException if they occur during file reading.
     *
     * @param file The File object representing the binary file.
     * @return The number of objects (records) found in the file.
     */
    private static int countObjectsInFile(File file) {
        int objectCount = 0;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    objectInputStream.readObject();
                    objectCount++;
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return objectCount;
    }
    /**
     * Deserializes an array of Book objects from a binary file.
     * Reads objects from the specified file using ObjectInputStream.
     * Creates a new array of Book objects and populates it with the deserialized objects.
     * Handles IOException and ClassNotFoundException if they occur during file reading.
     *
     * @param fileName The name of the binary file from which to deserialize the array.
     * @return An array of Book objects deserialized from the file, or an empty array if an error occurs.
     */
    private static Book[] deserializeArrayFromFile(String fileName) {
        Book[] books = new Book[0];
        int objectCount = countObjectsInFile(fileName);

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            books = new Book[objectCount];

            for (int i = 0; i < objectCount; i++) {
                Object obj = in.readObject();
                if (obj instanceof Book) {
                    books[i] = (Book) obj;
                } else {
                    System.out.println("Error: Unexpected object type in file " + fileName);
                    return new Book[0];
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return books;
    }
    /**
     * Counts the number of objects (records) stored in a binary file.
     * Opens an ObjectInputStream to read objects from the file.
     * Counts objects until the end of the file is reached.
     * Catches IOException and ClassNotFoundException if they occur during file reading.
     *
     * @param fileName The name of the binary file to count objects in.
     * @return The number of objects (records) found in the file.
     */
    private static int countObjectsInFile(String fileName) {
        int objectCount = 0;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                try {
                    in.readObject();
                    objectCount++;
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return objectCount;
    }
    /**
     * The Book class represents a book object with various attributes such as title, authors, price, ISBN, genre, and year.
     * It implements the Serializable interface to support serialization and deserialization.
     */
    static class Book implements Serializable {
        private String title;    // The title of the book
        private String authors;  // The authors of the book
        private double price;    // The price of the book
        private String isbn;     // The ISBN (International Standard Book Number) of the book
        private String genre;    // The genre of the book
        private int year;        // The publication year of the book
        /**
         * Constructs a Book object with the specified attributes.
         *
         * @param title   The title of the book.
         * @param authors The authors of the book.
         * @param price   The price of the book.
         * @param isbn    The ISBN of the book.
         * @param genre   The genre of the book.
         * @param year    The publication year of the book.
         */
        public Book(String title, String authors, double price, String isbn, String genre, int year) {
            this.title = title;
            this.authors = authors;
            this.price = price;
            this.isbn = isbn;
            this.genre = genre;
            this.year = year;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthors() {
            return authors;
        }

        public void setAuthors(String authors) {
            this.authors = authors;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getIsbn() {
            return isbn;
        }
        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        /**
         * Returns a string representation of the Book object.
         *
         * @return A string representation of the Book object.
         */
        @Override
        public String toString() {
            return "Book{" +
                    "title='" + title + '\'' +
                    ", authors='" + authors + '\'' +
                    ", price=" + price +
                    ", isbn='" + isbn + '\'' +
                    ", genre='" + genre + '\'' +
                    ", year=" + year +
                    '}';
        }
        /**
         * Checks whether this Book object is equal to another object.
         *
         * @param obj The object to compare with this Book object.
         * @return true if the objects are equal, false otherwise.
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Book book = (Book) obj;
            return price == book.price &&
                    year == book.year &&
                    title.equals(book.title) &&
                    authors.equals(book.authors) &&
                    isbn.equals(book.isbn) &&
                    genre.equals(book.genre);
        }
    }
}
