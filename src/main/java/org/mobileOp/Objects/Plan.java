package org.mobileOp.Objects;

import lombok.Data;
import org.mobileOp.Enums.PlanType;

import java.time.LocalDateTime;

@Data
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

}
