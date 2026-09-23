package org.mobileOp.Objects;
import lombok.Data;
import org.mobileOp.Enums.PlanType;
import org.mobileOp.Enums.Status;
import org.mobileOp.Enums.NumberType;

import java.time.LocalDateTime;

@Data
public class Number {
    private String number;
    private Status status ;
    private NumberType numberType;
    private Plan plan;

    public Number(String number, Status status, NumberType numberType) {
        this.number = number;
        this.status = status;
        this.numberType = numberType;
        this.plan = new Plan( PlanType.DEFAULT, LocalDateTime.now(),0,0);
    }

    @Override
    public String toString(){
        return "Number: " + number + ", Status: " + status + ", Type: " + numberType;
    }
}
