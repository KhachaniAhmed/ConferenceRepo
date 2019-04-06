package org.mql.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.mql.entities.Article;
import org.mql.entities.Mail;
import org.mql.entities.View;
import org.mql.metier.EmailService;
import org.mql.metier.IArticleMetier;
import org.mql.metier.IViewMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Aspect
@Configuration
public class EmailSenderAspect {

    public static final int MIN_RATE = 5;
    public static final int MIN_FAVORABLE_RATE_TOBE_ACCEPTED = 2;
    public static final String ACCEPTED = "ACCEPTED";
    public static final String REJECTED = "REJECTED";
    @Autowired
    private IViewMetier iViewMetier;
    @Autowired
    private IArticleMetier iArticleMetier;
    @Autowired
    private EmailService emailService;

    @AfterReturning(pointcut = "execution(* org.mql.metier.ViewMetierImpl.save(..))", returning = "view")
    public void sendAcceptationMail(View view) {
        List<View> reviews = iViewMetier.getAllByArticleId(view.getArticle().getId());
        if (reviews.size() > MIN_FAVORABLE_RATE_TOBE_ACCEPTED) {
            Article article = view.getArticle();
            if (reviews.stream().filter(x -> x.getRate() >= MIN_RATE).collect(Collectors.toList()).size() >= MIN_FAVORABLE_RATE_TOBE_ACCEPTED)
                article.setStatus(ACCEPTED);
            else article.setStatus(REJECTED);
            iArticleMetier.update(article);
            sendMail(article);
        }
    }

    public void sendMail(Article article){
        Mail mail = new Mail();
		//mail.setTo(article.getAuthor().getEmail());
        mail.setTo("aitbassoualii@gmail.com ");
		mail.setSubject("Votre article a été accepté");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("name", article.getAuthor().getUsername());
		model.put("location", "Maroc");
		model.put("signature", "http://localhost:4200/payments/"+article.getId());
		mail.setModel(model);

		emailService.sendSimpleMessageWithTemplate(mail);
    }
}
