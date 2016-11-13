package com.example.resource;

import com.example.model.Role;
import com.example.repository.RoleRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.hateoas.ExposesResourceFor;

/**
 * @description:
 * @author: carlosmantilla
 * @since:
 */
@ExposesResourceFor(Role.class)
@RepositoryRestResource(collectionResourceRel="role", path="list.role")
public interface RoleResource extends RoleRepository {
}