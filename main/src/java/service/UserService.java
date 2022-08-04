package service;

import model.pojo.User;
import model.pojo.UserBook;
import model.repository.UserRepository;
import model.repository.UserRepositoryImpl;

import java.util.ArrayList;
import java.util.Optional;
public class UserService {

    UserRepository userRepository = new UserRepositoryImpl();

    public User creatUser(User user) {
        return userRepository.creatUser(user);
    }

    public Optional<ArrayList<User>> getAllUser() {
        return userRepository.getAllUser();
    }

    public Optional<User> getUserById(Long Id) {
        return userRepository.getUserById(Id);
    }

    public Optional<User> searchUserByName(String name,String family) {
        return userRepository.searchUserByName(name,family);
    }

    public User updateUser(User user) {
        return userRepository.updateUser(user);
    }

    public void deleteUser(Long Id) {
        userRepository.deleteUser(Id);
    }

    public void borrow(UserBook userBook){
        userRepository.borrow(userBook);
    }

}
