package com.coderhouse.session.seven.controller;

import com.coderhouse.session.seven.business.CalculatorService;
import com.coderhouse.session.seven.business.exceptions.InvalidMathematicalOperationResultException;
import com.coderhouse.session.seven.business.exceptions.MathematicalOperationNotSupportedException;
import com.coderhouse.session.seven.business.exceptions.MathematicalOperationNotValidException;
import com.coderhouse.session.seven.business.domain.Operation;
import com.coderhouse.session.seven.business.domain.OperationResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorRestController {

    private final CalculatorService calculatorService;

    public CalculatorRestController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/calculate")
    @ResponseStatus(HttpStatus.OK)
    public OperationResult doOperation(@RequestBody Operation operation) throws MathematicalOperationNotSupportedException, MathematicalOperationNotValidException {
        return this.calculatorService.calculate(operation);
    }

    @PostMapping("/validate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void validateOperation(@RequestBody OperationResult operation) throws MathematicalOperationNotSupportedException, MathematicalOperationNotValidException, InvalidMathematicalOperationResultException {
        this.calculatorService.validate(operation);
    }
}
