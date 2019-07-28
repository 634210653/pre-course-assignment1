import java.util.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * @Author: LP
 * @Date: 2019/7/28
 */



public class BibliotecaTest {

    private Biblioteca lib;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book other;

    @Before
    public void InitLib(){

        HashMap<Book,Boolean> books = new HashMap<>();
        book1 = new Book("book1","author1",1992);
        book2 = new Book("book2","author2",1993);
        book3 = new Book("book3","author2",1994);
        other = new Book("book4","author2",1994);
        books.put(book1,true);
        books.put(book2,false);
        books.put(book3, true);
        lib = spy(new Biblioteca(books));
    }

    @Test
    public void  shouldHaveWelcomeMessage(){

        String expected = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        String actual = new App().welcome();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void  shouldRecordBooks(){

        Assert.assertTrue(lib.isBookAvailable(new Book("book1","author1",1992)));
        Assert.assertFalse(lib.isBookAvailable(book2));
        Assert.assertFalse(lib.isBookAvailable(new Book("book1","author1",1993)));

    }

    @Test
    public void shouldHaveMainMenuWhenInvalidOptionSayInivaMessage(){

        App app = new App();
        Assert.assertTrue(app.checkOption(1));
        Assert.assertTrue(app.checkOption(2));
        Assert.assertTrue(app.checkOption(3));
        Assert.assertTrue(app.checkOption(4));
        Assert.assertFalse(app.checkOption(5));
        Assert.assertEquals("Please select a valid option!",app.invalidMessage());

    }

    @Test
    public void shouldListBooksHaveAuthorAndYear(){

        List<String> availableBooks = lib.getBooksInformation();
        Assert.assertEquals(2,availableBooks.size());

        for (String bookInfo: availableBooks) {
            Assert.assertEquals(3,bookInfo.split("\\|").length);
        }
    }

    @Test
    public void shouldCheckoutBooksHaveSuccessAndFailureMessage(){

        when(lib.isBookAvailable(book1)).thenReturn(true);
        when(lib.isBookAvailable(book2)).thenReturn(false);
        when(lib.isBookAvailable(book3)).thenReturn(true);
        //check
        Assert.assertEquals("Thank you! Enjoy the book.",lib.checkout(book1));
        Assert.assertEquals("Sorry, that book is not available.",lib.checkout(book2));
        Assert.assertEquals("Thank you! Enjoy the book.",lib.checkout(book3));

    }

    @Test
    public void shouldReturnBooksHaveSuccessAndFailureMesseage(){

        Assert.assertTrue(lib.isLibraryBook(book1));
        Assert.assertTrue(lib.isLibraryBook(book2));
        Assert.assertTrue(lib.isLibraryBook(book3));
        Assert.assertFalse(lib.isLibraryBook(other));

        Assert.assertEquals("Thank you for returning the book.",lib.returnBook(book2));
        Assert.assertTrue(lib.isBookAvailable(book2));
        Assert.assertEquals("That is not a valid book to return.",lib.returnBook(other));

        Assert.assertEquals(book1,new Book("book1","author1",1993));
    }

}
