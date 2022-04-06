package mzt.awsproject.DaoInterfaces;

import java.util.List;
import java.util.Optional;

public interface IDAOEntidad <T>{

    T get(long id);
    List<T> getAll();
    boolean update(long id , T t);
    boolean save(T t);
    boolean delete(long id);

}
