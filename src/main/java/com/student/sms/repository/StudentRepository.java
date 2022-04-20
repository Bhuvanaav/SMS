package com.student.sms.repository;

import com.student.sms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student getByRollno(Integer rollno);

    @Query(value = "select ID,ROllNO,FIRSTNAME,LASTNAME,STANDARD,DIVISION from student WHERE STATUS=true", nativeQuery = true)
    List<IStudent> findAllActiveviaNativeQuery(boolean status);

    void deleteByRollno(Integer rollno);

    Student save(Optional<Student> student);
}
