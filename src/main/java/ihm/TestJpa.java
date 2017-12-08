package ihm;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Article;
import model.Bon;

/**
 * Classe principale lencement du programme
 * 
 * @author MAUBOIS Mélodie
 *
 */
public class TestJpa {

	private static final Logger LOG = LoggerFactory.getLogger(TestJpa.class);
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = emf.createEntityManager();

		// Afficher un article en fonction de sa ref
		/*TypedQuery<Article> query1 = em.createQuery("SELECT a FROM Article a WHERE a.ref = 'A01'", Article.class);
		
		Article article = query1.getSingleResult();
		if(article == null) {
			
			LOG.info("Article non trouvé");
			
		}else {
			
			System.out.println(article);
		}*/
		
		// Afficher la liste des articles
		/*TypedQuery<Article> query2 = em.createQuery("SELECT a FROM Article a", Article.class);
		
		List<Article> articles = query2.getResultList();
		
		if(articles.isEmpty()) {
			
			LOG.info("Pas d'article trouvé");
			
		}else {
			
			for (Article art : articles) {
				System.out.println(art);
			}
		}*/
		
		// Afficher un bon de commande avec tous ses articles
		Bon bon = em.find(Bon.class, 1);
		
		if(bon == null) {
			
			LOG.info("Pas de bon de commande trouvé");
			
		}else {
			
			LOG.info("\n Le bon de commande");
			LOG.info(bon.toString());
			
			LOG.info("\n Le fournisseur de la commande");
			LOG.info(bon.getFournisseur().toString());
			
			LOG.info("\n Les articles du bon de commande");
			bon.getArticles().stream().forEach(a -> LOG.info(a.toString()));
		}
		
		em.close();
		emf.close();
	}
}
