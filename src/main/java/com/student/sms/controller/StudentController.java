package com.student.sms.controller;

import com.student.sms.model.Student;
import com.student.sms.repository.IStudent;
import com.student.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/sms")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public Student addStudent(@RequestBody Student student) {
         return studentService.addStudent(student);
    }

    @GetMapping("/students")
    @ResponseBody
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/student/{rollno}")
    public ResponseEntity<Student> get(@PathVariable(value = "rollno") Integer rollno) {
        try {
            Student student = studentService.get(rollno);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    // get the student details as a query param.
    // http://localhost:8083/sms/query?rollNo=1001
    @GetMapping("/query")
    public Student studentQueryParam(@RequestParam(value = "rollno") Integer rollno) {
        return studentService.getById(rollno);
    }

    // to get the active students detail
    // http://localhost:8083/sms/active?status=true
    @GetMapping("/active")
    public List<IStudent> studentQueryParam(@RequestParam(value = "status") boolean status) {
        return studentService.getActiveStudent(status);
    }

    // Soft Delete
    // http://localhost:8089/sms/delete/1002
    @DeleteMapping("/delete/{rollno}")
    public void removeOne(@PathVariable("rollno") Integer rollno) {

        studentService.remove(rollno);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable("id") Integer id, String status, @RequestBody Student student)
            throws Exception {
        return studentService.update(student);
    }


}
