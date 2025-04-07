package PPS_related_codes.Assignments.Assignment2_Files;

//SUJITH KUMAR KUMARAVEL 40281567
// COMP6481 Assignment 2
//Assignment-2
import java.io.Serializable;

// Book class
class Book implements Serializable {
    private String record;
    private String title; // Added title field
    private String authors;
    private double price;
    private String isbn;
    private String genre;
    private int year;

    public Book(String record, String title, String authors, double price, String isbn, String genre, int year) {
        this.record = record;
        this.title = title;
        this.authors = authors;
        this.price = price;
        this.isbn = isbn;
        this.genre = genre;
        this.year = year;
    }

    // Getter and setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getters and setters
    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
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

    // Override toString() method
    @Override
    public String toString() {
        return "Book{" +
                "Record='" + record + '\'' +
                ", title='" + title + '\'' +
                ", authors='" + authors + '\'' +
                ", price=" + price +
                ", isbn='" + isbn + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                '}';
    }
}

