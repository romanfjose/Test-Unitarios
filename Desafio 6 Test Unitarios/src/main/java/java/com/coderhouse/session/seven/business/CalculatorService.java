package com.coderhouse.session.seven.business;

import com.coderhouse.session.seven.business.domain.Operation;
import com.coderhouse.session.seven.business.domain.OperationResult;
import com.coderhouse.session.seven.business.domain.Operator;
import com.coderhouse.session.seven.business.exceptions.InvalidMathematicalOperationResultException;
import com.coderhouse.session.seven.business.exceptions.MathematicalOperationNotSupportedException;
import com.coderhouse.session.seven.business.exceptions.MathematicalOperationNotValidException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public OperationResult calculate(Operation operation) throws MathematicalOperationNotValidException, MathematicalOperationNotSupportedException {
        if (Operator.ADD.equals(operation.getOperator())) {
            return this.add(operation.getLeft(), operation.getRight());
        } else if (Operator.DIFFERENCE.equals(operation.getOperator())) {
            return this.difference(operation.getLeft(), operation.getRight());
        } else if (Operator.MULTIPLY.equals(operation.getOperator())) {
            return this.multiply(operation.getLeft(), operation.getRight());
        } else if (Operator.DIVIDE.equals(operation.getOperator())) {
            if (operation.getRight() == 0.0) {
                throw new MathematicalOperationNotValidException("Trying to perform division against 0");
            }
            return this.divide(operation.getLeft(), operation.getRight());
        }
        throw new MathematicalOperationNotSupportedException("We only support ADD/DIFFERENCE/MULTIPLY/DIVIDE operations");
    }

    private OperationResult divide(Double left, Double right) {
        return new OperationResult(left, Operator.DIVIDE, right, left / right);
    }

    private OperationResult difference(Double left, Double right) {
        return new OperationResult(left, Operator.DIFFERENCE, right, left - right);
    }

    private OperationResult add(Double left, Double right) {
        return new OperationResult(left, Operator.ADD, right, left + right);
    }

    private OperationResult multiply(Double left, Double right) {
        return new OperationResult(left, Operator.MULTIPLY, right, left * right);
    }

    public void validate(OperationResult operation) throws MathematicalOperationNotSupportedException, MathematicalOperationNotValidException, InvalidMathematicalOperationResultException {
        Operation previousOperation = new Operation(operation.getLeft(), operation.getOperator(), operation.getRight());

        Double realResult = this.calculate(previousOperation).getResult();

        if (!operation.getResult().equals(realResult)) {
            throw new InvalidMathematicalOperationResultException(String.format("We were expecting as a result %f, but you gave to us %f", realResult, operation.getResult()));
        }
    }
}
