package mzt.awsproject.Controllers;


import mzt.awsproject.Repositories.TeacherRepository;
import mzt.awsproject.Models.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
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
    public ResponseEntity<Profesor> getTeacher(@PathVariable long id){
       Profesor profesor = teacherRepository.get(id);
       if (profesor==null){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
        return new ResponseEntity<>(profesor,HttpStatus.OK);
    }

    @PostMapping(path = "/profesores")
    public ResponseEntity<HttpStatus> addTeacher(@RequestParam long numeroEmpleado, @RequestParam String nombres, @RequestParam String apellidos, @RequestParam int horasClase){
        Profesor profesor = new Profesor(numeroEmpleado,nombres,apellidos,horasClase);
        teacherRepository.save(profesor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



    @PutMapping(path = "/profesores/{id}")
    public ResponseEntity<HttpStatus> updateTeacher(@PathVariable long id ,@RequestParam long numeroEmpleado, @RequestParam String nombres, @RequestParam String apellidos, @RequestParam int horasClase){
        Profesor profesor = new Profesor(id,numeroEmpleado,nombres,apellidos,horasClase);
        if (!teacherRepository.update(profesor)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/profesores/{id}")
    public ResponseEntity<HttpStatus> deleteTeacher(@PathVariable long id){
        if (!teacherRepository.delete(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
