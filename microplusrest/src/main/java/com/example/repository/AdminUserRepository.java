package com.example.repository;

import com.example.model.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * @description:
 * @author: carlosmantilla
 * @since:
 */
public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {

    AdminUser findByEmail(@Param("email") String email);
}