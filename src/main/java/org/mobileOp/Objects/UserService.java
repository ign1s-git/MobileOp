package org.mobileOp.Objects;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> allUsers =  new ArrayList<>();

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
        return new ArrayList<>(allUsers);
    }
}
