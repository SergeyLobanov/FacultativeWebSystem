package ua.kpi.dao;

import org.apache.log4j.Logger;

import ua.kpi.dao.jdbc.constants.ErrorMessage;
import ua.kpi.dao.jdbc.JdbcDaoFactory;

/**
 * The abstract class DaoFactory determines dao that
 * must contain descendant classes
 * Created by Сергей on 27.07.2016.
 */
public abstract class DaoFactory {

	private static final String JDBC_DAO_FACTORY = "ua.kpi.dao.jdbc.JdbcDaoFactory";
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
                    JDBC_DAO_FACTORY).newInstance();
        } catch (IllegalAccessException | InstantiationException
                    | ClassNotFoundException e) {
            Logger logger =  Logger.getLogger(JdbcDaoFactory.class);
            logger.error(ErrorMessage.CREATE_DAO_FACTORY + e );
            throw new RuntimeException(e);
        }
    }
}
