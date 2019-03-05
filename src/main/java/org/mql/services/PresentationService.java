package org.mql.services;

import java.util.List;

import org.mql.entities.Presentation;
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
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class PresentationService {
	@Autowired
	private IPresentationMetier presentationMetier;

	@GetMapping(value = "presentations")
	public List<Presentation> getAll() {
		System.err.println("debujxhvjeuydguing");
		return presentationMetier.getAll();
	}

	@GetMapping(value = "presentations/{id}")
	public Presentation getOne(@PathVariable Long id) {
		return presentationMetier.getOne(id);
	}

	@DeleteMapping(value = "presentations/{id}")
	public void deleteById(@PathVariable Long id) {
		presentationMetier.deleteById(id);
	}

	@PostMapping(value = "presentations")
	public Presentation save(@RequestBody Presentation presentation) {
		return presentationMetier.save(presentation);
	}

	@PutMapping(value = "presentations")
	public Presentation edit(@RequestBody Presentation presentation) {
		return presentationMetier.save(presentation);
	}
}
