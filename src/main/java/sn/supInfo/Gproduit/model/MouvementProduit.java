package sn.supInfo.Gproduit.model;

import jakarta.persistence.*;
import sn.supInfo.Gproduit.constant.TypeMouv;

import java.util.Date;
@Entity
public class MouvementProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String dateMouv;
    private TypeMouv typeMouv;
    private double qte;
    @ManyToOne(cascade = CascadeType.ALL)
    private  Produit produit;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDateMouv() {
        return dateMouv;
    }

    public void setDateMouv(String dateMouv) {
        this.dateMouv = dateMouv;
    }

    public TypeMouv getTypeMouv() {
        return typeMouv;
    }

    public void setTypeMouv(TypeMouv typeMouv) {
        this.typeMouv = typeMouv;
    }

    public double getQte() {
        return qte;
    }

    public void setQte(double qte) {
        this.qte = qte;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
