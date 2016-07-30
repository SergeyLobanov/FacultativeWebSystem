package ua.kpi.dao.test;

import ua.kpi.model.FacultativeService;

/**
 * Created by Сергей on 28.07.2016.
 */
public class JdbcTest {
    static FacultativeService facultativeService = FacultativeService.getInstance();
    public static void main(String[] args) {
        System.out.println(facultativeService.logIn("lobanov", "lobanov"));
        //System.out.println(Status.valueOf("STUDENT"));
    }
}
