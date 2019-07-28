import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public String invalidMessage(){

        return  "Please select a valid option!";
    }

    public boolean checkOption(int option){
            return option>=1 && option<=4;
    }


    public List<String> getBooksInformation(){

        List<String> res = new ArrayList<>();
        for ( Book book: books.keySet()) {
            if(books.get(book)){
                res.add(String.format("%s|%s|%d",book.getName(),book.getAuthor(),book.getYear()));
            }
        }
       return res;
    }

    public String checkout(Book book){
        if(this.isBookAvailable(book))
            return "Thank you! Enjoy the book.";
        else
            return "Sorry, that book is not available.";
    }

    public boolean isLibraryBook(Book book){
        if(book == null||!books.containsKey(book))
            return false;
        return true;
    }

    public String returnBook(Book book){

        if(isLibraryBook(book)){
            books.put(book,true);
            return "Thank you for returning the book.";
        }else{
            return "That is not a valid book to return." ;
        }
    }
}
