package mobileOp;

import mobileOp.Enums.NumberType;
import mobileOp.Enums.Status;

import java.util.ArrayList;
import java.util.List;

public class NumberService {
    private List<Number> allNumbers = new ArrayList<>();

    public NumberService (List<Number> allNumbers){ this.allNumbers = allNumbers;}
    public NumberService(){}

    public Number createNumber (String number, Status status, NumberType numberType){
        Number newNumber = new Number( number, status, numberType);
        allNumbers.add(newNumber);
        return newNumber;
    }

    public List<Number> freeNumbers (){
        List<Number> freeNums = new ArrayList<>();
        for(Number n: allNumbers){
            if(n.getStatus() == Status.FREE){
                freeNums.add(n);
            }
        }
        return freeNums;
    }

    public List<Number> getAllNumbers() {
        return this.allNumbers;
    }
}
