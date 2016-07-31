package ua.kpi.dao.test;

import ua.kpi.model.FacultativeService;
import ua.kpi.model.entities.Student;

/**
 * Created by Сергей on 29.07.2016.
 */
public class TestOverload {
    public static void main(String[] args) {

//        FacultativeService facultativeService = FacultativeService.getInstance();
//        Student student = (Student) facultativeService.logIn("lobanov", "lobanov");
//        System.out.println(facultativeService.isStudentInCourse(student, 1));

        System.out.println(FacultativeService.getHashMD5("lobanov"));
        System.out.println(FacultativeService.getHashMD5("petr123"));
        System.out.println(FacultativeService.getHashMD5("vanya"));
        System.out.println(FacultativeService.getHashMD5("nikpass"));
        System.out.println(FacultativeService.getHashMD5("makarov"));
        System.out.println(FacultativeService.getHashMD5("guru"));
        System.out.println(FacultativeService.getHashMD5("marks"));
        System.out.println(FacultativeService.getHashMD5("fain"));

        /*
        Go go = new Go();
        Stud st = new Stud();
        go.print(st);
        Teach tc = new Teach();
        go.print(tc);*/
    }
}
class Go {
    void print(Stud us){
        us.print();
    }

    void print(Teach us){
        us.print();
    }
}
abstract class  User{
    void print(){
        System.out.println("user");
    }
}
class Stud extends User{
    void print(){
        System.out.println("stud");
    }
}
class Teach extends User{
    void print(){
        System.out.println("teach");
    }
}