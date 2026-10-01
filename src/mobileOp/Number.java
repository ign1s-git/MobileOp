package mobileOp;
import mobileOp.Enums.Status;
import mobileOp.Enums.NumberType;

public class Number {
    private int number;
    private Status status ;
    private NumberType numberType;

    public Number(int number, Status status, NumberType numberType) {
        this.number = number;
        this.status = status;
        this.numberType = numberType;
    }


    public int getNumber() { return number;}

    public void setNumber(int number) { this.number = number;}

    public Status getStatus() { return status; }

    public void setStatus(Status status) { this.status = status;}

    public NumberType getNumberType() { return numberType;}

    public void setNumberType(NumberType numberType) {this.numberType = numberType;}
}
