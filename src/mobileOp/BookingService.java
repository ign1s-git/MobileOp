package mobileOp;

import mobileOp.Enums.BookingStatus;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private List<Booking> allBookings = new ArrayList<>();
    private UserService userService= new UserService();

    public BookingService() {}

    public void bookingNumber(Number number, User user) {
        if (user.getBookingRequests().size() < 3) {
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

    public void cancelRequest(int bookingId, int userId) {
        List<User> allUsers = userService.getAllUsers();
        Booking booking = findBookingById(bookingId);
        User user = userService.findUserById(userId);
        LocalDate now = LocalDate.now();
        if (ChronoUnit.DAYS.between(booking.getBookedAt(), now) >= booking.getDayCounts()) {
            user.getBookingRequests().remove(booking);
        }
    }

    public List<Booking> getAllBookings() {
        return this.allBookings;
    }
}
