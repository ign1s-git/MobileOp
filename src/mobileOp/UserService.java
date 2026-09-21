package mobileOp;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> allUsers =  new ArrayList<>();

    public UserService(List<User> allUsers) { this.allUsers = allUsers; }
    public UserService() {}

    public User findUserById(int userId){
        List<User> users = getAllUsers();
        for (User u : users) {
            if(u.getId() == userId){
                return u;
            }
        }
        return null;
    }


    public User createUser(String name, String passportData) {
        User user =  new User (allUsers.size() + 1 ,name, passportData);
        allUsers.add(user);
        return user;
    }

    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        for (User u : allUsers) {
            result.add(u);
        }
        return result;
    }
}
