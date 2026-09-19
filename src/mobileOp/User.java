package mobileOp;

import mobileOp.Enums.BookingStatus;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String passportData;
    private String name;
    private List<Number> numbers;
    private List<Booking> bookingRequests;

    public User(int id,String name, String passportData, List<Number> numbers, List<Booking> bookingsRequests) {
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
        this.bookingRequests = new ArrayList<>();;
    }

    public List<Booking> getAllRequests() {
        List<Booking> result = new ArrayList<>();
        for (Booking b : this.getBookingRequests()) {
            result.add(b);
            System.out.println(b.getId());
        }
        return result;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Numbers: " + numbers.size() + ", Booking requests: " + bookingRequests.size();
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getPassportData() { return passportData; }

    public void setPassportData(String passportData) { this.passportData = passportData; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public List<Number> getNumbers() { return numbers; }

    public void setNumbers(List<Number> numbers) { this.numbers = numbers; }

    public List<Booking> getBookingRequests() { return bookingRequests; }

    public void setBookingRequests(List<Booking> bookingRequests) { this.bookingRequests = bookingRequests; }
}
