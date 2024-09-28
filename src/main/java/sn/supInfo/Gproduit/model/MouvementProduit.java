package sn.supInfo.Gproduit.model;

import jakarta.persistence.*;
import sn.supInfo.Gproduit.constant.TypeMouv;

import java.util.Date;
@Entity
public class MouvementProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date dateMouv;
    private TypeMouv typeMouv;
    private double qte;
    @ManyToOne
    private  Produit produit;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateMouv() {
        return dateMouv;
    }

    public void setDateMouv(Date dateMouv) {
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
