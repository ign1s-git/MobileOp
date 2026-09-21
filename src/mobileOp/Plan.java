package mobileOp;

import mobileOp.Enums.PlanType;

import java.time.LocalDateTime;

public class Plan {
    private PlanType type;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int payment;
    private int dayCount;

    public Plan(PlanType type, LocalDateTime startDate, int payment, int dayCount) {
        this.type = type;
        this.startDate = startDate;
        this.endDate = startDate.plusDays(dayCount) ;
        this.payment = payment;
        this.dayCount = dayCount;
    }

    public PlanType getType() { return type; }

    public void setType(PlanType type) { this.type = type; }

    public LocalDateTime getStartDate() { return startDate; }

    public void setStartDate(LocalDateTime startDate) { this.startDate = startDate; }

    public LocalDateTime getEndDate() { return endDate; }

    public void setEndDate(LocalDateTime endDate) { this.endDate = endDate; }

    public int getPayment() { return payment; }

    public void setPayment(int payment) { this.payment = payment; }

    public int getDayCount() { return dayCount; }

    public void setDayCount(int dayCount) { this.dayCount = dayCount; }

}
