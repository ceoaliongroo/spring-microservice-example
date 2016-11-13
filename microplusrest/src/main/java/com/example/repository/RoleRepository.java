package com.example.repository;

import com.example.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @description:
 * @author: carlosmantilla
 * @since:
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}