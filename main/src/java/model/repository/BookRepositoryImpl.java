package model.repository;

import com.mysql.cj.jdbc.ConnectionImpl;
import model.pojo.Status;
import model.pojo.Book;

import java.lang.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

import static model.repository.GetConnectionToDataBase.getConnection;

public class BookRepositoryImpl implements BookRepository {
    @Override
    public Book creatBook(Book book) {
        Connection connection = getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into book(name,status,author) values(?,?,?)");
            preparedStatement.setString(1, book.getName());
            preparedStatement.setInt(2, 1);
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        int id = 0;

        try {
            PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * FROM book where name=? and status=? and author=?");
            preparedStatement1.setString(1, book.getName());
            preparedStatement1.setInt(2, book.getStatus().ordinal());
            preparedStatement1.setString(3, book.getAuthor());
            System.out.println(preparedStatement1);
            ResultSet resultSet = preparedStatement1.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("Id");
            }
        } catch (SQLException e) {
        }
        return new Book(Long.valueOf(id), book.getName(), book.getStatus(), book.getAuthor());
    }

    @Override
    public Optional<ArrayList<Book>> getAllBook() {
        Connection connection = getConnection();
        ArrayList<Book> books = new ArrayList<>();

        int id=0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM book WHERE status=1");
            while (resultSet.next()) {
                id = resultSet.getInt("Id");
                books.add(new Book((long) id,resultSet.getString("name"), Status.AVAILABLE, resultSet.getString("author")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Optional<ArrayList<Book>> books1 = Optional.of(books);
        return books1;
    }

    @Override
    public Optional<Book> getBookById(Long id) {

        Book book = new Book();
        Connection connection = new GetConnectionToDataBase().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM book where id=?;");
            preparedStatement.setInt(1, Math.toIntExact(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                book.setId((long) resultSet.getInt("id"));
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));
                if(resultSet.getInt("status")==1){
                    book.setStatus(Status.AVAILABLE);
                }else {
                    book.setStatus(Status.NOT_AVAILABLE);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(book);
    }

    @Override
    public Optional<Book> searchBookByName(String name) {
        Book book = new Book();
        Connection connection = getConnection();
//        return Optional.empty();
        PreparedStatement preparedStatement= null;
        try {
            preparedStatement = connection.prepareStatement("SELECT  * from book where name=?;");
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
           while (resultSet.next()){
               book.setId((long) resultSet.getInt("id"));
               book.setName(resultSet.getString("name"));
               book.setAuthor(resultSet.getString("author"));
               if(resultSet.getInt("status")==1){
                    book.setStatus(Status.AVAILABLE);
               }else{
                   book.setStatus(Status.NOT_AVAILABLE);
               }
           }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(book);
    }


    @Override
    public void deleteBook(Long id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("Delete FROM book where id =?;");
            preparedStatement.setInt(1, Math.toIntExact(id));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Book delete");
    }

    @Override
    public Book updateBook(Book book) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE book SET name=? , author=? , status=? where id=?;");
            preparedStatement.setString(1,book.getName());
            preparedStatement.setString(2,book.getAuthor());
            preparedStatement.setInt(3,book.getStatus().ordinal());
            preparedStatement.setInt(4, Math.toIntExact(book.getId()));
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;


    }


}
