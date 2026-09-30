package org.mobileOp.Objects;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mobileOp.enums.BookingStatus;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users") // В PostgreSQL слово 'user' зарезервировано, поэтому имя таблицы 'users'
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "passport_data")
    private String passportData;

    @Column(name = "name")
    private String name;

    @Transient
    private List<Number> numbers = new ArrayList<>();

    @Transient
    private List<Booking> bookingRequests = new ArrayList<>();

    public User(Long id, String name, String passportData, List<org.mobileOp.Objects.Number> numbers, List<Booking> bookingsRequests) {
        this.id = id;
        this.name = name;
        this.passportData = passportData;
        this.numbers = numbers;
        this.bookingRequests = bookingsRequests;
    }

    public User(Long id,String name, String passportData) {
        this.id = id;
        this.name = name;
        this.passportData = passportData;
        this.numbers = new ArrayList<>();
        this.bookingRequests = new ArrayList<>();
    }

    public void cancelUserBooking(Long bookingId) {
        Booking booking = findBookingById(bookingId);
        booking.setBookingStatus(BookingStatus.CANCELLED);
    }

    public Booking findBookingById(Long bookingId){
        List<Booking> bookings = getBookingRequests();
        for (Booking b : bookings) {
            if(b.getId().equals(bookingId)){
                return b;
            }
        }
        return null;
    }

    public boolean changePlan (String number, Plan plan){
        for (org.mobileOp.Objects.Number n : this.numbers) {
            if (n.getNumber().equals(number)){
                plan.setStartDate(LocalDateTime.now());
                n.setPlan(plan);
                return true;
            }
        }
        return false;
    }

    public boolean addNumber(Number number){
        if (this.numbers.size() <= 3){
            this.numbers.add(number);
            return true;
        }
        return false;
    }

    public void removeNumber(Number number) {

        this.numbers.remove(number);
    }




    @Override
    public String toString() {
        return "Name: " + name + ", Numbers: " + numbers.size() + ", Booking requests: " + bookingRequests.size();
    }

}
