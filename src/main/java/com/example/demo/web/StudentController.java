package com.example.demo.web;

import com.example.demo.model.jpa.Student;
import com.example.demo.model.sql.TbStudent;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<TbStudent> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/v2/students")
    public List<Student> getAllStudentsWithJpa() {
        return studentService.getAllStudentsWithJpa();
    }
    @PostMapping("/student")
    public Long savestudent()
    {
        return studentService.save();
    }
    @DeleteMapping("/student")
    public Long delete()
    {
        return studentService.delete();
    }
    @PutMapping("/student")
    public Long update()
    {
        return studentService.update();
    }
}
