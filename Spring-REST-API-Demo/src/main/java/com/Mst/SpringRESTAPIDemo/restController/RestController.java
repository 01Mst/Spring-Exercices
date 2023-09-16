package com.Mst.SpringRESTAPIDemo.restController;

import com.Mst.SpringRESTAPIDemo.entity.Students;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    List<Students> student;

    @PostConstruct
    public void loadData(){
        student=new ArrayList<>();
        student.add(new Students("Thulasimani","CSE",1));
        student.add(new Students("Hariharan","BCA",2));


    }

    @GetMapping("/students")
   public List<Students> getStudents(){
        return student;
   }

   @GetMapping("/students/{studentId}")
    public Students getStudent(@PathVariable int studentId){

        if(studentId>student.size()+1||studentId<=0){
            throw new StudentNotFoundException("Student ID not found: "+studentId);
        }
        return student.get(studentId-1);
   }

   @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> exceptionHandler(Exception src){
        StudentErrorResponse error=new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(src.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
   }

   @ExceptionHandler
    public  ResponseEntity<StudentErrorResponse> exceptionHandler2(StudentNotFoundException src){

        StudentErrorResponse error=new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(src.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
   }



}
