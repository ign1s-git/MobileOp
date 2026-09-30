package org.mobileOp.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mobileOp.Objects.Number;
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

    public org.mobileOp.Objects.Number createNumber(String number, Status status, NumberType numberType) {
        Number newNumber = new Number(number, status, numberType);;
        return numberRepository.save(newNumber);
    }

    public List<Number> getFreeNumbers() {
        return numberRepository.findByStatus(Status.FREE);
    }

    public Number getNumberByNumber(String number) {
        return numberRepository.findByNumber(number).orElse(null);
    }

    public void deleteNumber(String number) {
        numberRepository.findByNumber(number).ifPresent(numberRepository::delete);
    }

    public List<Number> getAllNumbers() {
        return numberRepository.findAll();
    }

}
