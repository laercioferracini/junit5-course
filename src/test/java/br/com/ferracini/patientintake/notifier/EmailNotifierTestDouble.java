package br.com.ferracini.patientintake.notifier;

import br.com.ferracini.patientintake.notifier.EmailNotifier;

import java.util.ArrayList;

/**
 * @author lferracini
 * @project = course-junit5
 * @since <pre>26/04/2020</pre>
 */
public class EmailNotifierTestDouble implements EmailNotifier {

    ArrayList<Message> receivedMessages = new ArrayList<>();

    @Override
    public void sendNotification(String subject, String body, String address) {
        receivedMessages.add(new Message(subject, body, address));
    }

    public class Message {
        public String toAddress;
        public String subject;
        public String body;

        public Message (String subject, String body, String address) {
            this.subject = subject;
            this.body = body;
            this.toAddress = address;
        }
    }
}
