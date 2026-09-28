package org.mobileOp.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mobileOp.enums.BookingStatus;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private Long id;
    private String passportData;
    private String name;
    private List<Number> numbers;
    private List<Booking> bookingRequests;

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
