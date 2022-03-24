package com.desafio.test.controller;

import com.coderhouse.session.seven.business.CalculatorService;
import com.coderhouse.session.seven.business.domain.OperationResult;
import com.coderhouse.session.seven.business.exceptions.InvalidMathematicalOperationResultException;
import com.coderhouse.session.seven.business.exceptions.MathematicalOperationNotSupportedException;
import com.coderhouse.session.seven.business.exceptions.MathematicalOperationNotValidException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CalculatorRestControllerTest {

    @InjectMocks
    CalculatorRestController calculatorRestController;

    @Mock
    CalculatorService calculatorService;

    @Test
    void testValidateOperation_ShouldDoNothing_WhenCallingServiceFunction() throws MathematicalOperationNotSupportedException, MathematicalOperationNotValidException, InvalidMathematicalOperationResultException {


        OperationResult operationResult = mock(OperationResult.class);
        /*OperationResult operationResult1 = mock(OperationResult.class);
        OperationResult operationResult2 = mock(OperationResult.class);
        OperationResult operationResult3 = mock(OperationResult.class);
        OperationResult operationResult4 = mock(OperationResult.class);*/

        doNothing().when(this.calculatorService).validate(operationResult);
        //when(this.calculatorService.validate(operationResult).thenReturn(true);
        //doNothing().when(this.calculatorService).validate(eq(operationResult));
        //any(), nullable()

        this.calculatorRestController.validateOperation(operationResult);

        verify(this.calculatorService, times(1)).validate(operationResult);
    }
}