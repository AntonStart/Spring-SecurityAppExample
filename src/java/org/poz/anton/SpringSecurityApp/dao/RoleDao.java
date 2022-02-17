package org.poz.anton.SpringSecurityApp.dao;

import org.poz.anton.SpringSecurityApp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role,Long> {
}
