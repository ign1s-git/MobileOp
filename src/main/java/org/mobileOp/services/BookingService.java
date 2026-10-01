package org.mobileOp.services;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.mobileOp.Objects.Booking;
import org.mobileOp.Objects.Number;
import org.mobileOp.Objects.User;
import org.mobileOp.enums.BookingStatus;
import org.mobileOp.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@RequiredArgsConstructor
@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private NumberService numberService;

    @Getter
    private final UserService userService;

    public String bookingNumber(String numberStr, Long userId) {
        User user = userService.findUserById(userId);
        Number number = numberService.getNumberByNumber(numberStr);
        if (user != null && number != null) {
            if (user.getBookingRequests().size() < 10) {
                Booking bookingRequests = new Booking(user, number, BookingStatus.IN_PROGRESS, LocalDate.now());
                bookingRepository.save(bookingRequests);
                return "Booking is created!";
            }
            return "Booking limit reached!";
        }
        return "User or number not found!";
    }

    public Booking findBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId).orElse(null);
    }

    public void expireBooking(Long bookingId, Long userId) {
        Booking booking = findBookingById(bookingId);
        User user = userService.findUserById(userId);
        LocalDate now = LocalDate.now();
        if (ChronoUnit.DAYS.between(booking.getBookedAt(), now) >= (Booking.DEFAULT_BOOKING_DAYS + booking.getExtensionDays())) {
            booking.setBookingStatus(BookingStatus.EXPIRED);
            bookingRepository.save(booking);
            user.getBookingRequests().remove(booking);
        }
    }

    public String completeBooking(Long userId, Long bookingId) {
        User user = userService.findUserById(userId);
        Booking booking = findBookingById(bookingId);
        if (user != null && booking != null) {
            if (user.addNumber(booking.getNumber())) {
                booking.setBookingStatus(BookingStatus.COMPLETED);
                bookingRepository.save(booking);
                return "Booking is completed!";
            }
        }
        return "Booking is not completed!";
    }

    public String bookingRenew(Long bookingId, int days) {
        Booking booking = findBookingById(bookingId);
        if (booking != null) {
            booking.bookingRenewal(days);
            bookingRepository.save(booking);
            return "Booking is renewed!";
        }
        return "Booking is not renewed!";
    }

    public String getAllBookingsInfo() {
        return bookingRepository.findAll().toString();
    }
}