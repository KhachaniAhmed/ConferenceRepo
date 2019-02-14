package org.mql.dao;

import org.mql.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsername(String username);
}
