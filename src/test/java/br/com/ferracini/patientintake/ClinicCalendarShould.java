package br.com.ferracini.patientintake;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClinicCalendarShould {

    @Test
    void allowEntryOfAnAppointment() {
        ClinicCalendar calendar = new ClinicCalendar();
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
        assertEquals(firsName, enteredAppt.getPatientFirstName());
        assertEquals(lastName, enteredAppt.getPatientLastName());
        assertEquals(Doctor.avery, enteredAppt.getDoctor());
        assertEquals("9/1/2020 2:00 PM",
                enteredAppt.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy h:mm a")));

    }
}