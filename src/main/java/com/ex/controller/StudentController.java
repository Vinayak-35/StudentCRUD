package com.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ex.entity.Student;
import com.ex.repository.StudentRepository;


@Controller
public class StudentController {
    
    @Autowired
    StudentRepository repo;
    
    // Get all the students
    @RequestMapping(value = "/allStudents", method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getAllStudents() {
        List<Student> students = repo.findAll();
        return students;
    }
    
    // Get students by id
    @RequestMapping(value = "/allStudents/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Student getStudent(@PathVariable int id) {
        Student student = repo.findById(id).get();
        return student;
    }
    
 // create new student
    @RequestMapping(value = "/allStudents/add", method = RequestMethod.POST)
    @ResponseBody
    public void createStudent(@RequestBody Student student) {
       repo.save(student);
    }
    
 // Update the student
    @RequestMapping(value = "/allStudents/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Student updateStudent(@PathVariable int id,
                                 @RequestParam String name,
                                 @RequestParam String branch,
                                 @RequestParam float percentage) {
        Student student = repo.findById(id).orElse(null);

        if (student != null) {
            student.setName(name);
            student.setBranch(branch);
            student.setPercentage(percentage);
            repo.save(student);
        }

        return student;
    }
    
 // delete the student
    @RequestMapping(value = "/allStudents/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteStudent(@PathVariable int id) {
       Student student = repo.findById(id).get();
       repo.delete(student);
    }

    
}

