package ua.kpi.services;

import ua.kpi.dao.DaoFactory;
import ua.kpi.dao.UserDao;
import ua.kpi.entities.User;

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
     * private constructor for singleton
     */
    private UserService(){}

    /**
     * @return instance of User service
     */
    public static UserService getInstance() {
        return instance;
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
     * create new user in database
     * @param user user for creating
     */
	public void createUser(User user) {
        DaoFactory factory = DaoFactory.getFactory();
        UserDao userDao = factory.createUserDao();
        String hashPass = getHashMD5(user.getPassword());
        user.setPassword(hashPass);
        userDao.create(user);		
	}

    /**
     * verify is user with such login exist
     * @param login login to verification
     * @return true if login is occupied 
     */
	public boolean isLoginUnavailable(String login) {
        DaoFactory factory = DaoFactory.getFactory();
        UserDao userDao = factory.createUserDao();
		return userDao.isLoginExist(login);
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
