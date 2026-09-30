package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dao.StudentDAO;
import com.example.entity.Student;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentDAO studentDAO;

    // HOME
    @GetMapping("")
    public String home() {
        return "index";
    }

    // ADD FORM
    @GetMapping("/add")
    public String addForm(Model model) {

        model.addAttribute(
                "student",
                new Student()
        );

        return "index";
    }

    // ADD
    @PostMapping("/add")
    public String addStudent(
            @ModelAttribute Student student) {

        studentDAO.save(student);

        return "redirect:/students/list";
    }

    // DISPLAY ALL
    @GetMapping("/list")
    public String listStudents(Model model) {

        List<Student> students =
                studentDAO.getAllStudents();

        model.addAttribute(
                "students",
                students
        );

        return "students";
    }

    // SEARCH
    @GetMapping("/search")
    public String searchStudent(
            @RequestParam("regno") int regno,
            Model model) {

        Student student =
                studentDAO.getStudent(regno);

        model.addAttribute(
                "student",
                student
        );

        return "search";
    }

    // EDIT PAGE
    @GetMapping("/edit/{regno}")
    public String editStudent(
            @PathVariable int regno,
            Model model) {

        Student student =
                studentDAO.getStudent(regno);

        model.addAttribute(
                "student",
                student
        );

        return "edit";
    }

    // UPDATE
    @PostMapping("/update")
    public String updateStudent(
            @ModelAttribute Student student) {

        studentDAO.update(student);

        return "redirect:/students/list";
    }

    // DELETE
    @GetMapping("/delete/{regno}")
    public String deleteStudent(
            @PathVariable int regno) {

        studentDAO.delete(regno);

        return "redirect:/students/list";
    }
}