package org.mobileOp.controllers;

import org.mobileOp.Objects.*;
import org.mobileOp.Objects.Number;
import org.mobileOp.services.BookingService;
import org.mobileOp.services.NumberService;
import org.mobileOp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // @DeleteMapping("/{bookingId}/user/{userId}")
    // public void cancelRequest(@PathVariable Long bookingId, @PathVariable Long
    // userId) {
    // bookingService.cancelRequest(bookingId, userId);
    // }

    @PostMapping("/number/{numberStr}/user/{userId}")
    public String bookingNumber(@PathVariable("numberStr") String numberStr, @PathVariable("userId") Long userId) {
          return bookingService.bookingNumber(numberStr, userId);
    }



    @PutMapping("/{bookingId}/user/{userId}")
    public String completeBooking(@PathVariable("userId") Long userId, @PathVariable("bookingId") Long bookingId) {
             return bookingService.completeBooking(bookingId, userId);
    }

    @PutMapping("/{bookingId}/{days}")
    public String bookingRenewal(@PathVariable("bookingId") Long bookingId, @PathVariable("days") int days) {
       return bookingService.bookingRenew(bookingId, days);
    }

}
