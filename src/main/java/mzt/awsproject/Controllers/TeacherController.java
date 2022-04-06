package mzt.awsproject.Controllers;


import mzt.awsproject.Repositories.TeacherRepository;
import mzt.awsproject.Models.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping(path = "/profesores", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addTeacher(@RequestBody @Valid Profesor profesor){
        teacherRepository.save(profesor);
        return  new ResponseEntity<>("Created",HttpStatus.CREATED);
    }

    @PutMapping(path = "/profesores/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateTeacher(@PathVariable long id ,@RequestBody @Valid Profesor profesor){
        if (!teacherRepository.update(id, profesor)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>("Updated",HttpStatus.OK);
    }

    @DeleteMapping(path = "/profesores/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable long id){
        if (!teacherRepository.delete(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
}
