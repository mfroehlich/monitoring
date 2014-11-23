package de.bucher.commons.monitoring.mbean;

import java.util.Collection;
import java.util.List;

import de.bucher.commons.monitoring.entity.ErrorEntry;

/**
 * Created by mfroehlich on 13.11.2014.
 */
public interface ErrorCollectorMXBean {

    public static final String OBJECTNAME = "de.bucher.stada.resources.resource:server=ErrorCollector";

    public List<String> getCollectedErrorEntries();

}
