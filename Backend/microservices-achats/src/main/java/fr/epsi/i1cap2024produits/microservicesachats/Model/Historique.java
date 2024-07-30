package fr.epsi.i1cap2024produits.microservicesachats.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "historique")
public class Historique {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "achat_id")
    private Long id;
    @Column(name = "utilisateur_id ")
    private Long utilisateur_id;
    @Column(name = "produit_id")
    private Long produit_id;
    @Column(name = "quantite")
    private int quantite;
    @Column(name = "date_achat")
    private LocalDate date_achat;

    public Historique() {

    }

    public Historique(Long utilisateur_id, Long produit_id, int quantite, LocalDate date_achat) {
        this.utilisateur_id = utilisateur_id;
        this.produit_id = produit_id;
        this.quantite = quantite;
        this.date_achat = date_achat;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUtilisateur_id() {
        return utilisateur_id;
    }

    public void setUtilisateur_id(Long utilisateur_id) {
        this.utilisateur_id = utilisateur_id;
    }

    public Long getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(Long produit_id) {
        this.produit_id = produit_id;
    }

    public int getQuantite() {
        return quantite;
    }
}