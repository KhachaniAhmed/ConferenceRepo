package org.mql;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.mql.dao.ReviewerRepository;
import org.mql.entities.Article;
import org.mql.entities.Chair;
import org.mql.entities.Domaine;
import org.mql.entities.Reviewer;
import org.mql.entities.Role;
import org.mql.entities.User;
import org.mql.entities.View;
import org.mql.metier.IAccountMetier;
import org.mql.metier.IArticleMetier;
import org.mql.metier.IChairMetier;
import org.mql.metier.IDomaineMetier;
import org.mql.metier.IViewMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ConferenceProjetApplication implements CommandLineRunner {
	@Autowired
	private IAccountMetier accountMetier;
	@Autowired
	private IDomaineMetier domaineMetier;
	@Autowired
	private ReviewerRepository reviewerRepository;
	@Autowired
	private IViewMetier iViewMetier;
	@Autowired
	private IArticleMetier articleMetier;
	@Autowired
	private IChairMetier chairMetier;
	
	
	private List<Reviewer> reviewers = new ArrayList<Reviewer>();
	private List<Domaine> domaines = new ArrayList<Domaine>();

	public static void main(String[] args) {
		SpringApplication.run(ConferenceProjetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Role role1 = accountMetier.saveRole(new Role(null, "ADMIN"));
//		Role role2 = accountMetier.saveRole(new Role(null, "USER"));
//		chairMetier.save(new Chair(null, "ali", "AitBassou", role2));	
		
//		User user1 = accountMetier.saveUser(new User(null, "admin", "123", role1));
//		User user2 = accountMetier.saveUser(new User(null, "user", "123", role2));
//		accountMetier.addRoleToUser("admin", "ADMIN");
//		accountMetier.addRoleToUser("user", "USER");
//		User user = accountMetier.findUserByUsername("admin");
//		System.out.println(user.toString());
//		Stream.of("technologie", "science", "art").forEach(d -> {
//			Domaine domaine = domaineMetier.create(new Domaine(null, d));
//            domaines.add(domaine);
//		});
//		domaines.forEach(d->{
//			reviewerRepository.save(new Reviewer(null, null, null, role1, d));
//		}); 
//		iViewMetier.save(new View(null, "accepted",reviewerRepository.getOne(new Long(3)) , articleMetier.getOne(new Long(1))));
//		
//		iViewMetier.save(new View(null, "accepted",reviewerRepository.getOne(new Long(3)) , articleMetier.getOne(new Long(2))));
//		
//		
//		
		articleMetier.articleAccepted().forEach(a->{
			System.out.println(a.toString());
		});
		
		
////		
		
		
	}

	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

}
