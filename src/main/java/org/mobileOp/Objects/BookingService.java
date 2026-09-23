package org.mobileOp.Objects;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.mobileOp.Enums.BookingStatus;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BookingService {
    private final List<Booking> allBookings = new ArrayList<>();
    private final UserService userService;

    public BookingService() {
    }

    public void bookingNumber(Number number, User user) {
        if (user.getBookingRequests().size() < 10) {
            Booking bookingsRequests = new Booking(user.getBookingRequests().size() + 1, user, number, BookingStatus.IN_PROGRESS, LocalDate.now());
            user.getBookingRequests().add(bookingsRequests);
            allBookings.add(bookingsRequests);
        }
    }

    public Booking findBookingById(int bookingId){
        List<Booking> bookings = getAllBookings();
        for (Booking b : bookings) {
            if(b.getId() == bookingId){
                return b;
            }
        }
        return null;
    }

    public void cancelRequest(int bookingId, int userId, UserService userService) {
        Booking booking = findBookingById(bookingId);
        User user = userService.findUserById(userId);
        LocalDate now = LocalDate.now();
        if (ChronoUnit.DAYS.between(booking.getBookedAt(), now) >= (Booking.DEFAULT_BOOKING_DAYS + booking.getExtensionDays())) {
            user.getBookingRequests().remove(booking);
        }
    }

    public boolean completeBooking(Booking booking, User user){
        if(user.addNumber(booking.getNumber())){
            booking.setBookingStatus(BookingStatus.COMPLETED);
            return true;
        }
        return false;
    }

    public List<Booking> getAllBookings() {
        return this.allBookings;
    }
}