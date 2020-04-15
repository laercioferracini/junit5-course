package br.com.ferracini.patientintake;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ClinicMain {

    private static ClinicCalendar calendar;

    public static void main(String[] args) {
        calendar = new ClinicCalendar(LocalDate.now());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the patient Intake Computer System!\n\n");
        String lastOption = "";
        while (!lastOption.equalsIgnoreCase("x")) {
            lastOption = displayMenu(scanner);
        }
        System.out.println("\nExiting system...\n");
    }

    private static String displayMenu(Scanner scanner) {

        System.out.println("Please select an option:");
        System.out.println("1. Enter a Patient Appointment");
        System.out.println("2. View All Appointments");
        System.out.println("X. Exit System.");
        System.out.println("Option: ");
        String option = scanner.next();

        switch (option) {
            case "1":
                performPatientEntry(scanner);
                return option;
            case "2":
                performAllAppointments();
                return option;
            default:
                System.out.println("Invalid option, please re-enter.");
                return option;
        }
    }

    private static void performPatientEntry(Scanner scanner) {
        scanner.nextLine();
        System.out.println("\n\nPlease Enter Appointment Info:");
        System.out.print(" Patient Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print(" Patient First Name: ");
        String firstName = scanner.nextLine();
        System.out.print(" Appointment Date (M/d/yyyy h:m a): ");
        String when = scanner.nextLine();
        System.out.print(" Doctor Last Name: ");
        String doc = scanner.nextLine();
        try {
            calendar.addAppointment(firstName, lastName, doc, when);
        } catch (Throwable e) {
            System.out.println("Error! " + e.getMessage());
            return;
        }
        System.out.println("Patient entered successfully.\n\n");
    }

    private static void performAllAppointments() {
        System.out.println("\n\nAllAppointments in Systema:");
        for (PatientAppointment appointment : calendar.getAppointments()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a");
            String apptTime = formatter.format(appointment.getAppointmentDateTime());
            System.out.println(String.format("%s: %s, %s \t\tDoctor: %s", apptTime, appointment.getPatientLastName(),
                    appointment.getPatientFirstName(), appointment.getDoctor().getName()));
        }
        System.out.println("\nPress any key to continue...");
    }
}
