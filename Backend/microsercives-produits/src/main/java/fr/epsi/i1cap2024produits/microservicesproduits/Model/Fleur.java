package fr.epsi.i1cap2024produits.microservicesproduits.Model;

import jakarta.persistence.*;
@Entity
@Table(name= "fleur" )
public class Fleur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String couleur;
    private String type;
    private String saisonFloraison;
    private Double hauteur;
    private Double largeur;
    private String exposition;
    private String besoinEau;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSaisonFloraison() {
        return saisonFloraison;
    }

    public void setSaisonFloraison(String saisonFloraison) {
        this.saisonFloraison = saisonFloraison;
    }

    public Double getHauteur() {
        return hauteur;
    }

    public void setHauteur(Double hauteur) {
        this.hauteur = hauteur;
    }

    public Double getLargeur() {
        return largeur;
    }

    public void setLargeur(Double largeur) {
        this.largeur = largeur;
    }

    public String getExposition() {
        return exposition;
    }

    public void setExposition(String exposition) {
        this.exposition = exposition;
    }

    public String getBesoinEau() {
        return besoinEau;
    }

    public void setBesoinEau(String besoinEau) {
        this.besoinEau = besoinEau;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
