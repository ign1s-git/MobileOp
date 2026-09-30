package org.mobileOp.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mobileOp.enums.PlanType;

import java.time.LocalDateTime;

@Entity
@Table(name = "plans")
@NoArgsConstructor
@Data
public class Plan {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "plan_type")
    private PlanType type;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "start_date")
    private LocalDateTime startDate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "payment")
    private int payment;

    @Column(name = "day_count")
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
