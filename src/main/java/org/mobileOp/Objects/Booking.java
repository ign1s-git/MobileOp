package org.mobileOp.Objects;
import lombok.Data;
import org.mobileOp.Enums.BookingStatus;
import java.time.LocalDate;

@Data
public class Booking {
    private int id;
    private User user;
    private Number number;
    private BookingStatus bookingStatus;
    private LocalDate bookedAt;
    private LocalDate expiresAt;
    private int dayCounts = 3;

    public Booking(int id, User user, Number number, BookingStatus bookingStatus, LocalDate bookedAt, LocalDate expiresAt) {
        this.id = id;
        this.user = user;
        this.number = number;
        this.bookingStatus = bookingStatus;
        this.bookedAt = bookedAt;
        this.expiresAt = expiresAt;
    }

    public Booking(int id, User user, Number number, BookingStatus bookingStatus, LocalDate bookedAt) {
        this.id = id;
        this.user = user;
        this.number = number;
        this.bookingStatus = bookingStatus;
        this.bookedAt = bookedAt;
    }
    @Override
    public String toString() {
        return "Booking Id: " + id + ", User: " + user.getName() + ", User id: " + user.getId() +
                ", Number: " + number.getNumber() + ", Status: " + bookingStatus +
                ", Date: " + bookedAt;
    }

    public boolean bookingRenewal(int days){
        this.dayCounts += days;
        return true;
    }
}
