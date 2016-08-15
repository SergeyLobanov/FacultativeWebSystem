package test.ua.kpi.model.entities;

import ua.kpi.model.entities.Course;
import ua.kpi.model.entities.CourseMember;
import ua.kpi.model.entities.Student;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for CourseMember class
 *
 * Created by Сергей on 12.08.2016.
 */
public class CourseMemberTest {
	
    CourseMember courseMember;

    @Before
    public void setUp() {
    	Course course = mock(Course.class);
    	Student student = mock(Student.class);
        courseMember = new CourseMember(1, course, student, 5, "comment");
    }

    @After
    public void tearDown() {
        courseMember = null;
    }
    
    @Test
    public void testSetMark() {
        courseMember.setMark(4);
        int expectedValue = 4;
        assertEquals(expectedValue, courseMember.getMark());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNegativeMark() {
        courseMember.setMark(-1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetMarkLargerThanMaxMark() {
        courseMember.setMark(6);
    }
}
