package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Display all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Find student by register number
    public Optional<Student> getStudentById(int regno) {
        return studentRepository.findById(regno);
    }

    // Add student
    public boolean saveStudent(Student student) {
        if (studentRepository.existsById(student.getRegno())) {
            return false;
        }

        studentRepository.save(student);
        return true;
    }

    // Update student
    public boolean updateStudent(int regno, String name, double cgpa) {
        Optional<Student> result = studentRepository.findById(regno);

        if (result.isEmpty()) {
            return false;
        }

        Student student = result.get();
        student.setName(name);
        student.setCgpa(cgpa);

        studentRepository.save(student);
        return true;
    }

    // Delete student
    public boolean deleteStudent(int regno) {
        if (!studentRepository.existsById(regno)) {
            return false;
        }

        studentRepository.deleteById(regno);
        return true;
    }

    // Search students by name
    public List<Student> searchStudents(String name) {
        if (name == null || name.isBlank()) {
            return studentRepository.findAll();
        }

        return studentRepository.findByNameContainingIgnoreCase(name.trim());
    }
}