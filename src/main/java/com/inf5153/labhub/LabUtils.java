package com.inf5153.labhub;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import com.inf5153.exam.composite.CompositeExamType;
import com.inf5153.exam.elementary.ElementaryExamType;

/**
 * Utility class for managing laboratories and appointment-related operations.
 */
public class LabUtils {

    /**
     * Initializes a list of laboratories with predefined details.
     *
     * @return The list of initialized laboratories
     */
    protected static List<Laboratory> initializeLaboratories() {
        List<Laboratory> laboratories = new ArrayList<>();

        Laboratory lab1 = new Laboratory("LAB001", "Lab 1", "123 Main St", "555-1234", "contact@lab1.com",
                Arrays.asList(ElementaryExamType.URINE.getDisplayName(),
                        ElementaryExamType.BLOOD.getDisplayName()));
        Laboratory lab2 = new Laboratory("LAB002", "Lab 2", "456 West St", "555-5678", "contact@lab2.com",
                Arrays.asList(ElementaryExamType.XRAY.getDisplayName(),
                        ElementaryExamType.ULTRASOUND.getDisplayName()));
        Laboratory lab3 = new Laboratory("LAB003", "Lab 3", "789 East St", "555-9876", "contact@lab3.com",
                Arrays.asList(ElementaryExamType.MRI.getDisplayName(),
                        ElementaryExamType.ENDOSCOPY.getDisplayName()));
        Laboratory lab4 = new Laboratory("LAB004", "Lab 4", "321 North St", "555-4321", "contact@lab4.com",
                Arrays.asList(ElementaryExamType.MYELO.getDisplayName(),
                        ElementaryExamType.ULTRASOUND.getDisplayName()));
        Laboratory lab5 = new Laboratory("LAB005", "Lab 5", "654 South St", "555-8765", "contact@lab5.com",
                Arrays.asList(ElementaryExamType.BLOOD.getDisplayName(),
                        ElementaryExamType.XRAY.getDisplayName()));
        Laboratory lab6 = new Laboratory("LAB006", "Lab 6", "123 North St", "555-6789", "contact@lab6.com",
                Arrays.asList(ElementaryExamType.ENDOSCOPY.getDisplayName(),
                        ElementaryExamType.URINE.getDisplayName()));
        Laboratory lab7 = new Laboratory("LAB007", "Lab 7", "456 East St", "555-7890", "contact@lab7.com",
                Arrays.asList(ElementaryExamType.MRI.getDisplayName(),
                        ElementaryExamType.BLOOD.getDisplayName()));
        Laboratory lab8 = new Laboratory("LAB008", "Lab 8", "789 South St", "555-8901", "contact@lab8.com",
                Arrays.asList(ElementaryExamType.MYELO.getDisplayName(),
                        ElementaryExamType.XRAY.getDisplayName()));
        Laboratory lab9 = new Laboratory("LAB009", "Lab 9", "321 West St", "555-9012", "contact@lab9.com",
                Arrays.asList(ElementaryExamType.ULTRASOUND.getDisplayName(),
                        ElementaryExamType.BLOOD.getDisplayName()));
        Laboratory lab10 = new Laboratory("LAB010", "Lab 10", "654 East St", "555-0123", "contact@lab10.com",
                Arrays.asList(ElementaryExamType.XRAY.getDisplayName(),
                        ElementaryExamType.ENDOSCOPY.getDisplayName()));
        Laboratory lab11 = new Laboratory("LAB011", "Lab 11", "321 South St", "555-5432", "contact@lab11.com",
                Arrays.asList(CompositeExamType.ANEMIA.getDisplayName(),
                        CompositeExamType.THYROID.getDisplayName()));
        Laboratory lab12 = new Laboratory("LAB012", "Lab 12", "654 North St", "555-6543", "contact@lab12.com",
                Arrays.asList(CompositeExamType.ANEMIA.getDisplayName(),
                        ElementaryExamType.MYELO.getDisplayName()));
        Laboratory lab13 = new Laboratory("LAB013", "Lab 13", "123 West St", "555-7654", "contact@lab13.com",
                Arrays.asList(ElementaryExamType.URINE.getDisplayName(),
                        CompositeExamType.THYROID.getDisplayName()));
        Laboratory lab14 = new Laboratory("LAB014", "Lab 14", "456 North St", "555-8765", "contact@lab14.com",
                Arrays.asList(ElementaryExamType.XRAY.getDisplayName(),
                        ElementaryExamType.ENDOSCOPY.getDisplayName()));
        Laboratory lab15 = new Laboratory("LAB015", "Lab 15", "789 North St", "555-9876", "contact@lab15.com",
                Arrays.asList(ElementaryExamType.MRI.getDisplayName(),
                        CompositeExamType.ANEMIA.getDisplayName()));

        laboratories.addAll(Arrays.asList(lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8, lab9, lab10, lab11,
                lab12, lab13, lab14, lab15));

        // simulate no lab for MRI
        // laboratories.addAll(Arrays.asList(lab1, lab2, lab4, lab5, lab6, lab8, lab9, lab10, lab11,
        // lab12, lab13, lab14));

        return laboratories;
    }

    /**
     * Retrieves a random laboratory that offers the specified exam.
     *
     * @param laboratories The list of laboratories to search from
     * @param examName     The name of the exam to find a laboratory for
     * @return A random laboratory offering the specified exam, or null if no such laboratory is found
     */
    protected static Laboratory getRandomLabForExam(List<Laboratory> laboratories, String examName) {
        List<Laboratory> availableLabs = laboratories.stream()
                .filter(l -> l.getAvailableExams().contains(examName))
                .collect(Collectors.toList());
        if (!availableLabs.isEmpty()) {
            int randomIndex = ThreadLocalRandom.current().nextInt(availableLabs.size());
            return availableLabs.get(randomIndex);
        }
        return null;
    }

    /**
     * Generates and retrieves a random appointment date.
     *
     * @return A random appointment date
     */
    protected static LocalDate getAppointmentDate() {
        long minDay = LocalDate.now().toEpochDay();
        long maxDay = LocalDate.of(2025, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    /**
     * Generates and retrieves a random appointment time.
     *
     * @return A random appointment time
     */
    protected static LocalTime getAppointmentTime() {
        int hour = ThreadLocalRandom.current().nextInt(8, 17);
        int minute = ThreadLocalRandom.current().nextInt(0, 60);
        return LocalTime.of(hour, minute);
    }

    /**
     * Generates a file path for storing results related to the given appointment response.
     *
     * @param appointmentResponse The appointment response for which the file path is generated
     * @return The generated file path
     */
    protected static String generateFilePath(AppointmentResponse appointmentResponse) {
        String baseDir = "/basedir";
        String fileName = "results_patient" + appointmentResponse.getPatientId() + ".txt";
        return baseDir + "/" + fileName;
    }

}
