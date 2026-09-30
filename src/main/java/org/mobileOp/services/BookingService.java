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
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@RequiredArgsConstructor
@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Getter
    private final UserService userService;

    public void bookingNumber(Number number, User user) {
        if (user.getBookingRequests().size() < 10) {
            Booking bookingsRequests = new Booking((long)user.getBookingRequests().size() + 1, user, number, BookingStatus.IN_PROGRESS, LocalDate.now());
            bookingRepository.save(bookingsRequests);
        }
    }

    public Booking findBookingById(Long bookingId){
        return bookingRepository.findById(bookingId).orElse(null);
    }

    public void cancelRequest(Long bookingId, Long userId) {
        Booking booking = findBookingById(bookingId);
        User user = userService.findUserById(userId);
        LocalDate now = LocalDate.now();
        if (ChronoUnit.DAYS.between(booking.getBookedAt(), now) >= (Booking.DEFAULT_BOOKING_DAYS + booking.getExtensionDays())) {
            user.getBookingRequests().remove(booking);
        }
    }

    public Booking completeBooking(Booking booking, User user){
        if(user.addNumber(booking.getNumber())){
            booking.setBookingStatus(BookingStatus.COMPLETED);
            return bookingRepository.save(booking);
        }
        return null;
    }

    public Booking bookingRenew(Long bookingId, int days){
        Booking booking = findBookingById(bookingId);
        if (booking != null) {
            booking.bookingRenewal(days);
            return bookingRepository.save(booking) ;
        }
        return null;
    }

    public String getAllBookingsInfo() {

        return bookingRepository.findAll().toString();
    }
}