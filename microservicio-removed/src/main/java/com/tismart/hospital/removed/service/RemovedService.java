package com.tismart.hospital.removed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class RemovedService {

    @PersistenceContext
	@Autowired
	private EntityManager entityManager;

	@Transactional
	public String eliminarHospital(Long idHospital) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_HOSPITAL_ELIMINAR")
				.registerStoredProcedureParameter("sp_idHospital", Long.class, ParameterMode.IN)
				.setParameter("sp_idHospital", idHospital);

		try {
			query.execute();
			return "Hospital eliminado exitosamente.";
		} catch (Exception e) {
			return "Error al eliminar el hospital: " + e.getMessage();
		}
	}

}
