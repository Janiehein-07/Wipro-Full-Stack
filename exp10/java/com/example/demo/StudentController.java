package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Home page
    @GetMapping("/")
    public String home() {
        return "redirect:/students";
    }

    // Display student list
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student-list";
    }

    // Open add-student form
    @GetMapping("/students/new")
    public String newStudent(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("editMode", false);
        return "student-form";
    }

    // Save new student
    @PostMapping("/students/save")
    public String saveStudent(
            @RequestParam int regno,
            @RequestParam String name,
            @RequestParam double cgpa,
            RedirectAttributes redirectAttributes) {

        if (regno <= 0 || name.isBlank()
                || name.length() > 100
                || !Double.isFinite(cgpa)
                || cgpa < 0 || cgpa > 10) {

            redirectAttributes.addFlashAttribute(
                    "error", "Enter valid student details.");

            return "redirect:/students/new";
        }

        Student student = new Student(regno, name.trim(), cgpa);

        if (!studentService.saveStudent(student)) {
            redirectAttributes.addFlashAttribute(
                    "error", "Register number already exists.");

            return "redirect:/students/new";
        }

        redirectAttributes.addFlashAttribute(
                "message", "Student added successfully!");

        return "redirect:/students";
    }

    // Open edit form
    @GetMapping("/students/edit/{regno}")
    public String editStudent(
            @PathVariable int regno,
            Model model,
            RedirectAttributes redirectAttributes) {

        Optional<Student> result = studentService.getStudentById(regno);

        if (result.isEmpty()) {
            redirectAttributes.addFlashAttribute(
                    "error", "Student not found.");

            return "redirect:/students";
        }

        model.addAttribute("student", result.get());
        model.addAttribute("editMode", true);

        return "student-form";
    }

    // Update student
    @PostMapping("/students/update")
    public String updateStudent(
            @RequestParam int regno,
            @RequestParam String name,
            @RequestParam double cgpa,
            RedirectAttributes redirectAttributes) {

        if (name.isBlank() || name.length() > 100
                || !Double.isFinite(cgpa)
                || cgpa < 0 || cgpa > 10) {

            redirectAttributes.addFlashAttribute(
                    "error", "Enter a valid name and CGPA between 0 and 10.");

            return "redirect:/students/edit/" + regno;
        }

        boolean updated = studentService.updateStudent(
                regno, name.trim(), cgpa);

        if (updated) {
            redirectAttributes.addFlashAttribute(
                    "message", "Student updated successfully!");
        } else {
            redirectAttributes.addFlashAttribute(
                    "error", "Student not found.");
        }

        return "redirect:/students";
    }

    // Delete student
    @PostMapping("/students/delete")
    public String deleteStudent(
            @RequestParam int regno,
            RedirectAttributes redirectAttributes) {

        boolean deleted = studentService.deleteStudent(regno);

        if (deleted) {
            redirectAttributes.addFlashAttribute(
                    "message", "Student deleted successfully!");
        } else {
            redirectAttributes.addFlashAttribute(
                    "error", "Student not found.");
        }

        return "redirect:/students";
    }

    // Search students
    @GetMapping("/students/search")
    public String searchStudents(
            @RequestParam(defaultValue = "") String name,
            Model model) {

        List<Student> students = studentService.searchStudents(name);

        model.addAttribute("students", students);
        model.addAttribute("searchName", name);

        return "student-list";
    }
}