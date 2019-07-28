import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: LP
 * @Date: 2019/7/28
 */
public class App {

    private Biblioteca lib ;
    private Scanner scanner;
    public App(){
        HashMap<Book,Boolean> books = new HashMap<>();
        Book book1 = new Book("book1","author1",1992);
        Book book2 = new Book("book2","author2",1993);
        Book book3 = new Book("book3","author2",1994);
        books.put(book1,true);
        books.put(book2,false);
        books.put(book3, true);
        lib = (new Biblioteca(books));
        scanner = new Scanner(System.in);
    }

    public String welcome(){
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public String invalidMessage(){

        return  "Please select a valid option!";
    }

    public boolean checkOption(int option){
        return option>=1 && option<=4;
    }

    public void printMenu(){
        System.out.println("please Input your option:");
        System.out.println("1.brows books");
        System.out.println("2.checkout book");
        System.out.println("3.return book");
        System.out.println("4.quit");
    }


    public Book inputBook(){
        System.out.println("input name:");
        String name = scanner.next();
        System.out.println("input author:");
        String author = scanner.next();
        System.out.println("input year:");
        int year = scanner.nextInt();
        scanner.nextLine();
        return new Book(name,author,year);
    }

    public void run(){

        System.out.println(welcome());
        scanner.nextLine();

        while(true){

            printMenu();
            int option = scanner.nextInt();
            scanner.nextLine();
            if(!checkOption(option)){
                System.out.println(invalidMessage());
                continue;
            }

            switch(option){
                case 1:
                    lib.getBooksInformation().forEach(info->System.out.println(info));
                    break;

                case 2:
                    System.out.println(lib.checkout( inputBook()));
                    break;

                case 3:
                    System.out.println(lib.returnBook(inputBook()));
                    break;

                case 4:
                    System.exit(0);
            }

            System.out.println("press enter to return main menu");
            scanner.nextLine();
        }

    }

    public static void main(String[] args) {
        new App().run();
    }
}
