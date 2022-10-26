package com.email.email_01.controller;

import com.email.email_01.DTO.NotificationDTO;
import com.email.email_01.entities.Student;
import com.email.email_01.service.EmailService;
import com.email.email_01.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    EmailService emailService;

    @Autowired
    StudentService studentService;

    @PostMapping("/notification")
    public ResponseEntity sendNotification(@RequestBody NotificationDTO notificationDTO) {
        try {
            Student StudentToSendNotification = studentService.getStudentById(notificationDTO.getContactId());
            System.out.println("Getting the Student: " + StudentToSendNotification);
            if (StudentToSendNotification == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Did not find the Student");
            }
            emailService.sendTo(StudentToSendNotification.getEmail(), notificationDTO.getTitle(), notificationDTO.getText());
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}

