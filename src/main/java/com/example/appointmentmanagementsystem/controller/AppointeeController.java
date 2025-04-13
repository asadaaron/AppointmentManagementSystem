package com.example.appointmentmanagementsystem.controller;

import com.example.appointmentmanagementsystem.entity.Appointee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.appointmentmanagementsystem.service.AppointeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/appointee/")
public class AppointeeController {
    private final AppointeeService appointeeService;

    public AppointeeController(AppointeeService appointeeService) {
        this.appointeeService = appointeeService;
    }


    /**
     * Create a new Appointee (POST)
     */
    @PostMapping(value = "create")
    public ResponseEntity<?> createAppointee(@Valid @RequestBody Appointee appointee, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(getValidationErrors(result));
        }
        return ResponseEntity.ok(appointeeService.createAppointee(appointee));
    }

    /**
     * Get All Appointees (GET)
     */
    @GetMapping(value = "list")
    public ResponseEntity<List<Appointee>> getAllAppointees() {
        return ResponseEntity.ok(appointeeService.getAllAppointees());
    }

    /**
     * Get Appointee by ID (GET)
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getAppointeeById(@PathVariable Long id) {
        Optional<Appointee> appointee = appointeeService.getAppointeeById(id);
        return appointee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body((Appointee) Map.of("error", "Appointee not found with id: " + id)));
    }

    /**
     * Update an Appointee (PUT)
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAppointee(@PathVariable Long id, @Valid @RequestBody Appointee appointee, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(getValidationErrors(result));
        }
        try {
            return ResponseEntity.ok(appointeeService.updateAppointee(id, appointee));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(Map.of("error", e.getMessage()));
        }
    }

    /**
     * Delete an Appointee (DELETE)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAppointee(@PathVariable Long id) {
        try {
            appointeeService.deleteAppointee(id);
            return ResponseEntity.ok(Map.of("message", "Appointee deleted successfully"));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(Map.of("error", e.getMessage()));
        }
    }

    /**
     * Utility Method: Extract Validation Errors
     */
    private Map<String, String> getValidationErrors(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
    }
}
