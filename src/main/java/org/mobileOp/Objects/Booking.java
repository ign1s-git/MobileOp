package org.mobileOp.Objects;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mobileOp.enums.BookingStatus;

import java.time.LocalDate;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
public class Booking {

    @Column(name = "default_booking_days")
    public static final int DEFAULT_BOOKING_DAYS = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "number_id")
    private Number number;

    @Column(name = "booking_status")
    private BookingStatus bookingStatus;

    @Column(name = "booked_at")
    private LocalDate bookedAt;

    @Column(name = "expires_at")
    private LocalDate expiresAt;

    @Column(name = "extension_days")
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

    public Booking( User user, Number number, BookingStatus bookingStatus, LocalDate bookedAt) {
        this.user = user;
        this.number = number;
        this.bookingStatus = bookingStatus;
        this.bookedAt = bookedAt;
    }

    @Override
    public String toString() {
        String userName = (user != null) ? user.getName() : "null";
        String userId = (user != null) ? String.valueOf(user.getId()) : "null";
        String numberStr = (number != null) ? number.getNumber() : "null";
        return "Booking Id: " + id + ", User: " + userName + ", User id: " + userId +
                ", Number: " + numberStr + ", Status: " + bookingStatus +
                ", Date: " + bookedAt;
    }

    public boolean bookingRenewal(int days) {
        if (this.bookingStatus != BookingStatus.COMPLETED) {
            this.extensionDays = days;
            this.expiresAt = this.expiresAt.plusDays(days);
            return true;
        }
        return false;
    }

}
