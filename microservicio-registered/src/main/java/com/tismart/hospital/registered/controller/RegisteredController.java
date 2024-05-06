package com.tismart.hospital.registered.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tismart.hospitaldto.HospitalDTO;
import com.tismart.hospital.registered.service.RegisteredService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/oracle")
public class RegisteredController {

    @Autowired
	final RegisteredService registeredService;

    public RegisteredController(RegisteredService  registeredService){
        this.registeredService = registeredService;
    }

    @PostMapping("/hospital")
	public ResponseEntity<Map<String, String>> registrarHospital(@RequestBody HospitalDTO hospitalDTO) {
		Map<String, String> response = new HashMap<>();

		try {
			String resultado = registeredService.registrarHospital(hospitalDTO);
			response.put("status", "success");
			response.put("message", resultado);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.put("status", "error");
			response.put("message", "Error al registrar hospital: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

		}
	}

}
