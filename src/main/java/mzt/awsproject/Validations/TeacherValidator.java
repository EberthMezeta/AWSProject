package mzt.awsproject.Validations;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public final class TeacherValidator {
    public static boolean notNull(long id , long matricula,String nombres,String apellidos,int promedio){
        return Optional.of(id).isPresent() && Optional.of(matricula).isPresent() && Optional.of(nombres).isPresent() && Optional.of(apellidos).isPresent() && Optional.of(promedio).isPresent() ;
    }
    public static boolean notNull(long matricula,String nombres,String apellidos,int promedio){
        return Optional.of(matricula).isPresent() && Optional.of(nombres).isPresent() && Optional.of(apellidos).isPresent() && Optional.of(promedio).isPresent();
    }

    public static boolean notNull(long id){
        return Optional.of(id).isPresent();
    }



    public static boolean isCorrectType(long id , long matricula,String nombres,String apellidos,int promedio){
        return true;
    }
    public static boolean isCorrectType(long matricula,String nombres,String apellidos,int promedio){

        return true;
    }
    public static boolean isCorrectType(long id){

        return true;
    }
}
