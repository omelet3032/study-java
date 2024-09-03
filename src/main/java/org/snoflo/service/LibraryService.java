package org.snoflo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.snoflo.csv.LibraryCsvFileManager;
import org.snoflo.csv.LibraryDataConverter;
import org.snoflo.model.Book;

public class LibraryService {

    private LibraryDataConverter libraryDataConverter;
    private static LibraryService instance;

    public LibraryService() {
        this.libraryDataConverter = new LibraryDataConverter(new LibraryCsvFileManager("library.csv", 100));
    }

    public static synchronized LibraryService getInstance() {
        if (instance == null) {
            instance = new LibraryService();
        }
        return instance;
    }

   
    public List<Book> findBookByAuthor(String author) {
        List<Book> bookList = libraryDataConverter.getBookList();
        return bookList.stream().filter(book -> book.getAuthor().equals(author)).collect(Collectors.toList());
    }

}
