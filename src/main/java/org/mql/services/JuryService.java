package org.mql.services;

import java.util.List;

import org.mql.entities.Affectation;
import org.mql.entities.Jury;
import org.mql.metier.IAffectationMetier;
import org.mql.metier.IJuryMetier;
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
public class JuryService {
	@Autowired
	private IJuryMetier iJuryMetier;

	@GetMapping(value = "jurys")
	public List<Jury> getAll() {
		return iJuryMetier.getAll();
	}

	@GetMapping(value = "jurys/{id}")
	public Jury getOne(@PathVariable Long id) {
		return iJuryMetier.getOne(id);
	}

	@DeleteMapping(value = "jurys/{id}")
	public void deleteById(@PathVariable Long id) {
		iJuryMetier.deleteById(id);
	}

	@PostMapping(value = "jurys")
	public Jury save(@RequestBody Jury jury) {
		return iJuryMetier.save(jury);
	}

	@PutMapping(value = "jurys")
	public Jury edit(@RequestBody Jury jury) {
		return iJuryMetier.save(jury);
	}

}
