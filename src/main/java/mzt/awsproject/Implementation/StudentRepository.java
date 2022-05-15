package mzt.awsproject.Implementation;

import mzt.awsproject.DaoInterfaces.IDAOEstudiante;
import mzt.awsproject.Models.Estudiante;
import mzt.awsproject.Services.IServiceEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentRepository implements IServiceEstudiante {
    @Autowired
    private IDAOEstudiante idaoEstudiante;

    @Override
    public Estudiante get(long id) {
        return idaoEstudiante.findById(id).orElse(null);
    }

    @Override
    public List<Estudiante> getAll() {
        return (List<Estudiante>) idaoEstudiante.findAll();
    }

    @Override
    public boolean update(long id, Estudiante estudiante) {
        if (!idaoEstudiante.existsById(id)){
            return false;
        }
        Optional<Estudiante> estudianteOptional = idaoEstudiante.findById(id);
        Estudiante estudianteFromDB = estudianteOptional.get();

        estudianteFromDB.setNombres(estudiante.getNombres());
        estudianteFromDB.setApellidos(estudiante.getApellidos());
        estudianteFromDB.setMatricula(estudiante.getMatricula());
        estudianteFromDB.setPromedio(estudiante.getPromedio());

        idaoEstudiante.save(estudianteFromDB);
        return true;
    }

    @Override
    public boolean save(Estudiante estudiante) {
        try {
            idaoEstudiante.save(estudiante);
            return true;
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        if (!idaoEstudiante.existsById(id)){
            return false;
        }
        idaoEstudiante.deleteById(id);
        return true;
    }



}
