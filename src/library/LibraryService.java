package library;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import csv.CsvUtils;
import model.Book;

public class LibraryService {

    private BookDataGenerator bookDataGenerator;

    private List<Book> bookList;

    private List<String[]> data;

/*     public LibraryService(BookDataGenerator bookDataGenerator) throws IOException {
        this.bookDataGenerator = bookDataGenerator;
        loadData();
    } */

    public LibraryService(BookDataGenerator bookDataGenerator) throws IOException {
        this.bookDataGenerator = bookDataGenerator;
        loadData();
        // this.data = CsvUtils.readCsv(bookDataGenerator.getCsvFile());
        // this.bookList = data.stream().skip(1).map(row -> createBookFromRow(row)).collect(Collectors.toList());
    }

    private void loadData() throws IOException {
        this.data = CsvUtils.readCsv(bookDataGenerator.getCSV_FILE());
        // this.bookList =
        // data.stream().skip(1).map(this::createBookFromRow).collect(Collectors.toList());
        this.bookList = data.stream().skip(1).map(row -> createBookFromRow(row)).collect(Collectors.toList());
    }

    public List<Book> findBookByAuthor(String author) {
        return bookList.stream().filter(book -> book.getAuthor().equals(author)).collect(Collectors.toList());
    }

    private Book createBookFromRow(String[] row) {
        return new Book(row[0], row[1], row[2], Integer.parseInt(row[3]));
    }

    
}
