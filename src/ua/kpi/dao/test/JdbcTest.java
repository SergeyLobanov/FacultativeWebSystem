package ua.kpi.dao.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Сергей on 28.07.2016.
 */
public class JdbcTest {
    //static FacultativeService facultativeService = FacultativeService.getInstance();
    public static void main(String[] args) {
        //System.out.println(facultativeService.logIn("lobanov", "lobanov"));
        //System.out.println(Status.valueOf("STUDENT"));
    	log();
    }
    static void log(){
        Logger logger =  LogManager.getLogger(JdbcTest.class);
        logger.error("testing ERROR level");
        logger.trace("exiting application");
        System.out.println(logger.getName());  
    	
    }
}
