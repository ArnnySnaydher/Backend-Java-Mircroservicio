package com.tismart.hospital.obtained.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tismart.hospital.obtained.service.ObtainedService;
import com.tismart.hospitaldto.HospitalDTO;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/oracle")
public class ObtaindedController {

    @Autowired
	final ObtainedService obtainedService;

    public ObtaindedController(ObtainedService obtainedService) {
		this.obtainedService = obtainedService;
	}

    @GetMapping("/obtener")
    public ResponseEntity<List<HospitalDTO>> listarHospitales() {
        List<HospitalDTO> hospitales = obtainedService.listarHospitales();
        return ResponseEntity.ok(hospitales);
    }

}
