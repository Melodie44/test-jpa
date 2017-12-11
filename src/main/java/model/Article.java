package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Article")
public class Article {
	
	@Id
	private int id;
	
	@Column(name="REF")
	private String ref;
	
	@Column(name="DESIGNATION")
	private String designation;
	
	@Column(name="PRIX")
	private double prix;
	
	@ManyToOne
	@JoinColumn(name="IDFOU")
	private Fournisseur fournisseur;
	
	@ManyToMany
	@JoinTable(name="COMPO",
				joinColumns = @JoinColumn(name="IDARTICLE", referencedColumnName="ID"),
				inverseJoinColumns = @JoinColumn(name="IDBON", referencedColumnName="ID")
	)
	private List<Bon> bons;
	
	public Article() {
		bons = new ArrayList<Bon>();
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public List<Bon> getBons() {
		return bons;
	}

	public void setBons(List<Bon> bons) {
		this.bons = bons;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", ref=" + ref + ", designation=" + designation + ", prix=" + prix + "]";
	}
	
}
