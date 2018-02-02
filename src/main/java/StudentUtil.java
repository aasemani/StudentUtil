import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class StudentUtil {
    /**
     * This application is written to calculate student's level based on two date inputs.
     *
     * @param highSchoolGradDate
     * @param givenDate
     * @return studentLevel
     */
    public int getGradeOnGivenDate(String highSchoolGradDate, String givenDate) {

        LocalDate graduationDt, givenD;

        try {
            givenD = LocalDate.parse(givenDate);
            graduationDt = LocalDate.parse(highSchoolGradDate);
        } catch (DateTimeParseException e) {
            System.out.println("Please provide valid date!");
            throw e;
        }

        long days = 4380 - ChronoUnit.DAYS.between(givenD, graduationDt);

        if (days < -278)
            return -1;
        else if (days < 0)
            return 0;
        else if (days < 4380)
            return ((int) days / 365) + 1;
        else if (days == 4380)
            return 12;
        else
            return 99;
    }

    public static void main(String[] args) {
        StudentUtil studentUtil = new StudentUtil();
        int grade = studentUtil.getGradeOnGivenDate("2016-06-02", "2016-06-02");
        System.out.println(grade);
    }
}