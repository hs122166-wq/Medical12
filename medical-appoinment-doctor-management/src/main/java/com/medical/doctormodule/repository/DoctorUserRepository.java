package com.medical.doctormodule.repository;

import com.medical.doctormodule.entity.DoctorUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorUserRepository extends JpaRepository<DoctorUser, Long> {

    DoctorUser findByEmailAndPasswordAndRole(
            String email,
            String password,
            String role
    );
}