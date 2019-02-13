package org.mql.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController(value="articles")
public class ArticleService {
	
	@GetMapping
	public List<String> getAll(){
		return Arrays.asList("Afticle 1","Article 2");
	}

}
