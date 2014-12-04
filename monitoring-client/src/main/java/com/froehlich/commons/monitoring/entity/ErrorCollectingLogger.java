package com.froehlich.commons.monitoring.entity;

import com.froehlich.commons.monitoring.service.ErrorCollectorService;
import org.slf4j.Logger;
import org.slf4j.Marker;

/**
 * Created by mfroehlich on 13.11.2014.
 */
public class ErrorCollectingLogger implements Logger {

    private Logger loggerDelegate;
    private ErrorCollectorService errorCollectorService;

    public ErrorCollectingLogger(Logger logger, ErrorCollectorService errorCollectorService) {
        this.loggerDelegate = logger;
        this.errorCollectorService = errorCollectorService;
    }

    @Override
    public String getName() {

        return loggerDelegate.getName();
    }

    @Override
    public boolean isTraceEnabled() {

        return loggerDelegate.isTraceEnabled();
    }

    @Override
    public void trace(String s) {

        loggerDelegate.trace(s);
    }

    @Override
    public void trace(String s, Object o) {

        loggerDelegate.trace(s, o);
    }

    @Override
    public void trace(String s, Object o, Object o2) {

        loggerDelegate.trace(s, o, o2);
    }

    @Override
    public void trace(String s, Object... objects) {

        loggerDelegate.trace(s, objects);
    }

    @Override
    public void trace(String s, Throwable throwable) {

        loggerDelegate.trace(s, throwable);
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return loggerDelegate.isTraceEnabled(marker);
    }

    @Override
    public void trace(Marker marker, String s) {

        loggerDelegate.trace(marker, s);
    }

    @Override
    public void trace(Marker marker, String s, Object o) {

        loggerDelegate.trace(marker, s, o);
    }

    @Override
    public void trace(Marker marker, String s, Object o, Object o2) {

        loggerDelegate.trace(marker, s, o, o2);
    }

    @Override
    public void trace(Marker marker, String s, Object... objects) {

        loggerDelegate.trace(marker, s, objects);
    }

    @Override
    public void trace(Marker marker, String s, Throwable throwable) {

        loggerDelegate.trace(marker, s, throwable);
    }

    @Override
    public boolean isDebugEnabled() {
        return loggerDelegate.isDebugEnabled();
    }

    @Override
    public void debug(String s) {

        loggerDelegate.debug(s);
    }

    @Override
    public void debug(String s, Object o) {

        loggerDelegate.debug(s, o);
    }

    @Override
    public void debug(String s, Object o, Object o2) {

        loggerDelegate.debug(s, o, o2);
    }

    @Override
    public void debug(String s, Object... objects) {

        loggerDelegate.debug(s, objects);
    }

    @Override
    public void debug(String s, Throwable throwable) {

        loggerDelegate.debug(s, throwable);
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return loggerDelegate.isDebugEnabled(marker);
    }

    @Override
    public void debug(Marker marker, String s) {

        loggerDelegate.debug(marker, s);
    }

    @Override
    public void debug(Marker marker, String s, Object o) {

        loggerDelegate.debug(marker, s, o);
    }

    @Override
    public void debug(Marker marker, String s, Object o, Object o2) {

        loggerDelegate.debug(marker, s, o, o2);
    }

    @Override
    public void debug(Marker marker, String s, Object... objects) {

        loggerDelegate.debug(marker, s, objects);
    }

    @Override
    public void debug(Marker marker, String s, Throwable throwable) {

        loggerDelegate.debug(marker, s, throwable);
    }

    @Override
    public boolean isInfoEnabled() {
        return loggerDelegate.isInfoEnabled();
    }

    @Override
    public void info(String s) {

        loggerDelegate.info(s);
    }

    @Override
    public void info(String s, Object o) {

        loggerDelegate.info(s, o);
    }

    @Override
    public void info(String s, Object o, Object o2) {

        loggerDelegate.info(s, o, o2);
    }

    @Override
    public void info(String s, Object... objects) {

        loggerDelegate.info(s, objects);
    }

    @Override
    public void info(String s, Throwable throwable) {

        loggerDelegate.info(s, throwable);
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return loggerDelegate.isInfoEnabled(marker);
    }

    @Override
    public void info(Marker marker, String s) {

        loggerDelegate.info(marker, s);
    }

    @Override
    public void info(Marker marker, String s, Object o) {

        loggerDelegate.info(marker, s, o);
    }

    @Override
    public void info(Marker marker, String s, Object o, Object o2) {

        loggerDelegate.info(marker, s, o, o2);
    }

    @Override
    public void info(Marker marker, String s, Object... objects) {

        loggerDelegate.info(marker, s, objects);
    }

    @Override
    public void info(Marker marker, String s, Throwable throwable) {

        loggerDelegate.info(marker, s, throwable);
    }

    @Override
    public boolean isWarnEnabled() {
        return loggerDelegate.isWarnEnabled();
    }

    @Override
    public void warn(String s) {

        loggerDelegate.warn(s);
    }

    @Override
    public void warn(String s, Object o) {

        loggerDelegate.warn(s, o);
    }

    @Override
    public void warn(String s, Object... objects) {

        loggerDelegate.warn(s, objects);
    }

    @Override
    public void warn(String s, Object o, Object o2) {

        loggerDelegate.warn(s, o, o2);
    }

    @Override
    public void warn(String s, Throwable throwable) {

        loggerDelegate.warn(s, throwable);
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return loggerDelegate.isWarnEnabled(marker);
    }

    @Override
    public void warn(Marker marker, String s) {

        loggerDelegate.warn(marker, s);
    }

    @Override
    public void warn(Marker marker, String s, Object o) {

        loggerDelegate.warn(marker, s, o);
    }

    @Override
    public void warn(Marker marker, String s, Object o, Object o2) {

        loggerDelegate.warn(marker, s, o, o2);
    }

    @Override
    public void warn(Marker marker, String s, Object... objects) {

        loggerDelegate.warn(marker, s, objects);
    }

    @Override
    public void warn(Marker marker, String s, Throwable throwable) {

        loggerDelegate.warn(marker, s, throwable);
    }

    @Override
    public boolean isErrorEnabled() {
        return loggerDelegate.isErrorEnabled();
    }

    @Override
    public void error(String s) {

        loggerDelegate.error(s);
    }

    @Override
    public void error(String s, Object o) {

        loggerDelegate.error(s, o);
    }

    @Override
    public void error(String s, Object o, Object o2) {

        loggerDelegate.error(s, o, o2);
    }

    @Override
    public void error(String s, Object... objects) {

        loggerDelegate.error(s, objects);
    }

    @Override
    public void error(String s, Throwable throwable) {

        errorCollectorService.receiveError(throwable);
        loggerDelegate.error(s, throwable);
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return loggerDelegate.isErrorEnabled(marker);
    }

    @Override
    public void error(Marker marker, String s) {

        loggerDelegate.error(marker, s);
    }

    @Override
    public void error(Marker marker, String s, Object o) {

        loggerDelegate.error(marker, s, o);
    }

    @Override
    public void error(Marker marker, String s, Object o, Object o2) {

        loggerDelegate.error(marker, s, o, o2);
    }

    @Override
    public void error(Marker marker, String s, Object... objects) {

        loggerDelegate.error(marker, s, objects);
    }

    @Override
    public void error(Marker marker, String s, Throwable throwable) {

        errorCollectorService.receiveError(throwable);
        loggerDelegate.error(marker, s, throwable);
    }
}
