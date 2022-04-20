package com.student.sms.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;


@Entity
@Table(name = "student")
@SQLDelete(sql = "UPDATE student SET deleted = true WHERE rollno=?")
@Where(clause = "deleted=false")
public class Student extends Auditable   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer rollno;
    private String firstname;
    private String lastname;
    private Integer standard;
    private String Division;
    private String schoolName;
    private String phoneNumber;

    private boolean status;
    private boolean deleted = Boolean.FALSE;// FALSE = not deleted, TRUE = deleted

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRollno() {
        return rollno;
    }

    public void setRollno(Integer rollno) {
        this.rollno = rollno;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getStandard() {
        return standard;
    }

    public void setStandard(Integer standard) {
        this.standard = standard;
    }

    public String getDivision() {
        return Division;
    }

    public void setDivision(String division) {
        Division = division;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Student() {
    }

    public Student(Integer id, Integer rollno, String firstname, String lastname, Integer standard, String division,
                   String schoolName, String phoneNumber, boolean status, boolean deleted, Gender gender) {
        super();
        this.id = id;
        this.rollno = rollno;
        this.firstname = firstname;
        this.lastname = lastname;
        this.standard = standard;
        Division = division;
        this.schoolName = schoolName;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.deleted = deleted;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", rollno=" + rollno +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", standard=" + standard +
                ", Division='" + Division + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", status=" + status +
                ", deleted=" + deleted +
                ", gender=" + gender +
                '}';
    }


}
