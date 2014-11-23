package de.bucher.commons.monitoring.mbean;

import de.bucher.commons.monitoring.service.ErrorCollectorService;
import de.bucher.commons.monitoring.entity.ErrorEntry;

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

    /*private void sendMailToProdynaToInformAboutError(Long spodbVorgangId, Exception ex) {

        String errorMsg = "Undefiniertes Problem beim Konvertieren der SPO zu einem EKMS-Vertrag";
        if (ex instanceof OldDataPersistenceException) {
            errorMsg = "Fehler beim Erzeugen des Kontaktdaten-Objekts oder dem Speichern des SPOVorgangs.";
        } else if (ex instanceof HibernateException) {
            errorMsg = "Hibernate Problem beim Bearbeiten des SPOVorgangs";
        } else if (ex instanceof SPOEKMSConverterException) {
            errorMsg = "Problem bei der Validierung der SPO.";
        } else if (ex instanceof LDAPException) {
            errorMsg = "Problem mit dem LDAP";
        } else if (ex instanceof DocumentException || ex instanceof IOException) {
            errorMsg = "Probleme bei der PDF-Generierung";
        } else if (ex instanceof EmailValidationException || ex instanceof MessagingException) {
            errorMsg = "Probleme beim E-Mail Versand";
        }

        try {
            spoMailService.mailProdynaSPOEKMS(spodbVorgangId, errorMsg, ex);
        } catch (Exception e1) {
            LOGGER.error("Konnte keine Fehler-Mail an Prodyna versenden.", e1);
        }
    }*/
}
