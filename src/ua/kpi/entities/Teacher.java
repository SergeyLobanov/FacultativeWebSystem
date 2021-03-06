package ua.kpi.entities;

/**
 * The Teacher class extends User abstract class and have TEACHER status of user
 *
 * Created by Сергей on 27.07.2016.
 */
public class Teacher extends User{

    /**
     * constructor
     */
    public Teacher(int id, String name, String login, String password) {
        super(id, name, login, password);
        this.status = Status.TEACHER;
    }
}
