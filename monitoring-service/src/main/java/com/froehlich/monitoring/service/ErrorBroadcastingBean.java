package com.froehlich.monitoring.service;

import com.froehlich.commons.monitoring.entity.ErrorEntry;
import com.froehlich.commons.monitoring.service.ErrorCollectorService;
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
     * TODO mfroehlich to be implemented completely
     * @param errorEntry
     */
    private void broadcastErrorEntry(ErrorEntry errorEntry) {
        Throwable error = errorEntry.getError();
        LocalDateTime errorTimestamp = errorEntry.getErrorTimestamp();
        logger.debug("An error occurred at " + errorTimestamp + ": " + error);
    }
}
