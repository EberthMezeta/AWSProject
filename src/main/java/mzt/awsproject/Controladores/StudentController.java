package mzt.awsproject.Controladores;


import mzt.awsproject.Repositories.StudentRepository;
import mzt.awsproject.models.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/" , produces = "application/json")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping(path = "/alumnos")
    public List<Estudiante> getAll (){
        return  studentRepository.getAll();
    }

    @GetMapping(path = "/alumnos/{id}")
    public Estudiante getStudent(@PathVariable long id){
        return studentRepository.get(id);
    }

    @PostMapping(path = "/alumnos")
    public void addStudent(@RequestParam long matricula, @RequestParam String nombres, @RequestParam String apellidos, @RequestParam int promedio){
        Estudiante estudiante = new Estudiante(matricula,nombres,apellidos,promedio);
        studentRepository.save(estudiante);
    }


    @PutMapping (path = "/alumnos/{id}")
    public void updateStudent(@PathVariable long id , @RequestParam long matricula, @RequestParam String nombres, @RequestParam String apellidos, @RequestParam int promedio){
        Estudiante estudiante = new Estudiante(id,matricula,nombres,apellidos,promedio);
        studentRepository.update(estudiante);
    }

    @DeleteMapping(path = "/alumnos/{id}")
    public void deleteStudent(@PathVariable long id){
        studentRepository.delete(id);
    }


}



