package ua.kpi.dao;

import ua.kpi.model.entities.User;

/**
 * Describe interface for UserDao
 *
 * Created by Сергей on 28.07.2016.
 */
public interface UserDao extends GenericDao<User> {

    /**
     * get user with the same login and password
     * @param login of user
     * @param password of user
     * @return User with the same login and password
     */
    User logIn(String login, String password);

}
