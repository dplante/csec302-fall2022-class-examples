package main;

/**
 * Using Test Driven Development (TDD), we just scaffolded out 
 * the Book class to have the "design" for the class.  We then 
 * wrote the test cases to use these, adding more details here
 * as we needed them to write the test cases.
 * 
 * We could have programmed everything below completely 
 * differently, as we discussed in class, with booleans, voids,
 * or ints being returned.  Those we chose below were 
 * "design decisions" we made in class by voting!  Also,
 * note that we could have done this completely differently
 * by returning Exceptions instead, which would actually be 
 * the preferred way if we were developing a library to be
 * used by others.  So instead of returning NO_VALUE, we 
 * could throw an exception.  Again, all design decisions!
 * 
 * As an exercise, you could now try programming this up and
 * seeing how test cases begin to pass as you correctly 
 * provide the implementation for these methods and the 
 * required properties! :)
 * 
 * @author Daniel Plante
 * @version 0.1
 */
public class Book {
    public final static int NO_VALUE = -1;

    public Book(String title, int maxNumPages) {

    }

    public int flipPage() {
        return NO_VALUE;
    }

    public int bookmarkPage() {
        return NO_VALUE;
    }

    public int openToBookmark() {
        return NO_VALUE;
    }

    public boolean turnToPage(int page) {
        return false;
    }

    public boolean open() {
        return false;
    }

    public boolean close() {
        return false;
    }

    public boolean isOpen() {
        return false;
    }

    public int getLastPage() {
        return NO_VALUE;
    }
    
}
