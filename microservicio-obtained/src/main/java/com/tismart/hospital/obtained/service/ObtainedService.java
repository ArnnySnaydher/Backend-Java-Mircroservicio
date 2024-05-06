package com.tismart.hospital.obtained.service;


import org.hibernate.dialect.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tismart.hospitaldto.HospitalDTO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;


@Service
public class ObtainedService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

	 @Transactional
	    public List<HospitalDTO> listarHospitales() {
	        List<HospitalDTO> hospitales = new ArrayList<>();

	        // llamo a mi sp
	        jdbcTemplate.execute((Connection connection) -> {
	            try (CallableStatement call = connection.prepareCall("{call SP_LISTAR_HOSPITALES(?)}")) {
	                call.registerOutParameter(1, OracleTypes.CURSOR); // 1 es el índice del parámetro de salida
	                call.execute();

	                try (ResultSet rs = (ResultSet) call.getObject(1)) {
	                    while (rs.next()) {
	                        HospitalDTO hospital = new HospitalDTO();
	                        hospital.setIdHospital(rs.getLong("idHospital"));
	                        hospital.setIdDistrito(rs.getLong("idDistrito"));
	                        hospital.setNombre(rs.getString("Nombre"));
	                        hospital.setAntiguedad(rs.getInt("Antiguedad"));
	                        hospital.setArea(rs.getDouble("Area"));
	                        hospital.setIdSede(rs.getLong("idSede"));
	                        hospital.setIdGerente(rs.getLong("idGerente"));
	                        hospital.setIdCondicion(rs.getLong("idCondicion"));
	                        hospital.setFechaRegistro(rs.getTimestamp("fechaRegistro"));
	                        hospitales.add(hospital);
	                    }
	                }
	            }
	            return null; 
	        });

	        return hospitales;
	    }
	
	 
}
