package com.froehlich.monitoring.service;

import com.froehlich.commons.monitoring.entity.ErrorEntry;
import com.froehlich.commons.monitoring.service.ErrorCollectorService;
import com.froehlich.monitoring.util.ExceptionPrinter;
import org.slf4j.Logger;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by mfroehlich on 06.12.2014.
 */
@Singleton
public class ErrorBroadcastingBean {

    @Inject
    private Logger logger;

    @Inject
    private ErrorCollectorService errorCollectorService;

    @Inject
    private ExceptionPrinter exceptionPrinter;

    @Schedule(hour = "*", minute = "*", second = "*/30", persistent = false)
    public void broadcastErrorsToRecipients() {

        logger.debug("Broadcasting all collected errors.");
        Collection<ErrorEntry> errors = errorCollectorService.getAndResetErrors();
        logger.debug("Collected " + errors.size() + " errors by now. Broadcasting and resetting them.");

        if (errors != null && errors.isEmpty() == false) {
            for (ErrorEntry error : errors) {
                broadcastErrorEntry(error);
            }
        }
    }

    /**
     * Sendet den �bergebenen ErrorEntry an die Empf�nger (derzeit die Konsole).
     * @param errorEntry
     */
    private void broadcastErrorEntry(ErrorEntry errorEntry) {
        Throwable error = errorEntry.getError();
        StringBuilder errorStr = exceptionPrinter.getErrorString(error, true);

        LocalDateTime errorTimestamp = errorEntry.getErrorTimestamp();
        logger.debug("An error occurred at " + errorTimestamp + ": " + "\n" + errorStr);
    }
}
