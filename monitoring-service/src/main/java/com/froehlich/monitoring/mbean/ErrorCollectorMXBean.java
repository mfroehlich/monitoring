package com.froehlich.monitoring.mbean;

import java.util.Collection;
import java.util.List;

import com.froehlich.commons.monitoring.entity.ErrorEntry;

/**
 * Created by mfroehlich on 13.11.2014.
 */
public interface ErrorCollectorMXBean {

    public static final String OBJECTNAME = "com.froehlich.resources.resource:server=ErrorCollector";

    public List<String> getCollectedErrorEntries();

}
