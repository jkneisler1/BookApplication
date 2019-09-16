import java.util.Scanner;
import java.text.NumberFormat;

public class Book {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        String priceTmp;
        String inStock;

        Book book = new Book();
        System.out.println("Enter the title of the book.");
        book.title = key.nextLine();

        System.out.println("Enter the author of the book.");
        book.author = key.nextLine();

        System.out.println("Enter the price of the book.");
        priceTmp = key.nextLine();
        book.price = Double.parseDouble(priceTmp);

        System.out.println("Enter a desctiption of the book.");
        book.description = key.nextLine();

        System.out.println("Enter whether the book is in stock (\"Y\"|\"N\").");
        inStock = key.nextLine();
        if ( inStock.equalsIgnoreCase("Y")) {
            book.isInStock = true;
        }
        else if ( inStock.equalsIgnoreCase("N")) {
            book.isInStock = false;
        }
        else {
            System.out.println("Not a valid entry.  In stock status is unknown; therefore, it will be listed as no.");
            book.isInStock = false;
        }

        // Print out a book's information
        book.getDisplayText();
    }

    private String author;
    private String description;
    private double price;
    private String title;
    private boolean isInStock;

    // Default Constructors
    Book() {
        author = "NO AUTHOR";
        description = "NO DESCPTION";
        price = 0.0;
        title = "NO TITLE";
        isInStock = false;
     }

    // Overloaded Constructor
     Book(String author, String description, double price, String title, boolean isInStock ) {
        this.author = author;
        this.description = description;
        this.price = price;
        this.title = title;
        this.isInStock = isInStock;
     }

    // Method: getDisplayText
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
     * @param title
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
