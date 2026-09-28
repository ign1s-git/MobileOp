package org.mobileOp.Objects;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mobileOp.enums.PlanType;
import org.mobileOp.enums.Status;
import org.mobileOp.enums.NumberType;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Number {
    private String number;
    private Status status;
    private NumberType numberType;
    @JsonIgnore
    private Plan plan;

    public Number(String number, Status status, NumberType numberType) {
        this.number = number;
        this.status = status;
        this.numberType = numberType;
        this.plan = null;
    }

    @Override
    public String toString(){
        return "Number: " + number + ", Status: " + status + ", Type: " + numberType;
    }
}
