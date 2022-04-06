package mzt.awsproject.Controllers;


import mzt.awsproject.Repositories.StudentRepository;
import mzt.awsproject.Models.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<Estudiante> getStudent(@PathVariable long id){
        Estudiante estudiante = studentRepository.get(id);
        if (estudiante==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(estudiante,HttpStatus.OK);
    }

    @PostMapping(path = "/alumnos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addStudent( @RequestBody @Valid Estudiante estudiante){
        studentRepository.save(estudiante);
        return new ResponseEntity<>("Created",HttpStatus.CREATED);
    }


    @PutMapping (path = "/alumnos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateStudent(@PathVariable long id ,@Valid @RequestBody Estudiante estudiante){
        if (!studentRepository.update(id,estudiante)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Updated",HttpStatus.OK);
    }

    @DeleteMapping(path = "/alumnos/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id){
        if (!studentRepository.delete(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}



