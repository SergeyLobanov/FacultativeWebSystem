package ua.kpi.entities;

/**
 * The Student class extends User abstract class and have STUDENT status of user
 *
 * Created by Сергей on 27.07.2016.
 */
public class Student extends User{

    /**
     * constructor
     */
    public Student(int id, String name, String login, String password) {
        super(id, name, login, password);
        this.status = Status.STUDENT;
    }

}
