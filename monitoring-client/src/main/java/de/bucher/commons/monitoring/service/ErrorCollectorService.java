package de.bucher.commons.monitoring.service;

import java.util.Collection;

import de.bucher.commons.monitoring.entity.ErrorEntry;

/**
 * Created by mfroehlich on 21.11.2014.
 */

public interface ErrorCollectorService {

    public void receiveError(Throwable e);

    public Collection<ErrorEntry> getErrors();
}
