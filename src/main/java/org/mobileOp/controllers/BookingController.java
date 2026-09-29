package org.mobileOp.controllers;

import org.mobileOp.Objects.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.mobileOp.Objects.Number;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @Autowired
    private NumberService numberService;
    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllBookings() {
        return bookingService.getAllBookingsInfo();
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingService.findBookingById(id);
    }

//    @DeleteMapping("/{bookingId}/user/{userId}")
//    public void cancelRequest(@PathVariable Long bookingId, @PathVariable Long userId) {
//            bookingService.cancelRequest(bookingId, userId);
//    }

    @PostMapping("/number/{numberStr}/user/{userId}")
    public String bookingNumber(@PathVariable("numberStr") String numberStr, @PathVariable("userId") Long userId) {
        User user = userService.findUserById(userId);
        Number number = numberService.getNumberByNumber(numberStr);
        if (user != null && number != null) {
            bookingService.bookingNumber(number, user);
            return "Booking is created!";
        }
        return "Booking is not created!";
    }

    @PutMapping("/{bookingId}/user/{userId}")
    public String completeBooking(@PathVariable("userId") Long userId, @PathVariable("bookingId") Long bookingId){
        User user = userService.findUserById(userId);
        Booking booking = bookingService.findBookingById(bookingId);
        if (user != null && booking != null){
            bookingService.completeBooking(booking, user);
            if(!bookingService.completeBooking(booking, user)){
                return "Booking is not completed!";
            }
        }
        return "Booking is completed!";
    }

    @PutMapping("/{bookingId}/{days}")
    public String bookingRenewal(@PathVariable ("bookingId") Long bookingId, @PathVariable ("days") int days) {
        bookingService.bookingRenew(bookingId,days);
        if (!bookingService.bookingRenew(bookingId,days)){
            return "Booking is not renewed!";
        }
        return "Booking is renewed!";
    }

}
