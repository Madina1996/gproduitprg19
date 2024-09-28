package sn.supInfo.Gproduit.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String code;
    private String designation;
    private double prixU;
    private int qte;
    private double montantS;
    @ManyToOne
    private Categorie categorie;

    @OneToMany(mappedBy = "produit")
    private List<MouvementProduit> mouvementProduits = new ArrayList<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrixU() {
        return prixU;
    }

    public void setPrixU(double prixU) {
        this.prixU = prixU;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public double getMontantS() {
        return montantS;
    }

    public void setMontantS(double montantS) {
        this.montantS = montantS;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<MouvementProduit> getMouvementProduits() {
        return mouvementProduits;
    }

    public void setMouvementProduits(List<MouvementProduit> mouvementProduits) {
        this.mouvementProduits = mouvementProduits;
    }
}
