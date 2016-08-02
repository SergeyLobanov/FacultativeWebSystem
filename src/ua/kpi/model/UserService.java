package ua.kpi.model;

import ua.kpi.dao.DaoFactory;
import ua.kpi.dao.UserDao;
import ua.kpi.model.entities.User;

import java.security.MessageDigest;

/**
 *
 * Created by Сергей on 02.08.2016.
 */
public class UserService {

    /**
     * instance of User service
     */
    private static UserService instance = new UserService();

    /**
     * @return instance of User service
     */
    public static UserService getInstance() {
        return instance;
    }

    /**
     * verifies is user with such login and password exists
     * @param login of user
     * @param password of user
     * @return result of verification
     */
    public boolean isUserExist(String login, String password) {
        DaoFactory factory = DaoFactory.getFactory();
        UserDao userDao = factory.createUserDao();
        String hashPass = getHashMD5(password);
        return (userDao.logIn(login, hashPass) != null);
    }

    /**
     * log in the facultative web system as User with
     * such login and password
     * @param login of user
     * @param password of user
     * @return User
     */
    public User logIn(String login, String password) {
        DaoFactory factory = DaoFactory.getFactory();
        UserDao userDao = factory.createUserDao();
        String hashPass = getHashMD5(password);
        return userDao.logIn(login, hashPass);
    }

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
    }
}
