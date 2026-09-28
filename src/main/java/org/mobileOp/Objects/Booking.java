package org.mobileOp.Objects;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mobileOp.enums.BookingStatus;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Booking {
    public static final int DEFAULT_BOOKING_DAYS = 3;
    private Long id;
    private User user;
    private Number number;
    private BookingStatus bookingStatus;
    private LocalDate bookedAt;
    private LocalDate expiresAt;
    private int extensionDays = 0;

    public Booking(Long id, User user, Number number, BookingStatus bookingStatus, LocalDate bookedAt, LocalDate expiresAt) {
        this.id = id;
        this.user = user;
        this.number = number;
        this.bookingStatus = bookingStatus;
        this.bookedAt = bookedAt;
        this.expiresAt = expiresAt;
    }

    public Booking(Long id, User user, Number number, BookingStatus bookingStatus, LocalDate bookedAt) {
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
        if(this.bookingStatus != BookingStatus.COMPLETED) {
            this.extensionDays = days;
            return true;
        }
        return false;
    }

}
