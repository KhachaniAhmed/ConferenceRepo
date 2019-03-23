package org.mql.dao;

import org.mql.entities.Author;
import org.mql.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
	public Author findByUsername(String username);
}
