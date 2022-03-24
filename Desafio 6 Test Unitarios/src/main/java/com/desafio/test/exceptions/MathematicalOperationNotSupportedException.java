package com.desafio.test.exceptions;

public class MathematicalOperationNotSupportedException extends Throwable {
    public MathematicalOperationNotSupportedException(String message) {
        super(message);
    }
}
