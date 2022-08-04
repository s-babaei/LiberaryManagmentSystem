package model.repository;

import model.pojo.User;
import model.pojo.UserBook;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository{
    @Override
    public User creatUser(User user) {
                Connection connection = GetConnectionToDataBase.getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO user(name, family ) values (?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getFamily());


            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        int id = 0;
        try {
            PreparedStatement preparedStatement1 =
                    connection.prepareStatement("SELECT * FROM user where name=? and family=?  ");
            preparedStatement1.setString(1, user.getName());
            preparedStatement1.setString(2, user.getFamily());
            ResultSet resultSet = preparedStatement1.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("Id");
            }
        } catch (SQLException e) {
        }
        return new User(Long.valueOf(id), user.getName(), user.getFamily());
    }

    @Override
    public Optional<ArrayList<User>> getAllUser() {
        Connection connection = GetConnectionToDataBase.getConnection();
        ArrayList<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
            while (resultSet.next()){
                users.add(new User(resultSet.getLong("id"),resultSet.getString("name"),resultSet.getString("family")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Optional<ArrayList<User>> optionalOfListOfUser= Optional.of(users);
        return optionalOfListOfUser;
    }


    @Override
    public Optional<User> getUserById(Long id) {
        Connection connection = GetConnectionToDataBase.getConnection();
        User user = null;
        Optional<User> userOptional = null;

        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select * from User where id=?;");
            preparedStatement.setInt(1, Math.toIntExact(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user=new User(resultSet.getLong("id"),resultSet.getString("name"),resultSet.getString("family"));
//                user.setId(resultSet.getLong("id"));
//                user.setName(resultSet.getString("name"));
//                user.setFamily(resultSet.getString("family"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(user) ;
    }

    @Override
    public Optional<User> searchUserByName(String name,String family) {

        Connection connection=GetConnectionToDataBase.getConnection();
        PreparedStatement preparedStatement= null;
        User user=new User();
        try {
            preparedStatement = connection.prepareStatement("select * from User where name=? and family=?;");
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,family);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user.setId(resultSet.getLong("id"));
               user.setName(resultSet.getString("name"));
               user.setFamily(resultSet.getString("family"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.of(user);
    }

    @Override
    public User updateUser(User user) {
        Connection connection=GetConnectionToDataBase.getConnection();
        PreparedStatement preparedStatement1 = null;
        try {
            preparedStatement1 = connection.prepareStatement("UPDATE user  set name =? , family=? where id=?");
            preparedStatement1.setInt(3, Math.toIntExact(user.getId()));
            preparedStatement1.setString(1,user.getName());
            preparedStatement1.setString(2,user.getFamily());
            preparedStatement1.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }



    @Override
    public void deleteUser(Long id) {
        Connection connection = GetConnectionToDataBase.getConnection();
        PreparedStatement preparedStatement1 = null;
        try {
            preparedStatement1 = connection.prepareStatement("DELETE  FROM user where id=? ");
            preparedStatement1.setInt(1, Math.toIntExact(id));
            preparedStatement1.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("deleted");
    }

    @Override
    public void borrow(UserBook userBook) {
        Connection connection = GetConnectionToDataBase.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT into user_book(create_date,status,user_id,book_id) values (?,?,?,?) ;");
            preparedStatement.setDate(1,userBook.getCreat_date());
            preparedStatement.setInt(2,0);
            preparedStatement.setInt(3, Math.toIntExact(userBook.getUserId()));
            preparedStatement.setInt(4, Math.toIntExact(userBook.getBook_id()));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//
//    @Override
//    public User creatUser(User user) {
//        //todo : connect to database
//        Connection connection = GetConnectionToDataBase.getConnection();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO member(firstName, lastName) values (?,?)");
//            preparedStatement.setString(1, user.getFirstName());
//            preparedStatement.setString(2, user.getLastName());
//
//            preparedStatement.execute();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        int id = 0;
//        try {
//            PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * FROM member where firstName=? and lastName=? ");
//            preparedStatement1.setString(1, user.getFirstName());
//            preparedStatement1.setString(2, user.getLastName());
//
//            System.out.println(preparedStatement1);
//            ResultSet resultSet = preparedStatement1.executeQuery();
//            while (resultSet.next()) {
//                id = resultSet.getInt("Id");
//            }
//        } catch (SQLException e) {
//        }
//        return new User(Long.valueOf(id), user.getFirstName(), user.getLastName());
//    }
//
//    @Override
//    public Optional<ArrayList<User>> getAllMember() {
//        Connection connection = GetConnectionToDataBase.getConnection();
//        ArrayList<User> users = new ArrayList<>();
//        try {
//            Statement statement = connection.createStatement();
//            statement.execute("SELECT * FROM Member WHERE activation=1");
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM member WHERE activation=1");
//            while (resultSet.next()){
//
//                users.add(new User(resultSet.getString("name"),resultSet.getString("family"),
//                        resultSet.getInt("age"), Activation.ACTIVE));
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        Optional<ArrayList<User>> members1= Optional.of(users);
//        return members1;
//    }
//
//    @Override
//    public Optional<ArrayList<User>> getMemberById(Long id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Optional<ArrayList<User>> searchMemberByName(String name) {
//        return Optional.empty();
//    }
//
//    @Override
//    public User updateMember(User book) {
//        return null;
//    }
//
//    @Override
//    public void deleteMember(Long id) {
//
//    }

}
