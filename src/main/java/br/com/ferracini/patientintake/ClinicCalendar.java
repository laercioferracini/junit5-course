package br.com.ferracini.patientintake;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ClinicCalendar {

    private List<PatientAppointment> appointments;
    private LocalDate today;

    public ClinicCalendar(LocalDate today) {
        this.today = today;
        this.appointments = new ArrayList<>();
    }

    public void addAppointment(String patientFirstName, String patientLastName, String doctorKey, String dateTime) {
        Doctor doc = Doctor.valueOf(doctorKey.toLowerCase());
        LocalDateTime localDateTime = convertToDateTimeFromString(dateTime);
        PatientAppointment appointment = new PatientAppointment(patientFirstName, patientLastName,
                localDateTime, doc);
        appointments.add(appointment);
    }

    private LocalDateTime convertToDateTimeFromString(String dateTime) {
        LocalDateTime localDateTime;
        try {
            localDateTime = LocalDateTime.parse(dateTime.toUpperCase(),
                    DateTimeFormatter.ofPattern("M/d/yyyy h:mm a", Locale.US));
        } catch (Throwable t) {
            throw new RuntimeException("Unable to create date time from:[" +
                    dateTime.toUpperCase() + "], please enter with format [M/d/yyyy h:mm a]");
        }
        return localDateTime;
    }

    public List<PatientAppointment> getAppointments() {
        return this.appointments;
    }

    public List<PatientAppointment> getTodayAppointments() {
        return appointments.stream()
                .filter(appt -> appt.getAppointmentDateTime().toLocalDate().equals(today))
                .collect(Collectors.toList());
    }

    public boolean hasAppointment(LocalDate date) {
        return appointments.stream()
                .anyMatch(appt -> appt.getAppointmentDateTime().toLocalDate().equals(date));
    }
}
