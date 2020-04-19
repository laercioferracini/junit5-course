package br.com.ferracini.patientintake;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ClinicCalendarShould {
    ClinicCalendar calendar;

    @BeforeEach
    void beforeEach() {
        calendar = new ClinicCalendar(LocalDate.now());
    }

    @Test
    void allowEntryOfAnAppointment() {
        ClinicCalendar calendar = new ClinicCalendar(LocalDate.now());
        String firsName = "Jim";
        String lastName = "Weaver";
        String doctor = "avery";
        String when = "09/01/2020 2:00 pm";
        calendar.addAppointment(firsName, lastName, doctor,
                when);
        List<PatientAppointment> appointmentList = calendar.getAppointments();
        assertNotNull(appointmentList);
        assertEquals(1, appointmentList.size());
        PatientAppointment enteredAppt = appointmentList.get(0);
        assertAll("Checking entry an appointment",
                () -> assertEquals(firsName, enteredAppt.getPatientFirstName()),
                () -> assertEquals(lastName, enteredAppt.getPatientLastName()),
                () -> assertSame(Doctor.avery, enteredAppt.getDoctor()),
                () -> assertEquals("9/1/2020 2:00 PM",
                        enteredAppt.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy h:mm a"))));

    }

    @Test
    void returnTrueForHasAppointmentIfThereAreAppointments() {
        ClinicCalendar calendar = new ClinicCalendar(LocalDate.now());
        calendar.addAppointment("Jim", "Weaver", "avery", "04/15/2020 8:00 am");
        assertTrue(calendar.hasAppointment(LocalDate.of(2020, 4, 15)));
    }

    @Test
    void returnFalseForHasAppointmentIfThereAreNoAppointments() {
        ClinicCalendar calendar = new ClinicCalendar(LocalDate.now());

        assertFalse(calendar.hasAppointment(LocalDate.of(2020, 4, 15)));
    }

    @Test
    void returnCurrentDaysAppointments() {

        calendar.addAppointment("Jim", "Weaver", "avery",
                LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")).concat(" 8:00 am"));
        calendar.addAppointment("Jim", "Weaver", "avery",
                LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")).concat(" 9:00 am"));
        calendar.addAppointment("Jim", "Weaver", "avery",
                LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("MM/dd/yyyy")).concat(" 7:00 am"));
        assertEquals(2, calendar.getTodayAppointments().size());
    }

}