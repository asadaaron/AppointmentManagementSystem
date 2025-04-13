package com.example.appointmentmanagementsystem.service;

import com.example.appointmentmanagementsystem.entity.Appointee;
import com.example.appointmentmanagementsystem.repository.AppointeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointeeServiceImpl implements AppointeeService {
    private final AppointeeRepository appointeeRepository;

    public AppointeeServiceImpl(AppointeeRepository appointeeRepository) {
        this.appointeeRepository = appointeeRepository;
    }


    @Override
    public Appointee createAppointee(Appointee appointee) {
        return appointeeRepository.save(appointee);
    }

    @Override
    public List<Appointee> getAllAppointees() {
        return appointeeRepository.findAll();
    }

    @Override
    public Optional<Appointee> getAppointeeById(Long id) {
        return appointeeRepository.findById(id);
    }

    @Override
    public Appointee updateAppointee(Long id, Appointee appointeeDetails) {
        return appointeeRepository.findById(id).map(existingAppointee -> {
            existingAppointee.setAppointeeName(appointeeDetails.getAppointeeName());
            existingAppointee.setEmail(appointeeDetails.getEmail());
            existingAppointee.setPhoneNumber(appointeeDetails.getPhoneNumber());
            existingAppointee.setAddress(appointeeDetails.getAddress());
            existingAppointee.setOrganizationName(appointeeDetails.getOrganizationName());
            existingAppointee.setServiceName(appointeeDetails.getServiceName());
            existingAppointee.setYearOfExperience(appointeeDetails.getYearOfExperience());
            existingAppointee.setSpeciality(appointeeDetails.getSpeciality());
            return appointeeRepository.save(existingAppointee);
        }).orElseThrow(() -> new RuntimeException("Appointee not found with id: " + id));
    }

    @Override
    public void deleteAppointee(Long id) {
        appointeeRepository.deleteById(id);
    }

}
