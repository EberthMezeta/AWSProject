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
    public void update(Estudiante estudiante) {
        int index = getIndex(estudiante.getId());
        if (index>-1){
            students.set(index,estudiante);
        }
    }

    @Override
    public void save(Estudiante estudiante) {

        if (!students.isEmpty()){
            int lastIndex = students.size()-1;
            long id = students.get(lastIndex).getId()+1;
            estudiante.setId(id);
            students.add(estudiante);
            return;
        }

        estudiante.setId(1);
        students.add(estudiante);
    }

    @Override
    public void delete(long id) {
        int index = getIndex(id);
        if (index>-1){
            students.remove(index);
        }
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
