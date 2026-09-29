package org.mobileOp.Objects;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.mobileOp.enums.BookingStatus;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BookingService {
    @Getter
    private final List<Booking> allBookings = new ArrayList<>();
    private final UserService userService;

    public void bookingNumber(Number number, User user) {
        if (user.getBookingRequests().size() < 10) {
            Booking bookingsRequests = new Booking((long)user.getBookingRequests().size() + 1, user, number, BookingStatus.IN_PROGRESS, LocalDate.now());
            user.getBookingRequests().add(bookingsRequests);
            allBookings.add(bookingsRequests);
        }
    }

    public Booking findBookingById(Long bookingId){
        for (Booking b : this.allBookings) {
            if(b.getId().equals(bookingId)){
                return b;
            }
        }
        return null;
    }

    public void cancelRequest(Long bookingId, Long userId) {
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

    public boolean bookingRenew(Long bookingId, int days){
        Booking booking = findBookingById(bookingId);
        if (booking != null) {
            booking.bookingRenewal(days);
            return true;
        }
        return false;
    }

    public String getAllBookingsInfo() {

        return allBookings.toString();
    }

}