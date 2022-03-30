
package com.datagrokr.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/calculate/")
public class CalculatorController {
    
    
    @GetMapping("/operation")
    public double addNumbers(@RequestParam int val1, @RequestParam int val2, @RequestParam String op){
        if(op.equals("add"))
            return val1+val2;
        else if(op.equals("substract"))
            return val1-val2;
        else if(op.equals("multiply"))
            return val1*val2;
        else if(op.equals("divide"))
            try{
                double res =  (double) val1/val2;
                return res;
            } catch (Exception e){}
        return 0;
    }

    @GetMapping("/operator")
    public String testing(@RequestParam String operator){
        return operator;
    }
    
}
