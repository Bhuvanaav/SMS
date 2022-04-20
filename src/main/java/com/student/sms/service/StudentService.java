package com.student.sms.service;

import com.student.sms.model.Student;
import com.student.sms.repository.IStudent;
import com.student.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student addStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> findAll() {
        return repository.findAll();

    }

    public Student get(Integer rollno) {
        return repository.getByRollno(rollno);

    }

    public Student getById(Integer rollno) {
        return repository.getByRollno(rollno);

    }

    public List<IStudent> getActiveStudent(boolean status) {
        return (List<IStudent>) repository.findAllActiveviaNativeQuery(status);
    }

    public void remove(Integer rollno) {
        repository.deleteByRollno(rollno);

    }

    public Student update(Student student) throws Exception {
        if (student.getStatus()) {
            return repository.save(student);
        } else {
            throw new StudentUpdateException("The student with roll id : " + student.getId()
                    + " is inactive. We can't follow update procedures for the same.");
            // System.out.println("The student with roll id : "+student.getId()+" is
            // inactive. We can't follow update procedures for the same.");
        }

    }



}
