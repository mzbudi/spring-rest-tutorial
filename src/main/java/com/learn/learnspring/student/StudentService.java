package com.learn.learnspring.student;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> gStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> findStudentByMail = this.studentRepository.findStudentByEmail(student.getEmail());

        if (findStudentByMail.isPresent()) {
            throw new IllegalStateException("Email Used");
        }

        this.studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exist = this.studentRepository.existsById(studentId);
        if (!exist) {
            throw new IllegalStateException("No such id");
        }
        this.studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = this.studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("No Student with such id"));

        if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentByMail = this.studentRepository.findStudentByEmail(email);
            if (studentByMail.isPresent()){
                throw new IllegalStateException("Email used");
            }

            student.setEmail(email);
        }
    }
}
