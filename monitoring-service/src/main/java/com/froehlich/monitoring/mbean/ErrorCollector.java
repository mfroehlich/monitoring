package com.froehlich.monitoring.mbean;

import com.froehlich.commons.monitoring.service.ErrorCollectorService;
import com.froehlich.commons.monitoring.entity.ErrorEntry;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by mfroehlich on 13.11.2014.
 */
public class ErrorCollector implements ErrorCollectorMXBean {

    private ErrorCollectorService errorCollectorService;

    public ErrorCollector(ErrorCollectorService errorCollectorService) {
        this.errorCollectorService = errorCollectorService;
    }

    public List<String> getCollectedErrorEntries() {
        List<String> errorEntries = new ArrayList<>();

        for (ErrorEntry entry : errorCollectorService.getErrors()) {
            errorEntries.add(entry.toString());
        }

        return errorEntries;
    }
}
