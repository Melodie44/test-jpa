package ihm;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Article;
import model.Bon;
import model.Fournisseur;

public class TestInsert {

	private static final Logger LOG = LoggerFactory.getLogger(TestInsert.class);

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();

		// Insérer un Article en BDD
		List<Bon> bons = new ArrayList<Bon>();
		bons.add(em.find(Bon.class, 2));
		
		Article article = new Article();
		article.setId(1100000);
		article.setRef("Z99");
		article.setDesignation("tronçonneuse");
		article.setPrix(50);
		article.setFournisseur(em.find(Fournisseur.class, 2));
		article.setBons(bons);
		
		em.persist(article);

		// Insérer un Bon en BDD
		
		Article art = new Article();
		art.setId(1100001);
		art.setRef("Z98");
		art.setDesignation("Hache");
		art.setPrix(20);
		art.setFournisseur(em.find(Fournisseur.class, 3));
		
		List<Article> articles = new ArrayList<Article>();
		articles.add(art);
		articles.add(em.find(Article.class, 3));
		
		Bon bon = new Bon();
		LocalDateTime date = LocalDateTime.now();
		
		bon.setId(7);
		bon.setNumero(7);
		bon.setDate(date);
		bon.setDelai(1);
		bon.setFournisseur(em.find(Fournisseur.class, 3));
		bon.setArticles(articles);
		
		em.persist(bon);
		et.commit();
		
		em.close();
		emf.close();

	}

}
