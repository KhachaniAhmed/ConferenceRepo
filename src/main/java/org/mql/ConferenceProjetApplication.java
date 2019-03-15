<<<<<<< HEAD
package org.mql;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.mql.dao.ReviewerRepository;
import org.mql.entities.Article;
import org.mql.entities.Chair;
import org.mql.entities.Domaine;
import org.mql.entities.Jury;
import org.mql.entities.Reviewer;
import org.mql.entities.Role;
import org.mql.entities.User;
import org.mql.entities.View;
import org.mql.metier.IAccountMetier;
import org.mql.metier.IArticleMetier;
import org.mql.metier.IChairMetier;
import org.mql.metier.IDomaineMetier;
import org.mql.metier.IJuryMetier;
import org.mql.metier.IPresentationMetier;
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
	@Autowired
	private IJuryMetier iJuryMetier;
	@Autowired
	private IPresentationMetier  iPresentationMetier;
	
	private List<Reviewer> reviewers = new ArrayList<Reviewer>();
	private List<Domaine> domaines = new ArrayList<Domaine>();

	public static void main(String[] args) {
		SpringApplication.run(ConferenceProjetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Role role1 = accountMetier.saveRole(new Role(null, "REVIEWER"));
//		Role role2 = accountMetier.saveRole(new Role(null, "AUTHOR"));
//		Role role3 = accountMetier.saveRole(new Role(null, "CHAIR"));
//		Role role4 = accountMetier.saveRole(new Role(null, "JURY"));
//		Role role5 = accountMetier.saveRole(new Role(null, "KEYNOTE"));
		
//		chairMetier.save(new Chair(null, "ali", "AitBassou", role2));	
//		chairMetier.save(new Chair(null, "hisham", "al agaad", role2));	
//		chairMetier.save(new Chair(null, "ahmed", "khachani", role2));	
//		User user1 = accountMetier.saveUser(new User(null, "admin", "123", role1));
//		User user2 = accountMetier.saveUser(new User(null, "user", "123", role2));
//		accountMetier.addRoleToUser("admin", "ADMIN");
//		accountMetier.addRoleToUser("user", "USER");
		User user = accountMetier.findUserByUsername("admin");
//		System.out.println(user.toString());
//		Stream.of("technologie", "science", "art").forEach(d -> {
//			Domaine domaine = domaineMetier.create(new Domaine(null, d));
//            domaines.add(domaine);
//		});
//		domaines.forEach(d->{
//			reviewerRepository.save(new Reviewer(null, null, null, role1, d));
//		}); 
//		iViewMetier.save(new View(null, "accepted",reviewerRepository.getOne(new Long(5)) , articleMetier.getOne(new Long(5))));
//		
//		
//		iViewMetier.save(new View(null, "accepted",reviewerRepository.getOne(new Long(4)) , articleMetier.getOne(new Long(4))));
//		
//		articleMetier.articleAccepted().forEach(a -> {
//			System.out.println(a.toString());
//
//		});
//		iPresentationMetier.getAllPresentationNotAffected().forEach(System.out::println);
//		iJuryMetier.save(new Jury(null, "ahmed", "khachani", "ahmed@gmail.com"));
//		iJuryMetier.save(new Jury(null, "jamal", "zaydan", "jamal@gmail.com"));
//		iJuryMetier.save(new Jury(null, "ali", "aitbaou", "ali@gmail.com"));
//		iJuryMetier.save(new Jury(null, "hisham", "agadd hisham", "hisham@gmail.com"));
		iPresentationMetier.getAllPresentationNotAffected().forEach(System.out::println);                                              
	}

	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

}
=======
package org.mql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.mql.dao.ReviewerRepository;
import org.mql.entities.*;
import org.mql.metier.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	@Autowired
	private IJuryMetier iJuryMetier;
	@Autowired
	private IPresentationMetier  iPresentationMetier;
	@Autowired
	private EmailServiceImpl emailService;

	private List<Reviewer> reviewers = new ArrayList<Reviewer>();
	private List<Domaine> domaines = new ArrayList<Domaine>();

	public static void main(String[] args) {
		SpringApplication.run(ConferenceProjetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Role role1 = accountMetier.saveRole(new Role(null, "ADMIN"));
//		Role role2 = accountMetier.saveRole(new Role(null, "USER"));
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
//			reviewerRepository.save(new Reviewer(null, user1.getUsername()+'h', user1.getPassword(), role1, d));
//		}); 

//		Mail mail = new Mail();
//		mail.setTo("aitbassouali@gmail.com");
//		mail.setSubject("Sending Email with Thymeleaf HTML Template Example");
//
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("name", "Jon Doe");
//		model.put("location", "Morocco");
//		model.put("signature", "http://memorynotfound.com");
//		mail.setModel(model);
//
//		emailService.sendSimpleMessageWithTemplate(mail);
	}

	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

}
>>>>>>> ede5f616b8d41d6b2ada50c191bec9aa3861ec29
