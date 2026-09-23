package org.mobileOp.Objects;

import lombok.Getter;
import org.mobileOp.Enums.NumberType;
import org.mobileOp.Enums.Status;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class NumberService {
    private final List<Number> allNumbers = new ArrayList<>();

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

}
