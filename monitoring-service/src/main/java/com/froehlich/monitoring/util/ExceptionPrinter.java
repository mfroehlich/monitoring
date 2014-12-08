package com.froehlich.monitoring.util;

/**
 * Created by mfroehlich on 08.12.2014.
 */
public class ExceptionPrinter {

    private String[] OWN_PACKAGES = new String[] { "com.froehlich" };

    public StringBuilder getErrorString(Throwable thr, boolean ownPackagesOnly) {

        StringBuilder errorStr = new StringBuilder();
        errorStr.append(thr.getClass().getName()).append(": ");
        errorStr.append(thr.getMessage());
        errorStr.append(System.lineSeparator());

        StackTraceElement[] stackTraceElements = thr.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            boolean displayStackTraceElement = ownPackagesOnly == false;
            if (ownPackagesOnly) {
                String stackTracePackage = stackTraceElement.getClassName();
                for (String ownPackageString : OWN_PACKAGES) {
                    if (stackTracePackage.startsWith(ownPackageString)) {
                        displayStackTraceElement = true;
                        break;
                    }
                }
            }

            if (displayStackTraceElement) {
                errorStr.append("       at ").append(stackTraceElement);
                errorStr.append(System.lineSeparator());
            }
        }

        Throwable errorCause = thr.getCause();
        if (errorCause != null) {
            StringBuilder causeErrorString = getErrorString(errorCause, ownPackagesOnly);
            errorStr.append("Caused by: ");
            errorStr.append(causeErrorString);
        }

        return errorStr;
    }
}
