package ua.kpi.entities;

/**
 * The CourseMember class implements facultative course member.
 *
 * Created by Сергей on 29.07.2016.
 */
public class CourseMember {

    /**
     * The maximal mark value
     */
    private static final int MAX_MARK = 5;

    /**
     * course member id
     */
    private int courseMemberID;
    /**
     * course
     */
    private Course course;
    /**
     * student
     */
    private Student student;
    /**
     * teachers mark of student activity on this course
     */
    private int mark;
    /**
     * teachers comment of student activity on this course
     */
    private String comment;

    /**
     * constructors
     */
    public CourseMember(int courseMemberID, Course course, Student student, int mark, String comment) {
        this.courseMemberID = courseMemberID;
        this.course = course;
        this.student = student;
        this.setMark(mark);
        this.comment = comment;
    }

    public int getCourseMemberID() {
        return courseMemberID;
    }

    public void setCourseMemberID(int courseMemberID) {
        this.courseMemberID = courseMemberID;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getMark() {
        return mark;
    }

    /**
     *
     * @param mark mark should be more than 0 and less than MAX_MARK
     * @throws IllegalArgumentException if mark < 0
     * or more than MAX_MARK value
     */
    public void setMark(int mark) {
        if (mark < 0 || mark > MAX_MARK) {
            throw new IllegalArgumentException();
        }
        this.mark = mark;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "CourseMember{" +
                "course " + course.getCourseName() +
                ", student " + student.getName() +
                ", mark " + mark +
                ", comment " + comment + '}';
    }
}
