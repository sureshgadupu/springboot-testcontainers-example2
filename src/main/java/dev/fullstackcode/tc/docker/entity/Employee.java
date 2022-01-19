package dev.fullstackcode.tc.docker.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.fullstackcode.tc.docker.entity.Gender;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String first_name;
    private String last_name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate birth_date;
    private LocalDate hire_date;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;



    public Employee() {

    }

    public Employee(Integer id, String first_name, String last_name, Gender gender, LocalDate birth_date, LocalDate hire_date,
                    Department department) {
        super();
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.birth_date = birth_date;
        this.hire_date = hire_date;
        this.department = department;
    }

    public Employee(Integer id, String first_name, String last_name, Gender gender, LocalDate birth_date, LocalDate hire_date
    ) {
        super();
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.birth_date = birth_date;
        this.hire_date = hire_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public LocalDate getHire_date() {
        return hire_date;
    }

    public void setHire_date(LocalDate hire_date) {
        this.hire_date = hire_date;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }



}