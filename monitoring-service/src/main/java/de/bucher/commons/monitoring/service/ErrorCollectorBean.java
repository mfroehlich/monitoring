package de.bucher.commons.monitoring.service;

/**
 * Created by mfroehlich on 21.11.2014.
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import de.bucher.commons.mbean.MBeanRegistrator;
import de.bucher.commons.monitoring.entity.ErrorEntry;
import de.bucher.commons.monitoring.mbean.ErrorCollector;
import de.bucher.commons.monitoring.mbean.ErrorCollectorMXBean;

@Singleton
@ApplicationScoped
public class ErrorCollectorBean implements ErrorCollectorService {

    @Inject
    private MBeanRegistrator mBeanRegistrator;

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
        ErrorEntry entry = new ErrorEntry(e);
        errorEntries.add(entry);
    }

    @Override
    public Collection<ErrorEntry> getErrors() {
        return errorEntries;
    }
}
