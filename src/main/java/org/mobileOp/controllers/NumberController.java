package org.mobileOp.controllers;

import org.mobileOp.Objects.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.mobileOp.Objects.Number;
import java.util.List;
@RestController
@RequestMapping("/api/numbers")
public class NumberController {

    @Autowired
    private NumberService numberService;

    @GetMapping
    public List<Number> getAllNumbers() {
        return numberService.getAllNumbers();
    }

    @GetMapping("/{number}")
    public Number getNumberByNumber(@PathVariable String number){
        return numberService.getNumberByNumber(number);
    }

    @GetMapping("/free")
    public List<Number> freeNumbers (){
        return numberService.freeNumbers();
    }

    @PostMapping
    public Number createNumber(@RequestBody Number number) {
        return numberService.createNumber(number.getNumber(), number.getStatus(), number.getNumberType());
    }

}
