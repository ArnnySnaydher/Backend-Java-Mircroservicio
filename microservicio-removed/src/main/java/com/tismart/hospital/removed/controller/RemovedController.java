package com.tismart.hospital.removed.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.tismart.hospital.removed.service.RemovedService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/oracle")
public class RemovedController {

    @Autowired
	final RemovedService removedService;

	public RemovedController(RemovedService removedService) {
		this.removedService = removedService;
	}
    
    @DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> eliminarHospital(@PathVariable Long id) {
		Map<String, String> response = new HashMap<>();
		try {
			String resultado = removedService.eliminarHospital(id);
			response.put("status", "success");
			response.put("message", resultado);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.put("status", "error");
			response.put("message", "Error al eliminar el hospital: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

}
