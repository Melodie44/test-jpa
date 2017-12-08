import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Article;

public class TestJpa {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = emf.createEntityManager();

		// Afficher un article en fonction de sa ref
		TypedQuery<Article> query1 = em.createQuery("SELECT a FROM Article a WHERE a.ref = 'A01'", Article.class);
		
		Article article = query1.getSingleResult();
		
		System.out.println(article);
		
		// Afficher la liste des articles
		TypedQuery<Article> query2 = em.createQuery("SELECT a FROM Article a", Article.class);
		
		List<Article> articles = query2.getResultList();
		
		for (Article art : articles) {
			System.out.println(art);
		}
	}
}
