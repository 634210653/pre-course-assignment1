import java.util.HashMap;

/**
 * @Author: LP
 * @Date: 2019/7/28
 */


public class Biblioteca {

    private HashMap<Book,Boolean> books;

    public Biblioteca(HashMap<Book,Boolean>books){
        this.books = books;
    }

    public String welcome(){

        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public Boolean isBookAvailable(Book book){
        if(book == null||!books.containsKey(book))
            return false;
        return books.get(book);
    }
}
