package de.bucher.commons.monitoring.entity;

/**
 * Created by mfroehlich on 13.11.2014.
 */
public class ErrorEntry {
    private Throwable throwable;

    public ErrorEntry(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public String toString() {
        return throwable.toString();
    }
}
