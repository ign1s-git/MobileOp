package org.mobileOp.controllers;

import org.mobileOp.Objects.*;
import org.mobileOp.Objects.Number;
import org.mobileOp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUsers(){
        return userService.getAllUsersInfo();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user.getName(), user.getPassportData());
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){

        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return userService.updateUser(id, user.getName(), user.getPassportData());
    }

    @PostMapping("/{id}/numbers/{numberStr}")
    public boolean addNumber(@PathVariable("id") Long id, @PathVariable("numberStr") String numberStr){
        return userService.addNumberForUser(id, numberStr);
    }

    @PutMapping("/{userId}/bookings/{bookingId}")
    public void cancelBooking(@PathVariable Long userId, @PathVariable Long bookingId){
        userService.cancelUserBooking(userId, bookingId);
    }

    @GetMapping("/{userId}/bookings/{bookingId}")
    public String  findUserBookingById(@PathVariable Long userId, @PathVariable Long bookingId){
        return userService.findUserBookingById(userId, bookingId).toString();
    }

    @GetMapping("/{userId}/bookings")
    public String getAllUserBookings(@PathVariable Long userId){
        return userService.getAllUserBookings(userId);
    }

    @GetMapping("/{userId}/numbers")
    public List<Number> getAllUsersNumbers(@PathVariable Long userId){
        return userService.getAllUsersNumbers(userId);
    }
//    @PostMapping("/{id}/numbers/{numberId}")
//    public boolean removeNumber(@PathVariable Long id, @PathVariable Long numberId){
//        return userService.removeNumber(id, numberId);
//    }
//
//    @PostMapping("/{id}/numbers/{numberId}/plan")
//    public void changePlan(@PathVariable Long id, @PathVariable Long numberId, @RequestBody Plan plan){
//        userService.changePlan(id, numberId, plan);
//    }
}

