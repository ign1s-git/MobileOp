package org.mobileOp.services;

import org.mobileOp.Objects.Number;
import org.mobileOp.Objects.User;
import org.mobileOp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService() {
    }

    public User findUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User updateUser(Long id, String name, String passportData) {
        User user = findUserById(id);
        if (user != null) {
            user.setName(name);
            user.setPassportData(passportData);
            return userRepository.save(user);
        }
        return null;
    }

    public User createUser(String name, String passportData) {
        User user = new User(null, name, passportData);
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public boolean addNumberForUser(Long id, Number number) {
        if (this.findUserById(id) != null) {
            this.findUserById(id).addNumber(number);
            return true;
        }
        return false;
    }

    public void cancelUserBooking(Long userId, Long bookingId) {
        User user = findUserById(userId);
        user.cancelUserBooking(bookingId);
    }

    public void findUserBookingById(Long userId, Long bookingId) {
        User user  = findUserById(userId);
        user.findBookingById(bookingId);
    }
}
