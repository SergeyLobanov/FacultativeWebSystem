package ua.kpi.dao;

import java.util.List;

/**
 * Created by Сергей on 26.07.2016.
 */
interface GenericDao<E> {
    void create( E e);
    boolean update(E e);
    boolean delete (int id);
    E find(int id);
    List<E> findAll();
}
