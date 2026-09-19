package mobileOp;

import mobileOp.Enums.BookingStatus;

import java.time.LocalDate;

public class Booking {
    private int id;
    private User user;
    private Number number;
    // private Plan plan;
    private BookingStatus bStatus;
    private LocalDate bookedAt;
    private LocalDate expiresAt;

    public Booking(int id, User user, Number number, BookingStatus bStatus, LocalDate bookedAt, LocalDate expiresAt) {
        this.id = id;
        this.user = user;
        this.number = number;
        // this.plan = plan;
        this.bStatus = bStatus;
        this.bookedAt = bookedAt;
        this.expiresAt = expiresAt;
    }

    public Booking(int id, mobileOp.User user, Number number, mobileOp.Enums.BookingStatus bStatus, LocalDate bookedAt) {
        this.id = id;
        this.user = user;
        this.number = number;
        // this.plan = plan;
        this.bStatus = bStatus;
        this.bookedAt = bookedAt;
    }
    @Override
    public String toString() {
        return "Booking Id: " + id + ", User: " + user.getName() + ", User id: " + user.getId() +
                ", Number: " + number.getNumber() + ", Status: " + bStatus +
                ", Date: " + bookedAt;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Number getNumber() { return number; }

    public void setNumber(Number number) { this.number = number; }

    //    public Plan getPlan() { return plan; }
    //
    //    public void setPlan(Plan plan) { this.plan = plan; }

    public mobileOp.Enums.BookingStatus getbStatus() { return bStatus; }

    public void setbStatus(mobileOp.Enums.BookingStatus bStatus) { this.bStatus = bStatus; }

    public LocalDate getBookedAt() { return bookedAt; }

    public void setBookedAt(LocalDate bookedAt) { this.bookedAt = bookedAt; }

    public LocalDate getExpiresAt() { return expiresAt; }

    public void setExpiresAt(LocalDate expiresAt) { this.expiresAt = expiresAt; }
}
