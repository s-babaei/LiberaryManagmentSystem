package service;

import model.pojo.Book;
import model.repository.BookRepository;
import model.repository.BookRepositoryImpl;

import java.util.ArrayList;
import java.util.Optional;

public class BookService {
    BookRepository bookRepository = new BookRepositoryImpl();

    public Book creatBook(Book book) {
        return bookRepository.creatBook(book);
    }

    public Optional<ArrayList<Book>> getAllBook() {
        return bookRepository.getAllBook();
    }

    public Optional<Book> getBookById(Long Id) {
        return bookRepository.getBookById(Id);
    }

    public Optional<Book> searchBookByName(String name) {
        return bookRepository.searchBookByName(name);
    }

   public Book updateBook(Book book) {
        return bookRepository.updateBook(book);

    }

    public void deleteBook(Long Id) {
        bookRepository.deleteBook(Id);
    }

}
