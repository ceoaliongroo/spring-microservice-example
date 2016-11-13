package com.example.config;

import com.example.model.AdminUser;
import com.example.model.Role;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * @description:
 * @author: carlosmantilla
 * @since:
 */
@Configuration
public class RestConfig extends RepositoryRestMvcConfiguration {
    @Override
    public RepositoryRestConfiguration config() {
        RepositoryRestConfiguration config = super.config();

        config.exposeIdsFor(
                AdminUser.class,
                Role.class);

        return config;
    }
}
