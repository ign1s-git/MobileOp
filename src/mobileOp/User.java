package mobileOp;


import mobileOp.Enums.BookingStatus;

import java.time.LocalDate;
import java.util.List;

public class User {
    private int passportData;
    private String name;
    private List<Number> numbers;
    private List<Booking> bookingRequests;

    public User(String name, int passportData, List<Number> numbers, List<Booking> bookingsRequests) {
        this.name = name;
        this.passportData = passportData;
        this.numbers = numbers;
        this.bookingRequests = bookingsRequests;
    }

    public void bookingNumber(Number number, int counter) {
        if (numbers.size() < 3) {
            numbers.add(number);
            Booking bookingsRequests = new Booking(counter, this, number, BookingStatus.InProgress, LocalDate.now());
            bookingRequests.add(bookingsRequests);
        }
    }

    public int getPassportData() {
        return passportData;
    }

    public void setPassportData(int passportData) {
        this.passportData = passportData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public List<Booking> getBookingRequests() {
        return bookingRequests;
    }

    public void setBookingRequests(List<Booking> bookingRequests) {
        this.bookingRequests = bookingRequests;
    }
}
