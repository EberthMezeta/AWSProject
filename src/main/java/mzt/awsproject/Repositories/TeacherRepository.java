package mzt.awsproject.Repositories;

import mzt.awsproject.DaoInterfaces.IDAOProfesor;
import mzt.awsproject.Models.Profesor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherRepository implements IDAOProfesor {

    private final ArrayList<Profesor> teachers = new ArrayList<>();

    @Override
    public Profesor get(long id) {
        for (Profesor teacher:
                teachers) {
            if (teacher.getId()==id){
                return teacher;
            }
        }
        return null;
    }

    @Override
    public List<Profesor> getAll() {
        return teachers;
    }

    @Override
    public boolean update(long id, Profesor profesor) {
        int index = getIndex(id);
        if (index>-1){
            teachers.set(index,profesor);
            return true;
        }
        return false;
    }

    @Override
    public boolean save(Profesor profesor) {
        return teachers.add(profesor);
    }

    @Override
    public boolean delete(long id) {
        int index = getIndex(id);
        if (index>-1){
            teachers.remove(index);
            return true;
        }
        return false;
    }
    private int getIndex(long id){
        int index = -1;
        if (teachers.isEmpty())return index;
        for (Profesor teacher:
                teachers) {
            index++;
            if (teacher.getId()==id){
                return index;
            }
        }
        return -1;
    }
}
