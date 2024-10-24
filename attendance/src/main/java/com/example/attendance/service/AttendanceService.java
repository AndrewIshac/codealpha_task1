package com.example.attendance.service;

import com.example.attendance.model.AttendanceRecord;
import com.example.attendance.repository.AttendanceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {
    private final AttendanceRecordRepository attendanceRecordRepository;

    @Autowired
    public AttendanceService(AttendanceRecordRepository attendanceRecordRepository) {
        this.attendanceRecordRepository = attendanceRecordRepository;
    }

    public AttendanceRecord markAttendance(AttendanceRecord record) {
        return attendanceRecordRepository.save(record);
    }

    public List<AttendanceRecord> getAttendanceByEnrollment(Long enrollmentId) {
        // This would require a custom query to be implemented in AttendanceRecordRepository
        return attendanceRecordRepository.findAll(); // Placeholder
    }
}
