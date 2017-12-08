package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BON")
public class Bon {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id;
	
	@Column(name="NUMERO")
	private int numero;
	
	@Column(name="DELAI")
	private int delai;
	
	@Column(name="DATE_CMDE")
	private LocalDateTime date;
	
	@ManyToOne
	@JoinColumn(name="IDFOU")
	private Fournisseur fournisseur;
	
	@ManyToMany(mappedBy="bons")
	private List<Article> articles; 

	public Bon() {
		articles = new ArrayList<Article>();
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getDelai() {
		return delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Bon [id=" + id + ", numero=" + numero + ", delai=" + delai + ", date=" + date + ", fournisseur="
				+ fournisseur + "]";
	}
	
}
