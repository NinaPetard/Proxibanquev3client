/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gtm.domaineClient;


import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Robinson
 * Codage de la classe Compte de l'application Client
 */

public class Compte {


    //Attributs
    private Long idcompte;   
    private BigDecimal solde;
    private String typec;
    private BigDecimal interet;  
    private BigDecimal decouvert; 
    private Client idclient;
    private List<Virement> virementList;
    private List<Virement> virementList1;

    //Constructeur
    public Compte() {
    }

    public Compte(Long idcompte) {
        this.idcompte = idcompte;
    }

    public Compte(Long idcompte, BigDecimal solde, String typec, BigDecimal interet, BigDecimal decouvert) {
        this.idcompte = idcompte;
        this.solde = solde;
        this.typec = typec;
        this.interet = interet;
        this.decouvert = decouvert;
    }

    //Getters et setters
    public Long getIdcompte() {
        return idcompte;
    }

    public void setIdcompte(Long idcompte) {
        this.idcompte = idcompte;
    }

    public BigDecimal getSolde() {
        return solde;
    }

    public void setSolde(BigDecimal solde) {
        this.solde = solde;
    }

    public String getTypec() {
        return typec;
    }

    public void setTypec(String typec) {
        this.typec = typec;
    }

    public BigDecimal getInteret() {
        return interet;
    }

    public void setInteret(BigDecimal interet) {
        this.interet = interet;
    }

    public BigDecimal getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(BigDecimal decouvert) {
        this.decouvert = decouvert;
    }

    public Client getIdclient() {
        return idclient;
    }

    public void setIdclient(Client idclient) {
        this.idclient = idclient;
    }


    public List<Virement> getVirementList() {
        return virementList;
    }

    public void setVirementList(List<Virement> virementList) {
        this.virementList = virementList;
    }

    public List<Virement> getVirementList1() {
        return virementList1;
    }

    public void setVirementList1(List<Virement> virementList1) {
        this.virementList1 = virementList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcompte != null ? idcompte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compte)) {
            return false;
        }
        Compte other = (Compte) object;
        if ((this.idcompte == null && other.idcompte != null) || (this.idcompte != null && !this.idcompte.equals(other.idcompte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.gtm.domaine.Compte[ idcompte=" + idcompte + " ]";
    }
    
}
