package com.example.attendance.controller;

import com.example.attendance.dto.EnrollmentDTO;
import com.example.attendance.model.Enrollment;
import com.example.attendance.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public ResponseEntity<Enrollment> enrollStudent(@RequestBody EnrollmentDTO enrollmentDTO) {
        Enrollment newEnrollment = enrollmentService.enrollStudent(enrollmentDTO.getStudentId(), enrollmentDTO.getCourseId());
        return ResponseEntity.ok(newEnrollment);
    }

    @GetMapping
    public ResponseEntity<List<Enrollment>> getAllEnrollments() {
        return ResponseEntity.ok(enrollmentService.getAllEnrollments());
    }
}

