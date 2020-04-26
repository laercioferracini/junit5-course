package br.com.ferracini.patientintake.notifier;

/**
 * @author lferracini
 * @project = course-junit5
 * @since <pre>19/04/2020</pre>
 */
public interface EmailNotifier {
    void sendNotification(String subject, String body, String address);
}
