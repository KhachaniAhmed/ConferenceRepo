package org.mql.services;

import java.util.List;

import org.mql.entities.Domaine;
import org.mql.metier.IDomaineMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class DomaineService {

	@Autowired
	private IDomaineMetier domaineMetier;

	@GetMapping(value = "domaines")
	public List<Domaine> getAll() {
		System.err.println("debuguing");
		return domaineMetier.getAll();
	}

}
