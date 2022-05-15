package mzt.awsproject.Implementation;

import mzt.awsproject.DaoInterfaces.IDAOProfesor;
import mzt.awsproject.Models.Profesor;
import mzt.awsproject.Services.IServiceProfesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherRepository implements IServiceProfesor {

    @Autowired
    private IDAOProfesor idaoProfesor;

    @Override
    public Profesor get(long id) {
        return idaoProfesor.findById(id).orElse(null);
    }

    @Override
    public List<Profesor> getAll() {
        return (List<Profesor>) idaoProfesor.findAll();
    }

    @Override
    public boolean update(long id, Profesor profesor) {
        if (!idaoProfesor.existsById(id)){
            return false;
        }
        Optional<Profesor> optionalProfesor = idaoProfesor.findById(id);
        Profesor profesorFromDB = optionalProfesor.get();
        profesorFromDB.setNombres(profesor.getNombres());
        profesorFromDB.setApellidos(profesor.getApellidos());
        profesorFromDB.setHorasClase(profesor.getHorasClase());
        profesorFromDB.setNumeroEmpleado(profesor.getNumeroEmpleado());

        idaoProfesor.save(profesorFromDB);
        return true;
    }


    @Override
    public boolean save(Profesor profesor) {
        try {
            idaoProfesor.save(profesor);
            return true;
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        if (!idaoProfesor.existsById(id)){
            return false;
        }
        idaoProfesor.deleteById(id);
        return true;
    }
}
