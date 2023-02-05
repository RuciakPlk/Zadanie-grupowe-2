package org.example.Exception;

public class IllegalAmountOfBreadException extends Exception {
    public IllegalAmountOfBreadException() {
        super();
    }

    public IllegalAmountOfBreadException(String message) {
        super(message);
    }

    public IllegalAmountOfBreadException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalAmountOfBreadException(Throwable cause) {
        super(cause);
    }

    public IllegalAmountOfBreadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
