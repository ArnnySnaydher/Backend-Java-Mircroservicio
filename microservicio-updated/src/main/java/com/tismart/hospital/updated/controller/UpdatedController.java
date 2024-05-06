package com.tismart.hospital.updated.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tismart.hospitaldto.HospitalDTO;
import com.tismart.hospital.updated.service.UpdatedService;

import java.util.Map;
import org.springframework.http.HttpStatus;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/oracle")
public class UpdatedController {

    @Autowired
	final UpdatedService updatedService;

	public UpdatedController(UpdatedService updatedService) {
		this.updatedService = updatedService;
	}

    @PutMapping("/{idHospital}")
    public ResponseEntity<Map<String, String>> actualizarHospital(@PathVariable Long idHospital, @RequestBody HospitalDTO hospitalDTO) {
    	Map<String, String> response = new HashMap<>();
    	
    	try {
    		String resultado = updatedService.actualizarHospital(idHospital, hospitalDTO);
    		
    		response.put("status", "success");
			response.put("message", resultado);
            return ResponseEntity.ok(response);
			
		} catch (Exception e) {
			response.put("status", "error");
			response.put("message", "Error al actulizar hospital: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    	
    }


}
