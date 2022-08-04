package model.repository;

import model.pojo.User;
import model.pojo.UserBook;

import java.util.ArrayList;
import java.util.Optional;

public interface UserRepository {
    User creatUser(User user);//down
    Optional<ArrayList<User>> getAllUser();//down
    Optional<User> getUserById(Long id);//down
    Optional<User> searchUserByName(String name,String family);//down
    User updateUser(User user);
    void deleteUser(Long id);//down
    void borrow(UserBook userBook);
}
