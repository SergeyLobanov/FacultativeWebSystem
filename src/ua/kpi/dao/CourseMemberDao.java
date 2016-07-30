package ua.kpi.dao;

import ua.kpi.model.entities.Course;
import ua.kpi.model.entities.CourseMember;
import ua.kpi.model.entities.Student;

import java.util.List;

/**
 * Created by Сергей on 29.07.2016.
 */
public interface CourseMemberDao extends GenericDao<CourseMember> {

    /**
     * find members of course by teacher id
     * todo:do i need
     */
    List<CourseMember> findByTeacherID(int id);

    void create(Student student, int courseId);

    CourseMember find(Student student, int courseId);

    List<CourseMember> findByStudentID(int id);
}
