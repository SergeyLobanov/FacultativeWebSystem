package ua.kpi.dao;

/**
 * Created by Сергей on 27.07.2016.
 */
public abstract class DaoFactory {
    //todo: public abstract SomeDao createComeDao;
    public abstract UserDao createUserDao();
    public abstract CourseDao createCourseDao();
    public abstract CourseMemberDao createCourseMemberDao();

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
