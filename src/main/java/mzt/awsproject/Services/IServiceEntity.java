package mzt.awsproject.Services;

import mzt.awsproject.Models.Profesor;

import java.util.List;

public interface IServiceEntity<T>{

    T get(long id);
    List<T> getAll();
    boolean update(long id , T t);
    boolean save(T t);
    boolean delete(long id);


    /*
    List<T> list ();
    void save (T entity);
    void delete (T entity);
    T search (T entity);
    */
}

