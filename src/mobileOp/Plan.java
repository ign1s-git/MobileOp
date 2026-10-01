package mobileOp;

import mobileOp.Enums.PlanType;

import java.time.LocalDateTime;

public class Plan {
    private PlanType type;
    private LocalDateTime startDate;
    private LocalDateTime EndDate;
    private int Payment;
    private int DayCount;

    public Plan(PlanType type, LocalDateTime startDate, int Payment, int DayCount) {
        this.type = type;
        this.startDate = startDate;
        this.EndDate = startDate.plusDays(DayCount) ;
        this.Payment = Payment;
        this.DayCount = DayCount;
    }

    public PlanType getType() { return type; }

    public void setType(PlanType type) { this.type = type; }

    public LocalDateTime getStartDate() { return startDate; }

    public void setStartDate(LocalDateTime startDate) { this.startDate = startDate; }

    public LocalDateTime getEndDate() { return EndDate; }

    public void setEndDate(LocalDateTime endDate) { EndDate = endDate; }

    public int getPayment() { return Payment; }

    public void setPayment(int payment) { Payment = payment; }

    public int getDayCount() { return DayCount; }

    public void setDayCount(int dayCount) { DayCount = dayCount; }

}
