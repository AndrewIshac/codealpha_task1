package com.example.attendance.controller;

import com.example.attendance.model.AttendanceRecord;
import com.example.attendance.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    private final AttendanceService attendanceService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping
    public ResponseEntity<AttendanceRecord> markAttendance(@RequestBody AttendanceRecord record) {
        AttendanceRecord markedRecord = attendanceService.markAttendance(record);
        return ResponseEntity.ok(markedRecord);
    }

    @GetMapping("/enrollment/{enrollmentId}")
    public ResponseEntity<List<AttendanceRecord>> getAttendanceByEnrollment(@PathVariable Long enrollmentId) {
        List<AttendanceRecord> records = attendanceService.getAttendanceByEnrollment(enrollmentId);
        return ResponseEntity.ok(records);
    }
}
