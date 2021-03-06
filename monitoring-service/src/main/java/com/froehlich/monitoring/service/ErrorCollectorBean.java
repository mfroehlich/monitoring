package com.froehlich.monitoring.service;

/**
 * Created by mfroehlich on 21.11.2014.
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.froehlich.commons.monitoring.entity.ErrorEntry;
import com.froehlich.commons.monitoring.service.ErrorCollectorService;
import com.froehlich.monitoring.mbean.ErrorCollector;
import com.froehlich.monitoring.mbean.ErrorCollectorMXBean;
import com.froehlich.utils.date.CurrentTimeService;
import com.froehlich.utils.mbeans.MBeanRegistrator;

@Singleton
@ApplicationScoped
@Startup
public class ErrorCollectorBean implements ErrorCollectorService {

    @Inject
    private MBeanRegistrator mBeanRegistrator;

    @Inject
    private CurrentTimeService currentTimeService;

    private ErrorCollectorMXBean mbean;

    private List<ErrorEntry> errorEntries;

    @PostConstruct
    public void init() {
        errorEntries = new ArrayList<>();

        if (mbean == null){
            synchronized (ErrorCollectorBean.class) {
                if (mbean == null) {
                    mbean = new ErrorCollector(this);
                    mBeanRegistrator.registerMBean(ErrorCollectorMXBean.OBJECTNAME, mbean);
                }
            }
        }
    }

    public void receiveError(Throwable e) {
        ErrorEntry entry = new ErrorEntry(e, currentTimeService.now());
        errorEntries.add(entry);
    }

    @Override
    public Collection<ErrorEntry> getErrors() {
        return errorEntries;
    }

    public Collection<ErrorEntry> getAndResetErrors() {
        Collection<ErrorEntry> errors = new ArrayList<>(getErrors());
        errorEntries.clear();
        return errors;
    }
}
