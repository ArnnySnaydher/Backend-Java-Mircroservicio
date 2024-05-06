package com.tismart.hospital.registered.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tismart.hospitaldto.HospitalDTO;

import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import jakarta.persistence.EntityManager;

@Service
public class RegisteredService {

    @PersistenceContext
	@Autowired
	private EntityManager entityManager;

    @Transactional
	public String registrarHospital(HospitalDTO hospitalDTO) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_HOSPITAL_REGISTRAR")
				.registerStoredProcedureParameter("sp_idDistrito", Long.class, ParameterMode.IN)
				.registerStoredProcedureParameter("sp_Nombre", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("sp_Antiguedad", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("sp_Area", Double.class, ParameterMode.IN)
				.registerStoredProcedureParameter("sp_idSede", Long.class, ParameterMode.IN)
				.registerStoredProcedureParameter("sp_idGerente", Long.class, ParameterMode.IN)
				.registerStoredProcedureParameter("sp_idCondicion", Long.class, ParameterMode.IN)
				.setParameter("sp_idDistrito", hospitalDTO.getIdDistrito())
				.setParameter("sp_Nombre", hospitalDTO.getNombre())
				.setParameter("sp_Antiguedad", hospitalDTO.getAntiguedad())
				.setParameter("sp_Area", hospitalDTO.getArea()).setParameter("sp_idSede", hospitalDTO.getIdSede())
				.setParameter("sp_idGerente", hospitalDTO.getIdGerente())
				.setParameter("sp_idCondicion", hospitalDTO.getIdCondicion());

		try {
			query.execute();
			return "Hospital registrado exitosamente.";
		} catch (Exception e) {

			return "Error al registrar el hospital: " + e.getMessage();

		}
	}

}
