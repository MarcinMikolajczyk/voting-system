package com.marcin.voting.exeptions;

import java.time.LocalDateTime;

public class JPAObjectNotFoundException extends RuntimeException {

    private LocalDateTime exceptionTime;

    public LocalDateTime getExceptionTime() {
        return this.exceptionTime;
    }

    public JPAObjectNotFoundException(String params, String values) {
        super("Could not found object with params (" + params + ") = (" + values    + ").");
        this.exceptionTime = LocalDateTime.now();
    }
}
