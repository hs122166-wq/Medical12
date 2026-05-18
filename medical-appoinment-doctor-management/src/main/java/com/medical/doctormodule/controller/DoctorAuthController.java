package com.medical.doctormodule.controller;

import com.medical.doctormodule.entity.DoctorUser;
import com.medical.doctormodule.repository.DoctorUserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctor")
@CrossOrigin(origins = "*")
public class DoctorAuthController {

    private final DoctorUserRepository doctorUserRepository;

    public DoctorAuthController(DoctorUserRepository doctorUserRepository) {
        this.doctorUserRepository = doctorUserRepository;
    }

    @PostMapping("/register")
    public DoctorUser register(@RequestBody DoctorUser user) {

        user.setRole("DOCTOR");

        return doctorUserRepository.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody DoctorUser user) {

        DoctorUser existingUser =
                doctorUserRepository.findByEmailAndPasswordAndRole(
                        user.getEmail(),
                        user.getPassword(),
                        "DOCTOR"
                );

        if (existingUser != null) {
            return "Login successful";
        } else {
            return "Invalid login details";
        }
    }
}