package org.mobileOp.Objects;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User {
    private int id;
    private String passportData;
    private String name;
    private List<org.mobileOp.Objects.Number> numbers;
    private List<Booking> bookingRequests;

    public User(int id, String name, String passportData, List<org.mobileOp.Objects.Number> numbers, List<Booking> bookingsRequests) {
        this.id = id;
        this.name = name;
        this.passportData = passportData;
        this.numbers = numbers;
        this.bookingRequests = bookingsRequests;
    }

    public User(int id,String name, String passportData) {
        this.id = id;
        this.name = name;
        this.passportData = passportData;
        this.numbers = new ArrayList<>();
        this.bookingRequests = new ArrayList<>();
    }

    public void cancelUserRequest(int bookingId) {
        Booking booking = findBookingById(bookingId);
        getBookingRequests().remove(booking);
    }

    public Booking findBookingById(int bookingId){
        List<Booking> bookings = getBookingRequests();
        for (Booking b : bookings) {
            if(b.getId() == bookingId){
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

    @Override
    public String toString() {
        return "Name: " + name + ", Numbers: " + numbers.size() + ", Booking requests: " + bookingRequests.size();
    }

}
