package mzt.awsproject.Controllers;


import mzt.awsproject.Implementation.StudentRepository;
import mzt.awsproject.Models.Estudiante;
import mzt.awsproject.Services.IAwsS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/" , produces = "application/json")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    private IAwsS3Service iAwsS3Service;

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

        List<Estudiante> estudiantes = studentRepository.getAll();
        int size = estudiantes.size();
        Estudiante lastEstudiante;
        lastEstudiante = estudiantes.get(size-1);
        int id = (int) lastEstudiante.getId();
        System.out.println("{\"id\":" +id+'}');
        return new ResponseEntity<>("{\"id\":" +id+'}',HttpStatus.CREATED);
    }

    @PostMapping(path = "/alumnos/{id}/fotoPerfil", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap<String, String>> addStudentAndPhoto(@PathVariable long id, @RequestPart(value="foto") MultipartFile file){

        iAwsS3Service.uploadFile(id,file);
        String URLfromS3 = iAwsS3Service.getLinkFromS3(id,file.getOriginalFilename());

        Estudiante estudiante = studentRepository.get(id);
        estudiante.setFotoPerfilUrl(URLfromS3);
        studentRepository.update(id,estudiante);
        String fotoPerfilUrl = estudiante.getFotoPerfilUrl();

        HashMap<String,String>Json = new HashMap<>();
        Json.put("fotoPerfilUrl",fotoPerfilUrl);

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(Json);
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



