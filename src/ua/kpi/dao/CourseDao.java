package ua.kpi.dao;

import ua.kpi.model.entities.Course;

import java.util.List;

/**
 * Created by Сергей on 28.07.2016.
 */
public interface CourseDao extends GenericDao<Course> {

    /**
     * method to find all courses with student by student id
     */
    public abstract List<Course> findAllWithStudent(int id);
}
