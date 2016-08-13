package test.ua.kpi.model.entities;

import ua.kpi.model.entities.Course;
import ua.kpi.model.entities.CourseMember;
import ua.kpi.model.entities.Student;
import ua.kpi.model.entities.Teacher;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for CourseMember class
 *
 * Created by Сергей on 12.08.2016.
 */
public class CourseMemberTest {
    Teacher teacher;
    Course course;
    Student student;
    CourseMember courseMember;

    @Before
    public void setUpCourseMember() {
        teacher = new Teacher(1, "Teacher", "teacherLogin", "teacherPassword");
        course = new Course(1, "Course", teacher, new Date(), new Date());
        student = new Student(1, "Name", "studentLogin", "studentPassword");
        courseMember = new CourseMember(1, course, student, 5, "comment");
    }

    @After
    public void tearDown() {
        teacher = null;
        student = null;
        course = null;
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