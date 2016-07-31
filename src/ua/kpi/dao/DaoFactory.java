package ua.kpi.dao;

/**
 * The abstract class DaoFactory determines dao that
 * must contain descendant classes
 * Created by Сергей on 27.07.2016.
 */
public abstract class DaoFactory {

    /**
     * creates UserDao
     * @return UserDao
     */
    public abstract UserDao createUserDao();

    /**
     * creates CourseDao
     * @return CourseDao
     */
    public abstract CourseDao createCourseDao();

    /**
     * creates CourseMemberDao
     * @return CourseMemberDao
     */
    public abstract CourseMemberDao createCourseMemberDao();

    /**
     * gets DaoFactory
     * @return DaoFactory
     */
    public static DaoFactory getFactory() {
        try {
            return (DaoFactory) Class.forName(
                    "ua.kpi.dao.jdbc.JdbcDaoFactory").newInstance();
        } catch (IllegalAccessException | InstantiationException
                    | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
