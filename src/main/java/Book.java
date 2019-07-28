/**
 * @Author: LP
 * @Date: 2019/7/28
 */
public class Book {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private String author;
    private  int  year;

    public Book(String name, String author, int year){
        this.name = name;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof  Book))
            return false;

        Book tmp = (Book)obj;
        return this.name.equals(tmp.name) && this.author.equals(tmp.author) && this.year == tmp.year ;
    }

    @Override
    public int hashCode() {
        return name.hashCode()+author.hashCode()+year;
    }
}
