package br.com.ferracini.patientintake;

import java.time.LocalDate;

/**
 * @author lferracini
 * @project = course-junit5
 * @since <pre>25/04/2020</pre>
 */
public class Person {
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate dateOfBirth;

    public Person(String firstName, String lastName, Gender gender, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
