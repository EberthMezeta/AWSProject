package mzt.awsproject.Controladores;


import mzt.awsproject.Repositories.TeacherRepository;
import mzt.awsproject.models.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/" , produces = "application/json")
public class TeacherController {

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping(path = "/profesores")
    public List<Profesor> getAll (){
        return teacherRepository.getAll();
    }

    @GetMapping(path = "/profesores/{id}")
    public Profesor getTeacher(@PathVariable long id){
        return teacherRepository.get(id);
    }

    @PostMapping(path = "/profesores")
    public void addTeacher(@RequestParam long numeroEmpleado, @RequestParam String nombres, @RequestParam String apellidos, @RequestParam String horasClase){
        Profesor profesor = new Profesor(numeroEmpleado,nombres,apellidos,horasClase);
        teacherRepository.save(profesor);

    }


    @PutMapping(path = "/profesores/{id}")
    public void updateTeacher(@PathVariable long id ,@RequestParam long numeroEmpleado, @RequestParam String nombres, @RequestParam String apellidos, @RequestParam String horasClase){
        Profesor profesor = new Profesor(id,numeroEmpleado,nombres,apellidos,horasClase);
        teacherRepository.update(profesor);
    }

    @DeleteMapping(path = "/profesores/{id}")
    public void deleteTeacher(@PathVariable long id){
        teacherRepository.delete(id);
    }
}
