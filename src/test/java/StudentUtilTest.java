
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;

public class StudentUtilTest {

    StudentUtil studentUtil = new StudentUtil();

    @Test
    @DisplayName("Testing lower and upper limits of student level")
    public void testStudentLevel() {
        assertEquals(99, studentUtil.getGradeOnGivenDate("2016-06-02", "2016-06-03"));
        assertEquals(99, studentUtil.getGradeOnGivenDate("2016-06-02", "2016-06-03"));
        assertEquals(12, studentUtil.getGradeOnGivenDate("2016-06-02", "2016-06-02"));
        assertEquals(12, studentUtil.getGradeOnGivenDate("2016-06-02", "2016-06-01"));
        assertEquals(1, studentUtil.getGradeOnGivenDate("2016-06-02", "2005-06-01"));
        assertEquals(0, studentUtil.getGradeOnGivenDate("2016-06-02", "2004-06-01"));
        assertEquals(0, studentUtil.getGradeOnGivenDate("2016-06-02", "2003-09-01"));
        assertEquals(-1, studentUtil.getGradeOnGivenDate("2016-06-02", "2003-08-01"));
        assertEquals(-1, studentUtil.getGradeOnGivenDate("2016-06-02", "2002-06-01"));
    }

    @Test
    @DisplayName("Testing Exception handling")
    public void testExceptions() {
        Throwable exception = assertThrows(DateTimeException.class, () -> {
            throw new DateTimeException("Please provide valid date!");
        });
        assertEquals("Please provide valid date!", exception.getMessage());
    }

}
