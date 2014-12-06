package com.froehlich.commons.monitoring.entity;

import java.time.LocalDateTime;

/**
 * Created by mfroehlich on 13.11.2014.
 */
public class ErrorEntry {

    private Throwable throwable;
    private LocalDateTime errorTimestamp;

    public ErrorEntry(Throwable throwable, LocalDateTime errorTimestamp) {
        this.throwable = throwable;
        this.errorTimestamp = errorTimestamp;
    }

    public Throwable getError() {
        return throwable;
    }

    public LocalDateTime getErrorTimestamp() {
        return errorTimestamp;
    }

    @Override
    public String toString() {
        return throwable.toString();
    }
}
