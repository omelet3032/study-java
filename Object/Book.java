package Object;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book implements Cloneable {

    String title;

    String author;

    int year;

    List<String> chapter = new ArrayList<>();

    public Book() {
    }

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

      /*   if (!(obj instanceof Book)) {
            return false;
        } */

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Book book = (Book) obj;

        // return Objects.equals(title, book.title) && Objects.equals(author,
        // book.author) && Objects.equals(chapter, book.chapter);
        return Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
        // return Objects.hash(title, author, chapter);
    }

    @Override
    public String toString() {
        return "Book [제목 : " + title + ", 저자 : " + author + ", 출판년도 : " + year + "]";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Book clonedBook = (Book) super.clone();
        // clonedBook.chapter = new ArrayList<>(this.chapter);
        clonedBook.chapter = this.chapter;
        return clonedBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public void setChapter(List<String> chapter) {
        this.chapter = chapter;
    }

    public List<String> getChapter() {
        return chapter;
    }

}