package mzt.awsproject.Repositories;

import mzt.awsproject.DaoInterfaces.IDAOEstudiante;
import mzt.awsproject.Models.Estudiante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentRepository implements IDAOEstudiante {

    private final List<Estudiante> students = new ArrayList<>();

    @Override
    public Estudiante get(long id) {
        for (Estudiante student:
             students) {
            if (student.getId()==id){
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Estudiante> getAll() {
        return students;
    }

    @Override
    public boolean update(long id, Estudiante estudiante) {
        int index = getIndex(id);
        if (index>-1){
            students.set(index,estudiante);
            return true;
        }
        return false;
    }

    @Override
    public boolean save(Estudiante estudiante) {
        return students.add(estudiante);
    }

    @Override
    public boolean delete(long id) {
        int index = getIndex(id);
        if (index>-1){
            students.remove(index);
            return true;
        }
        return false;
    }

    private int getIndex(long id){
        int index = -1;
        if (students.isEmpty())return index;
        for (Estudiante student:
                students) {
            index++;
            if (student.getId()==id){
               return index;
            }
        }
        return -1;
    }
}
