package ua.kpi.model;

import ua.kpi.dao.CourseDao;
import ua.kpi.dao.CourseMemberDao;
import ua.kpi.dao.DaoFactory;
import ua.kpi.dao.UserDao;
import ua.kpi.model.entities.Course;
import ua.kpi.model.entities.CourseMember;
import ua.kpi.model.entities.Student;
import ua.kpi.model.entities.User;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by Сергей on 26.07.2016.
 */
public class FacultativeService {

	/**
	 * instance of Facultative service
	 */
    private static FacultativeService instance = new FacultativeService();

    /**
     * 
     * @return instance of Facultative service
     */
    public static FacultativeService getInstance() {
        return instance;
    }

    public boolean isUserExist(String login, String password) {
        DaoFactory factory = DaoFactory.getFactory();
        UserDao userDao = factory.createUserDao();
        String hashPass = getHashMD5(password);
        return userDao.isUserExist(login, hashPass);
    }

    public User logIn(String login, String password) {
        DaoFactory factory = DaoFactory.getFactory();
        UserDao userDao = factory.createUserDao();
        String hashPass = getHashMD5(password);
        return userDao.logIn(login, hashPass);
    }

    public List<Course> allCourses() {
        DaoFactory factory = DaoFactory.getFactory();
        CourseDao courseDao = factory.createCourseDao();
        return courseDao.findAll();
    }

    public void joinCourse(Student student, int courseId) {
        DaoFactory factory = DaoFactory.getFactory();
        CourseMemberDao courseMemberDao = factory.createCourseMemberDao();
        courseMemberDao.create(student, courseId);
    }

    public List<CourseMember> getTeacherStudents(int id) {
        DaoFactory factory = DaoFactory.getFactory();
        CourseMemberDao courseMemberDao = factory.createCourseMemberDao();
        return courseMemberDao.findByTeacherID(id);
    }

    public boolean isStudentInCourse(Student student, int courseId) {
        DaoFactory factory = DaoFactory.getFactory();
        CourseMemberDao courseMemberDao = factory.createCourseMemberDao();
        return (courseMemberDao.find(student, courseId) != null);
    }

    public boolean updateMarkAndComment(CourseMember courseMember) {
        DaoFactory factory = DaoFactory.getFactory();
        CourseMemberDao courseMemberDao = factory.createCourseMemberDao();
        return courseMemberDao.update(courseMember);
    }

    public List getStudentCourses(int id) {
        DaoFactory factory = DaoFactory.getFactory();
        CourseMemberDao courseMemberDao = factory.createCourseMemberDao();
        return courseMemberDao.findByStudentID(id);
    }

    //todo: service methods

    /**
     * function implements MD5 algorithm for string hashing
     * @param st string for hashing
     * @return hash value of string
     */
    private String getHashMD5(String st) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(st.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
        //todo: delete
//        MessageDigest messageDigest = null;
//        byte[] digest = new byte[0];
//
//        try {
//            messageDigest = MessageDigest.getInstance("MD5");
//            messageDigest.reset();
//            messageDigest.update(st.getBytes());
//            digest = messageDigest.digest();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//
//        BigInteger bigInt = new BigInteger(1, digest);
//        StringBuffer md5Hex = new StringBuffer(bigInt.toString(16));
//        //String md5Hex = bigInt.toString(16);
//
//        while( md5Hex.length() < 32 ){
//            md5Hex.append("0")
//            md5Hex = "0" + md5Hex;
//        }
//
//        return md5Hex;
    }

}
