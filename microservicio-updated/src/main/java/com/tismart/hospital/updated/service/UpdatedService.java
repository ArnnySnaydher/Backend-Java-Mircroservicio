package com.tismart.hospital.updated.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tismart.hospitaldto.HospitalDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;


@Service
public class UpdatedService {

    @PersistenceContext
	@Autowired
	private EntityManager entityManager;

    @Transactional
	public String actualizarHospital(Long idHospital, HospitalDTO hospitalDTO) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_HOSPITAL_ACTUALIZAR")
				.registerStoredProcedureParameter("sp_idHospital", Long.class, ParameterMode.IN)
				.registerStoredProcedureParameter("sp_idSede", Long.class, ParameterMode.IN)
				.registerStoredProcedureParameter("sp_idDistrito", Long.class, ParameterMode.IN)
				.registerStoredProcedureParameter("sp_idGerente", Long.class, ParameterMode.IN)
				.registerStoredProcedureParameter("sp_idCondicion", Long.class, ParameterMode.IN)
				.setParameter("sp_idHospital", idHospital).setParameter("sp_idSede", hospitalDTO.getIdSede())
				.setParameter("sp_idDistrito", hospitalDTO.getIdDistrito())
				.setParameter("sp_idGerente", hospitalDTO.getIdGerente())
				.setParameter("sp_idCondicion", hospitalDTO.getIdCondicion());
		try {
			query.execute();
			return "Hospital actualizado correctamente.";
		} catch (PersistenceException pe) {
			Throwable cause = pe.getCause();
			if (cause instanceof SQLException) {
				SQLException sqlEx = (SQLException) cause;
				if (sqlEx.getErrorCode() == 20001) {
					return "Error al actualizar el hospital: El Gerente ya está siendo utilizado por otro hospital.";
				}
			}
			return "Error al actualizar el hospital: " + pe.getMessage();
		} catch (Exception e) {
			return "Error al actualizar el hospital: " + e.getMessage();
		}
	}

}
