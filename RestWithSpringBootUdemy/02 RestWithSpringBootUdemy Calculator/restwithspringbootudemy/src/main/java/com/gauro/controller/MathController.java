package com.gauro.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.gauro.converters.NumberConverter;
import com.gauro.math.SimpleMath;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chandra
 */
@RestController
public class MathController {
    private SimpleMath simpleMath=new SimpleMath();

    @GetMapping(value="/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return simpleMath.sum(NumberConverter.covertToDouble(numberOne), NumberConverter.covertToDouble(numberTwo));
    }
    @GetMapping(value = "/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return simpleMath.subtraction(NumberConverter.covertToDouble(numberOne), NumberConverter.covertToDouble(numberTwo));
    }
    @GetMapping(value = "/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return simpleMath.multiplication(NumberConverter.covertToDouble(numberOne), NumberConverter.covertToDouble(numberTwo));
    }

    @GetMapping(value = "/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return simpleMath.division(NumberConverter.covertToDouble(numberOne), NumberConverter.covertToDouble(numberTwo));
    }

    @GetMapping(value = "/mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return simpleMath.mean(NumberConverter.covertToDouble(numberOne), NumberConverter.covertToDouble(numberTwo));
    }
    @GetMapping(value = "/squareRoot/{number}")
    public Double squareRoot(@PathVariable("number") String number) throws Exception {
        if (!NumberConverter.isNumeric(number)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return simpleMath.squareRoot(NumberConverter.covertToDouble(number));
    }


}
