package org.mql.metier;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import org.mql.dao.ArticleRepository;
import org.mql.dao.UserRepository;
import org.mql.entities.Article;
import org.mql.entities.Author;
import org.mql.entities.Reviewer;
import org.mql.entities.User;
import org.mql.entities.View;
import org.mql.security.JwtTokenUtil;
import org.mql.security.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ArticleMetierImpl implements IArticleMetier {

	public static final String ACCEPTED = "ACCEPTED";
	public static final String REJECTED = "REJECTED";
	public static final String IN_IVALUATION = "IN_IVALUATION";
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private IAccountMetier accountMetier;

	
	public List<Article> getAllByUsername(HttpServletRequest request) {
		System.err.println(request);
		User user = accountMetier.getCurrentUser(request);
		if (user.getRole().getRoleName().equals("AUTHOR")) {
			return articleRepository.findByAuthorId(user.getId());
		}else if (user.getRole().getRoleName().equals("REVIEWER")) {
			Reviewer reviewer= (Reviewer) user;
			return articleRepository.findByDomaineId(reviewer.getDomain().getId());
		}
		return articleRepository.findAll();
		
	}
	
	public List<Article> getAll() {
		return articleRepository.findAll();
	}
	@Override
	public List<Article> getAllAccepted() {
		return articleRepository.findByStatusLike(ACCEPTED);
	}
	@Override
	public List<Article> getAllRejected() {
		return articleRepository.findByStatusLike(REJECTED);
	}

	@Override
	public void deleteById(Long id) {
		articleRepository.deleteById(id);
	}

	@Override
	public Article getOne(Long id) {
		return articleRepository.getOne(id);
	}

	@Override
	public Article save(HttpServletRequest request, Article article) {
		User user = accountMetier.getCurrentUser(request);
		if (!user.getRole().getRoleName().equals("AUTHOR")) {
			throw new RuntimeException("User has no authority too create a new article");
		}
		article.setAuthor((Author)user);
		return articleRepository.save(article);
	}
	
	@Override
	public Article update(Article article) {
		return articleRepository.save(article);
	}

	@Override
	public void reviewArticle(Article article) {
		articleRepository.save(article);
	}

	@Override
	public List<Article> articleAccepted() {
		return articleRepository.findByPresentationIdAndStatusLike(null, ACCEPTED);
	}
	
}
