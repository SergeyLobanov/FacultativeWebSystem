package ua.kpi.dao;

import ua.kpi.entities.CourseMember;
import ua.kpi.entities.Student;

import java.util.List;

/**
 * Describe interface for CourseMemberDao
 *
 * Created by Сергей on 29.07.2016.
 */
public interface CourseMemberDao extends GenericDao<CourseMember> {

    /**
     * finds course members of teacher by id
     * @param id of teacher
     * @return found course members
     */
    List<CourseMember> findByTeacherID(int id);

    /**
     * creates CourseMember by student and id of course
     * @param student Student
     * @param courseId id of course
     */
    void create(Student student, int courseId);

    /**
     * finds CourseMember by student and id of course
     * @param student Student
     * @param courseId id of course
     * @return found CourseMember
     */
    CourseMember find(Student student, int courseId);

    /**
     * finds list of CourseMember with student by id
     * @param id of student
     * @return CourseMember list
     */
    List<CourseMember> findByStudentID(int id);
}
