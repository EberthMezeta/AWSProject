package mzt.awsproject.DaoInterfaces;

import java.util.List;
import java.util.Optional;

public interface IDAOEntidad <T>{

    T get(long id);
    List<T> getAll();
    void update(T t);
    void save(T t);
    void delete(long id);

}
