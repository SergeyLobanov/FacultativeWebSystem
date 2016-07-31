package ua.kpi.model.entities;

/**
 * The User abstract class implements general user of service
 *
 * Created by Сергей on 27.07.2016.
 */
public abstract class User {

    /**
     * user id
     */
    private int id;
    /**
     * user name
     */
    private String name;
    /**
     * user login
     */
    private String login;
    /**
     * user password
     */
    private String password;
    /**
     * user status
     */
    protected Status status;

    /**
     * constructor
     */
    public User(int id, String name, String login, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return status + " " + name;
    }

    public enum Status {
        TEACHER, STUDENT
    }
}
