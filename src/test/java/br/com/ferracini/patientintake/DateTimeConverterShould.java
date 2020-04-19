package br.com.ferracini.patientintake;

import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author lferracini
 * @project = course-junit5
 * @since <pre>18/04/2020</pre>
 */
@Tag("dateTimeConvert")
@DisplayName("DateTimeConverter should")
class DateTimeConverterShould {

    @Nested
    @DisplayName("convert string with 'today' keyword")
    class TodayTest {
        @Test
        @DisplayName("correctly")
        void convertTodayStringCorrectly() {
            LocalDate today = LocalDate.of(2020, 4, 18);
            LocalDateTime result = DateTimeConverter.convertStringToDateTime("today 1:00 pm",
                    today);
            assertEquals(result, LocalDateTime.of(2020, 4, 18, 13, 0),
                    () -> "Failed to convert 'today' string to expected date time, today passed was: " + today);
        }

        @Test
        @DisplayName("regardless of case")
        void convertTodayStringCorrectlyCaseInsensitive() {
            LocalDate today = LocalDate.of(2020, 4, 18);
            LocalDateTime result = DateTimeConverter.convertStringToDateTime("ToDay 1:00 pm",
                    today);
            assertEquals(result, LocalDateTime.of(2020, 4, 18, 13, 0),
                    () -> "Failed to convert 'today' string to expected date time, today passed was: " + today);
        }

    }

    @Test
    @DisplayName("convert expected date time pattern in string correctly")
    void convertCorrectPatternToDateTime() {
        LocalDateTime result = DateTimeConverter.convertStringToDateTime("4/18/2020 1:00 pm",
                LocalDate.of(2020, 4, 18));
        assertEquals(result, LocalDateTime.of(2020, 4, 18, 13, 0));
    }

    @Test
    @DisplayName("throw exception if entered pattern of string incorrect")
    void throwExceptionIfIncorrectPatternProvided() {

        Throwable error = assertThrows(RuntimeException.class, () ->
                DateTimeConverter.convertStringToDateTime("4/18/2020 100 pm",
                        LocalDate.of(2020, 4, 18)));
        assertEquals("Unable to create date time from: " +
                "[4/18/2020 100 pm], please enter with format [M/d/yyyy h:mm a], " +
                "Text '4/18/2020 100 PM' could not be parsed at index 13", error.getMessage());

    }

    @Test
    @Disabled
    @DisplayName("example of test disabled")
    void testDisabled() {
        for (int i = 2021; i < 2022; i++) {
            System.out.println("@Test\n" +
                    "    @DisplayName(\"convert string with 'today' keyword correctly regardless of case" + i + "\")\n" +
                    "    void convertTodayStringCorrectlyCaseInsensitive" + i + "() {\n" +
                    "        LocalDate today = LocalDate.of(" + i + ", 4, 18);\n" +
                    "        LocalDateTime result = DateTimeConverter.convertStringToDateTime(\"ToDay 1:00 pm\",\n" +
                    "                today);\n" +
                    "        assertEquals(result, LocalDateTime.of(" + i + ", 4, 18, 13, 0),\n" +
                    "                \"Failed to convert 'today' string to expected date time, today passed was: \" + today);\n" +
                    "    }");
        }
    }
}