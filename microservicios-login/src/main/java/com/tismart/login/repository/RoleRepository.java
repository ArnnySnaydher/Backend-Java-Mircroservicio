package com.tismart.login.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tismart.login.models.ERole;
import com.tismart.login.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);

}
