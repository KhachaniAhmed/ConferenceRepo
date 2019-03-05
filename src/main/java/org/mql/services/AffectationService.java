package org.mql.services;

import java.util.List;

import org.mql.entities.Affectation;
import org.mql.entities.Presentation;
import org.mql.metier.IAffectationMetier;
import org.mql.metier.IPresentationMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class AffectationService {
	@Autowired
	private IAffectationMetier affectationMetier;

	@GetMapping(value = "affectations")
	public List<Affectation> getAll() {
		return affectationMetier.getAll();
	}

	@GetMapping(value = "affectations/{id}")
	public Affectation getOne(@PathVariable Long id) {
		return affectationMetier.getOne(id);
	}

	@DeleteMapping(value = "affectations/{id}")
	public void deleteById(@PathVariable Long id) {
		affectationMetier.deleteByID(id);
	}

	@PostMapping(value = "affectations")
	public Affectation save(@RequestBody Affectation affectation) {
	   System.err.println("debog");
		return affectationMetier.save(affectation);
	}

	@PutMapping(value = "affectations")
	public Affectation edit(@RequestBody Affectation affectation) {
		return affectationMetier.save(affectation);
	}
}
