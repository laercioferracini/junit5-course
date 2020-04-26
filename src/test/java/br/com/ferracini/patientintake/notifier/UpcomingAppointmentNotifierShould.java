package br.com.ferracini.patientintake.notifier;

import br.com.ferracini.patientintake.ClinicCalendar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author lferracini
 * @project = course-junit5
 * @since <pre>26/04/2020</pre>
 */
@DisplayName("Upcomming appointments notifier should")
class UpcomingAppointmentNotifierShould {

    private EmailNotifierTestDouble aDouble;

    @BeforeEach
    void init() {
        aDouble = new EmailNotifierTestDouble();
    }

    @Test
    @DisplayName("send message with body")
    void sendNotificationWithCorrectFormat() {
        ClinicCalendar calendar = new ClinicCalendar(LocalDate.of(2018, 8, 26));
        calendar.addAppointment("Jim", "Weaver", "avery",
                "08/27/2018 2:00 pm");

        UpcomingAppointmentNotifier notifier = new UpcomingAppointmentNotifier(calendar, aDouble);
        notifier.run();

        assertEquals(1, aDouble.receivedMessages.size());
        EmailNotifierTestDouble.Message expectedMessage = aDouble.receivedMessages.get(0);
        assertAll(
                () -> assertEquals("weaverjim@mail.com", expectedMessage.toAddress),
                () -> assertEquals("Appointment Reminder", expectedMessage.subject),
                () -> assertEquals("You have an appointment tomorrow at 2:00 PM" +
                        " with Dr. Ralph Avery.", expectedMessage.body)
        );
    }

}