package org.mql.services;

import java.util.List;

import org.mql.dao.ConferenceRepository;
import org.mql.entities.Conference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/conferences")
public class ConferenceRestService {

	@Autowired
	private ConferenceRepository conferenceRestService;

@GetMapping("/All_Conference")
public List<Conference> getAllConference(){
	return conferenceRestService.findAll();
}
@GetMapping(value="/conference/{id}")
public Conference getConference(@PathVariable Long id){
	return conferenceRestService.findById(id).get();
}

@GetMapping(value="/chercherConference")
public Page<Conference> chercher
        (@RequestParam(name = "page", defaultValue = "0") int p,
    			@RequestParam(name = "size", defaultValue = "6") int s,
    			@RequestParam(name = "motCle", defaultValue = "") String mc) {
   return conferenceRestService.chercher("%" + mc + "%", new PageRequest(p, s));	
}

@PostMapping(value="/conference/add")
public Conference saveContact(@RequestBody Conference contact){
	return conferenceRestService.save(contact);
}

@GetMapping(value="/conference/delete/{id}")
public boolean deletContact(@PathVariable Long id){
	 conferenceRestService.deleteById(id);
	 return true;
}

@PutMapping(value="/conference/put/{id}")
public Conference saveContact(@PathVariable Long id,@RequestBody Conference contact){
	contact.setId(id);
	return conferenceRestService.save(contact);
}

}
