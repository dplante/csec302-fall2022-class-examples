package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Book;

public class BookTestCases {

    private Book book;
    @BeforeEach
    void setup() {
        book = new Book("Java 101", 100);
    }

    @Test
    void openClosedBook() {
        assertEquals(false, book.isOpen());
    }

    @Test
    void openBookGetter() {
        book.open();
        assertEquals(true, book.isOpen()); 
    }

    @Test
    void openBookMethod() {
        assertEquals(true, book.open()); 
    }

    @Test
    void flipPageClosed() {
        assertEquals(Book.NO_VALUE, book.flipPage());
    }

    @Test
    void flipPageOpened() {
        book.open();
        assertEquals(2, book.flipPage());
    }

    @Test
    void flipPageFromLastPage() {
        int last = book.getLastPage();
        assertEquals(false, book.turnToPage(last + 1));
    }

}
