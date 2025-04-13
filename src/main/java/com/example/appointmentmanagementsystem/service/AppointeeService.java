package com.example.appointmentmanagementsystem.service;

import com.example.appointmentmanagementsystem.entity.Appointee;

import java.util.List;
import java.util.Optional;

public interface AppointeeService {
    Appointee createAppointee(Appointee appointee);
    List<Appointee> getAllAppointees();
    Optional<Appointee> getAppointeeById(Long id);
    Appointee updateAppointee(Long id, Appointee appointeeDetails);
    void deleteAppointee(Long id);
}
