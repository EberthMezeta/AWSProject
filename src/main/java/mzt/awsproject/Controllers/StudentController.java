package mzt.awsproject.Controllers;


import mzt.awsproject.Repositories.StudentRepository;
import mzt.awsproject.Models.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
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

    @PostMapping(path = "/alumnos")
    public ResponseEntity<HttpStatus> addStudent(@RequestParam long matricula, @RequestParam String nombres, @RequestParam String apellidos, @RequestParam int promedio){
        Estudiante estudiante = new Estudiante(matricula,nombres,apellidos,promedio);
        studentRepository.save(estudiante);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping (path = "/alumnos/{id}")
    public ResponseEntity<HttpStatus> updateStudent(@PathVariable long id , @RequestParam long matricula, @RequestParam String nombres, @RequestParam String apellidos, @RequestParam int promedio){

        Estudiante estudiante = new Estudiante(id,matricula,nombres,apellidos,promedio);
        if (!studentRepository.update(estudiante)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/alumnos/{id}")
    public ResponseEntity<HttpResponse> deleteStudent(@PathVariable long id){
        if (!studentRepository.delete(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


}



