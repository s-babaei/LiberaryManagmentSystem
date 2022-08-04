package model.repository;

import model.pojo.Book;

import java.util.ArrayList;
import java.util.Optional;

public interface BookRepository {

    Book creatBook(Book book);//down
    Optional<ArrayList<Book>> getAllBook();//down
    Optional<Book> getBookById(Long id);//down
    Optional<Book> searchBookByName(String name);//down
    Book updateBook(Book book);
    void deleteBook(Long id);






    //bor service  --->  get user by name & family ----> get book by name ----> insert

}
