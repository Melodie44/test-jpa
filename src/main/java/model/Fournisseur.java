package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Fournisseur")
public class Fournisseur {

	@Id
	private int id;
	
	@Column(name="NOM")
	private String nom;
	
	@OneToMany(mappedBy="fournisseur")
	private List<Article> articles;
	
	@OneToMany(mappedBy="fournisseur")
	private List<Bon> bons;
	
	public Fournisseur() {
		articles = new ArrayList<Article>();
		bons = new ArrayList<Bon>();
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public List<Bon> getBons() {
		return bons;
	}

	public void setBons(List<Bon> bons) {
		this.bons = bons;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", nom=" + nom + "]";
	}

}
