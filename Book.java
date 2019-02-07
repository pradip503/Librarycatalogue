
package LibraryCatalogue;

public class Book {
    
    
    //properties
    String title;
    int pageCount;
    int ISBN;
    boolean isCheckedOut; //whether or not book is checked out
    int dayCheckedOut = -1;
    
    //constructor
    public Book(String title, int pageCount, int bookISBN){
        this.title = title;
        this.pageCount = pageCount;
        this.ISBN = bookISBN;
        isCheckedOut = false;
    }
    
    //getters
    
    public String getTitle(){
        return this.title;
    }
    
    public int getPageCount(){
        return this.pageCount;
    }
    
    public int getISBN(){
        return this.ISBN;
    }
        
    public boolean getIsCheckedOut(){
        return this.isCheckedOut;
    }
    
    public int getDayCheckedOut(){
        return this.dayCheckedOut;
    }
    
    //setters
    public void setIsCheckedOut(boolean newIsCheckedOut, int currentDayCheckedOut){
        this.isCheckedOut = newIsCheckedOut;
        setDayCheckedOut(currentDayCheckedOut);
    }
    
    private void setDayCheckedOut(int day){
        this.dayCheckedOut = day;
    }
    
}
