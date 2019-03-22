package org.mql.services;

import java.util.List;

import org.mql.entities.Chair;
import org.mql.entities.Presentation;
import org.mql.metier.ChairMetierImpl;
import org.mql.metier.IChairMetier;
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
public class chairService {
	@Autowired
	private IChairMetier chairMetier;
	
	@GetMapping(value = "chairs")
	public List<Chair> getAll() {
		System.err.println("debujxhvjeuydguing");
		return chairMetier.getAll();
	}

	@GetMapping(value = "chairs/{id}")
	public Chair getOne(@PathVariable Long id) {
		return chairMetier.getOne(id);
	}

	@DeleteMapping(value = "chairs/{id}")
	public void deleteById(@PathVariable Long id) {
		chairMetier.deleteByID(id);
	}

	@PostMapping(value = "chairs")
	public Chair save(@RequestBody Chair chair) {
		return chairMetier.save(chair);
	}

	@PutMapping(value = "chairs")
	public Chair edit(@RequestBody Chair chair) {
		return chairMetier.save(chair);
	}

}
