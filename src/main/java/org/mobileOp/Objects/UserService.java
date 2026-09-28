package org.mobileOp.Objects;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> allUsers =  new ArrayList<>();

    public UserService() {}

    public User findUserById(Long userId){
        List<User> users = getAllUsers();
        for (User u : users) {
            if(u.getId().equals(userId)){
                return u;
            }
        }
        return null;
    }

    public User updateUser(Long id, String name, String passportData) {
        User user = findUserById(id);
        if (user != null) {
            user.setName(name);
            user.setPassportData(passportData);
        }
        return user;
    }


    public User createUser(String name, String passportData) {
        User user =  new User ((long)allUsers.size() + 1 ,name, passportData);
        allUsers.add(user);
        return user;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(allUsers);
    }

    public void deleteUser(Long id) {
        User userToDelete = findUserById(id);
        if (userToDelete != null) {
            allUsers.remove(userToDelete);
        }
    }

    public boolean addNumberForUser(Long id, Number number){
        if (this.findUserById(id) != null){
            this.findUserById(id).addNumber(number);
            return true;
        }
        return false;
    }
    public void cancelUserBooking(Long userId, Long bookingId){
        User user = findUserById(userId);
        user.cancelUserBooking(bookingId);
    }

    public void findUserBookingById(Long userId, Long bookingId){
        User user = findUserById(userId);
        user.findBookingById(bookingId);
    }

}
