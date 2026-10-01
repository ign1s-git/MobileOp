package mobileOp;
import mobileOp.Enums.PlanType;
import mobileOp.Enums.Status;
import mobileOp.Enums.NumberType;

import java.time.LocalDateTime;

public class Number {
    private String number;
    private Status status ;
    private NumberType numberType;
    private Plan plan;

    public Number(String number, Status status, NumberType numberType) {
        this.number = number;
        this.status = status;
        this.numberType = numberType;
        this.plan = new Plan( PlanType.DEFAULT, null,0,0);
    }

    @Override
    public String toString(){
        return "Number: " + number + ", Status: " + status + ", Type: " + numberType;
    }

    public String getNumber() { return number;}

    public void setNumber(String number) { this.number = number;}

    public Status getStatus() { return status; }

    public void setStatus(Status status) { this.status = status;}

    public NumberType getNumberType() { return numberType;}

    public void setNumberType(NumberType numberType) {this.numberType = numberType;}

    public Plan getPlan() { return plan; }

    public void setPlan(Plan plan) { this.plan = plan; }
}
