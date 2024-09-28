package sn.supInfo.Gproduit.service.DTO;

import sn.supInfo.Gproduit.constant.TypeMouv;

import java.util.Date;

public class MouvementProduitDTO {


    private long id;
    private Date dateMouv;
    private TypeMouv typeMouv;
    private double qte;
    private long produitId;


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

    public long getProduitId() {
        return produitId;
    }

    public void setProduitId(long produitId) {
        this.produitId = produitId;
    }
}
