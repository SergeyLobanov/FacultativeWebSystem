package ua.kpi.entities;

import java.util.Date;

/**
 * The Course class implements facultative course.
 * Course consists id, name, course teacher and dates of start and end
 *
 * Created by Сергей on 27.07.2016.
 */
public class Course {

    /**
     * course id
     */
    private int id;
    /**
     * course name
     */
    private String courseName;
    /**
     * course teacher
     */
    private Teacher courseTeacher;
    /**
     * data of course start
     */
    private Date startDate;
    /**
     * data of course end
     */
    private Date endDate;

    /**
     * constructor
     */
    public Course(int id, String courseName, Teacher courseTeacher, Date startDate, Date endDate) {
        this.id = id;
        this.courseName = courseName;
        this.courseTeacher = courseTeacher;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Teacher getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(Teacher courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Course info: " +
                " course  " + courseName +
                ", teacher " + courseTeacher.getName() +
                ", starts at " + startDate +
                ", ends at " + endDate;
    }
}
