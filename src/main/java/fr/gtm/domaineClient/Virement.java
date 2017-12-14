/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gtm.domaineClient;


import java.math.BigInteger;
import java.util.Date;


/**
 *
 * @author Robinson
 */

public class Virement  {

    
    private Long idvirement;
    private BigInteger montant;
    private Date datev;
    private Compte idcomptedebit;
    private Compte idcomptecredit;

    public Virement() {
    }

    public Virement(Long idvirement) {
        this.idvirement = idvirement;
    }

    public Long getIdvirement() {
        return idvirement;
    }

    public void setIdvirement(Long idvirement) {
        this.idvirement = idvirement;
    }

    public BigInteger getMontant() {
        return montant;
    }

    public void setMontant(BigInteger montant) {
        this.montant = montant;
    }

    public Date getDatev() {
        return datev;
    }

    public void setDatev(Date datev) {
        this.datev = datev;
    }

    public Compte getIdcomptedebit() {
        return idcomptedebit;
    }

    public void setIdcomptedebit(Compte idcomptedebit) {
        this.idcomptedebit = idcomptedebit;
    }

    public Compte getIdcomptecredit() {
        return idcomptecredit;
    }

    public void setIdcomptecredit(Compte idcomptecredit) {
        this.idcomptecredit = idcomptecredit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvirement != null ? idvirement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Virement)) {
            return false;
        }
        Virement other = (Virement) object;
        if ((this.idvirement == null && other.idvirement != null) || (this.idvirement != null && !this.idvirement.equals(other.idvirement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.gtm.domaine.Virement[ idvirement=" + idvirement + " ]";
    }
    
}