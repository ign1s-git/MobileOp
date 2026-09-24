package org.mobileOp.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mobileOp.enums.NumberType;
import org.mobileOp.enums.Status;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
public class NumberService {
    private List<Number> allNumbers = new ArrayList<>();

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
