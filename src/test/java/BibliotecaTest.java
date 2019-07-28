import java.util.*;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Author: LP
 * @Date: 2019/7/28
 */



public class BibliotecaTest {

    @Test
    public void  shouldHaveWelcomeMessage(){

        HashMap<Book,Boolean> books = new HashMap<>();
        books.put(new Book("book1","author1",1992),true);
        Biblioteca lib = new Biblioteca(books);
        String expected = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        String actual = lib.welcome();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void  shouldRecordBooks(){

        HashMap<Book,Boolean> books = new HashMap<>();
        Book book1 = new Book("book1","author1",1992);
        Book book2 = new Book("book2","author2",1993);
        books.put(book1,true);
        books.put(book2,false);
        Biblioteca lib = new Biblioteca(books);
        Assert.assertTrue(lib.isBookAvailable(book1));
        Assert.assertFalse(lib.isBookAvailable(book2));
        Assert.assertFalse(lib.isBookAvailable(new Book("book1","author1",1993)));

    }

    public void shouldHaveMainMenuWhenInivaOptionSayInivaMessage(){

    }

    public void shouldListBooksHaveAuthorAndYear(){

    }

    public void shouldCheckoutBooksHaveSuccessAndFailureMessage(){

    }

    public void shouldReturnBooksHaveSuccessAndFailureMesseage(){

    }

}
