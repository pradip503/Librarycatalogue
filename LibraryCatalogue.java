
package LibraryCatalogue;

import java.util.HashMap;
import java.util.Map;

public class LibraryCatalogue {
    
    //Properties, Fields, Global variables
    Map<String, Book> bookCollection = new HashMap<String, Book>();
    int currentDay = 0;
    int lengthOfCheckoutPeriod = 7;
    double initiallateFee = 0.50;
    double lateFeePerDay = 1.0;
    
    
    //constructor with one argument
    public LibraryCatalogue(Map<String, Book> collection) {
        this.bookCollection = collection;
    }
    
    //constructor with multiple arguments
    public LibraryCatalogue(Map<String, Book> collection, int lengthOfCheckoutPeriod, double initialLateFee, double lateFeePerDay) {
        this.bookCollection = collection;
        this.lengthOfCheckoutPeriod = lengthOfCheckoutPeriod;
        this.initiallateFee = initialLateFee;
        this.lateFeePerDay = lateFeePerDay;
    }
    
    //getters
    
    public int getCurrentDay(){
        return this.currentDay;
    }
    
    public Map<String, Book> getBookCollection(){
        return this.bookCollection;
    }
    
    public Book getBook(String bookTitle){
        return getBookCollection().get(bookTitle);
    }
    
    public int getLengthOfCheckoutPeriod(){
        return this.lengthOfCheckoutPeriod;
    }
    
    public double getInitialLateFee(){
        return this.initiallateFee;
    }
    
    public double getLateFeePerDay(){
        return this.lateFeePerDay;
    }
    
    //setters
    
    public void nextDay(){
        currentDay++;
    }
    
    public void setDay(int day){
        this.currentDay = day;
    }
    
    //instance methods
    
    public void checkOutBook(String title){
        Book book = getBook(title);
        if(book.getIsCheckedOut()){
            sorryBookIsAlreadyCheckedOut(book);
        } else {
            book.setIsCheckedOut(true, currentDay);
            System.out.println("You have checked out the book " + book.getTitle() + ". Your due date of returning is day " + 
               (getCurrentDay()+getLengthOfCheckoutPeriod()) + ".");
        }
    }
    
    public void returnBook(String title){
        Book book = getBook(title);
        int lateDays = getCurrentDay()-(book.getDayCheckedOut() + getLengthOfCheckoutPeriod());
        if(lateDays > 0){
            System.out.println("You are " + lateDays + " days late. You have to pay Rs."
            + (getInitialLateFee() + lateDays*getLateFeePerDay())+ ".");
        } else {
            System.out.println("Thank you for returning  book on time!");
        }
        
        book.setIsCheckedOut(false, -1);
    }
    
    public void sorryBookIsAlreadyCheckedOut(Book book){
        
        System.out.println("Sorry, the book" + book.getTitle() + " is already checkedout! You can again check is book at day"
                + (book.getDayCheckedOut() + getLengthOfCheckoutPeriod()) + "." );
    }
    
    
    
    //Main method
    
    public static void main(String[] args) {
        
        Map<String, Book> bookCollection = new HashMap<String, Book>();
        Book summerLove = new Book("Summer Love", 1024, 356845);
        bookCollection.put("Summer Love", summerLove);
        LibraryCatalogue lib = new LibraryCatalogue(bookCollection);
        lib.checkOutBook("Summer Love");
        lib.nextDay();
        lib.nextDay();
        lib.checkOutBook("Summer Love");
        lib.setDay(20);
        lib.returnBook("Summer Love");
        lib.checkOutBook("Summer Love");
    }
    
}
