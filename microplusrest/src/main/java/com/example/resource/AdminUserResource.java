package com.example.resource;

import com.example.model.AdminUser;
import com.example.repository.AdminUserRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @description:
 * @author: carlosmantilla
 * @since:
 */
@RepositoryRestResource(itemResourceRel="admins", path="admins")
public interface AdminUserResource extends AdminUserRepository {

    AdminUser findByEmail(@Param("email") String email);

}