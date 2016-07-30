package ua.kpi.model.entities;

/**
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
