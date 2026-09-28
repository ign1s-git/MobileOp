package org.mobileOp.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mobileOp.enums.PlanType;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class Plan {
    @JsonIgnore
    private Long id;
    private PlanType type;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;
    private int payment;
    private int dayCount;

    public Plan(Long id,PlanType type, LocalDateTime startDate, int payment, int dayCount) {
        this.id = id;
        this.type = type;
        this.startDate = startDate;
        this.endDate = startDate.plusDays(dayCount);
        this.payment = payment;
        this.dayCount = dayCount;
    }

}
