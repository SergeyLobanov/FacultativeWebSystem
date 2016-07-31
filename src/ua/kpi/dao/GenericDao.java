package ua.kpi.dao;

import java.util.List;

/**
 * Interface determines methods and object type for Dao
 *
 * Created by Сергей on 26.07.2016.
 */
public interface GenericDao<E> {

    /**
     * creates object in database
     * @param e element for create
     */
    void create( E e);

    /**
     * update object in database
     * @param e element for update
     * @return result of update
     */
    boolean update(E e);

    /**
     * delete object in database
     * @param id id of element for delete
     * @return result of delete
     */
    boolean delete (int id);

    /**
     * find object in database
     * @param id id of element for find
     * @return found element
     */
    E find(int id);

    /**
     * find all objects in database
     * @return list of founded objects
     */
    List<E> findAll();
}
