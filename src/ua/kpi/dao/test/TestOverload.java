package ua.kpi.dao.test;

/**
 * Created by Сергей on 29.07.2016.
 */
public class TestOverload {
    public static void main(String[] args) {

//        CourseMemberService facultativeService = CourseMemberService.getInstance();
//        Student student = (Student) facultativeService.logIn("lobanov", "lobanov");
//        System.out.println(facultativeService.isStudentInCourse(student, 1));
/*
        System.out.println(CourseMemberService.getHashMD5("lobanov"));
        System.out.println(CourseMemberService.getHashMD5("petr123"));
        System.out.println(CourseMemberService.getHashMD5("vanya"));
        System.out.println(CourseMemberService.getHashMD5("nikpass"));
        System.out.println(CourseMemberService.getHashMD5("makarov"));
        System.out.println(CourseMemberService.getHashMD5("guru"));
        System.out.println(CourseMemberService.getHashMD5("marks"));
        System.out.println(CourseMemberService.getHashMD5("fain"));
*/
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