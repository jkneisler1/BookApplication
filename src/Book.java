import java.util.ArrayList;
import java.util.Scanner;
import java.text.NumberFormat;

/**
 * Author: John Kneisler
 * Date: 9/16/2019
 * --------
 * First part of the program:
 * Create a book class to hold the following information
 *      Title -- String
 *      Author -- String
 *      Price -- double
 *      Description -- String
 *      isInStock -- boolean
 * Also create a method to print out the information of the book.
 * --------
 * Second part of the program:
 * Entering and printing multiple books
 * Enter 5 books.  After the fifth book is entered, the program will output the books in the
 * order that they were entered.
 */

public class Book {

    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        String title;
        String author;
        String description;
        String priceTmp;
        double price;
        String inStock;
        boolean isInStock;
        int booksToEnter = 5;
        String displayAll;

        ArrayList<Book> Books = new ArrayList<>(booksToEnter);      // used to hold multiple books (for 2nd part)

        for ( int i = 0; i < booksToEnter; i++) {

            System.out.println("Enter the title of the book.");     // Enter the title
            title = key.nextLine();

            System.out.println("Enter the author of the book.");    // Enter the author
            author = key.nextLine();

            System.out.println("Enter the price of the book.");     // Enter the price of the book
            priceTmp = key.nextLine();
            price = Double.parseDouble(priceTmp);

            System.out.println("Enter a desctiption of the book."); // Enter the description of the book
            description = key.nextLine();

            System.out.println("Enter whether the book is in stock (\"Y\"|\"N\").");    // in stock?
            inStock = key.nextLine();
            if (inStock.equalsIgnoreCase("Y")) {
                isInStock = true;
            } else if (inStock.equalsIgnoreCase("N")) {
                isInStock = false;
            } else {
                System.out.println("Not a valid entry.  In stock status is unknown; therefore, it will be listed as no.");
                isInStock = false;
            }

            Book book = new Book(author, description, price, title, isInStock);
            book.getDisplayText();          // Print out a book's information
            Books.add(book);                // Add the book to the repository
        }

        System.out.println("Do you want to display all the books?");
        displayAll = key.nextLine();
        if (displayAll.equalsIgnoreCase("Y")) {
            for (Book bk : Books) {
                bk.getDisplayText();
            }
        }
        else {
            System.out.println("Thank you for entering the books into the repository.");
        }
    }

    // used to populate a book constructor
    private String author;
    private String description;
    private double price;
    private String title;
    private boolean isInStock;


    // Default Constructors
    private Book() {
        author = "NO AUTHOR";
        description = "NO DESCPTION";
        price = 0.0;
        title = "NO TITLE";
        isInStock = false;
    }

    // Overloaded Constructor
    private Book(String author, String description, double price, String title, boolean isInStock ) {
        this.author = author;
        this.description = description;
        this.price = price;
        this.title = title;
        this.isInStock = isInStock;
    }

    // Method: getDisplayText
    // This method is used to display the information for one book
    public void getDisplayText() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        System.out.println("Book title: " + getTitle());
        System.out.println("Book author: " + getAuthor());
        System.out.println("Book description: " + getDescription());
        System.out.println(("The price is: " + formatter.format(getPrice())));
        if (isInStock()) {
            System.out.println("Currently the book is in stock.");
        }
        else {
            System.out.println("Currently the book is not in stock.");
        }
        System.out.println();
    }

    /**
     * Getter methods for the book variables
     * @return
     */
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isInStock() {
        return isInStock;
    }


    /**
     * Setter methods for the book variables
     */

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }




}
