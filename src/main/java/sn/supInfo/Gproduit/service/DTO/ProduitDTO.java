package sn.supInfo.Gproduit.service.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ProduitDTO {

    private long id;

    @NotEmpty(message = "Le nom ne doit pas être vide")
    @Size(min = 2, max = 30, message = "Le nom doit contenir entre 2 et 30 caractères")
    private String code;

    private String designation;

    private double prixU;

    private int qte;

    private double montantS;

    private long categorieId;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
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

    public long getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(long categorieId) {
        this.categorieId = categorieId;
    }
}
