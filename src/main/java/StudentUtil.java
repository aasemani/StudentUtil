import java.time.DateTimeException;
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

        LocalDate graduationDate = parse(highSchoolGradDate);
        if (graduationDate == null) {
            throw new IllegalArgumentException("highSchoolGradDate is not valid (ex:2017-09-22) : " + highSchoolGradDate);
        }
        LocalDate referenceDate;
        if (null == givenDate) {
            referenceDate = LocalDate.now();
        } else {
            referenceDate = parse(givenDate);
            if (referenceDate == null) {
                throw new IllegalArgumentException("givenDate is not valid (ex:2017-09-22) : " + givenDate);
            }
        }
        return getGrade((LocalDate) graduationDate, (LocalDate) referenceDate);
    }

    private int getGrade(LocalDate graduationDt, LocalDate givenD) {
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

    public LocalDate parse(String date) {

        LocalDate result = null;
        try {
            result = LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            throw new DateTimeException("Please provide valid date (ex:2017-09-22)!");
        }
        return result;
    }

    public static void main(String[] args) {
        StudentUtil studentUtil = new StudentUtil();
        int grade = studentUtil.getGradeOnGivenDate("2016-06-02", "2016-06-02");
        System.out.println("a : " + grade);

        grade = studentUtil.getGradeOnGivenDate("2000-06-02", "2016-06-02");
        System.out.println("b : " + grade);

        grade = studentUtil.getGradeOnGivenDate("2016-06-02", "2016-06-03");
        System.out.println("c : " + grade);

    }
}