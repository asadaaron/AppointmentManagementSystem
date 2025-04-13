package com.example.appointmentmanagementsystem.repository;

import java.util.Optional;

import com.example.appointmentmanagementsystem.entity.Appointee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointeeRepository extends JpaRepository<Appointee, Long> {
    Optional<Appointee> findByEmail(String email);
    Optional<Appointee> findByOrganizationName(String organizationName);
}
