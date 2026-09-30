package org.mobileOp.Objects;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mobileOp.enums.NumberType;
import org.mobileOp.enums.Status;
import org.mobileOp.repositories.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class NumberService {

    @Autowired
    private NumberRepository numberRepository;

    private List<Number> allNumbers = new ArrayList<>();

    public Number createNumber(String number, Status status, NumberType numberType) {
        Number newNumber = new Number(number, status, numberType);
        allNumbers.add(newNumber);
        return newNumber;
    }

    public List<Number> getFreeNumbers() {
        List<Number> freeNums = new ArrayList<>();
        for (Number n : allNumbers) {
            if (n.getStatus() == Status.FREE) {
                freeNums.add(n);
            }
        }
        return freeNums;
    }

    public Number getNumberByNumber(String number) {
        List<Number> numbers = getAllNumbers();
        for (Number n : numbers) {
            if (n.getNumber().equals(number)) {
                return n;
            }
        }
        return null;
    }

    public void deleteNumber(String number){
        Number number1 = getNumberByNumber(number);
         this.allNumbers.remove(number1);
    }

    public List<Number> getAllNumbers() {
        return new ArrayList<>(allNumbers);
    }

}
