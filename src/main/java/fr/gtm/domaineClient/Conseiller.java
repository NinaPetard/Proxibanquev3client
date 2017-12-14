/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gtm.domaineClient;


import java.util.List;


/**
 *
 * @author Robinson
 */
public class Conseiller {
	
    private Long idconseiller;
    private String userid;
    private String nom;
    private String prenom;
    private String password;
    private List<Client> clientList;

    public Conseiller() {
    }

    public Conseiller(Long idconseiller) {
        this.idconseiller = idconseiller;
    }

    public Conseiller(Long idconseiller, String nom, String prenom, String password) {
        this.idconseiller = idconseiller;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
    }

    public Long getIdconseiller() {
        return idconseiller;
    }

    public void setIdconseiller(Long idconseiller) {
        this.idconseiller = idconseiller;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  
    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconseiller != null ? idconseiller.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conseiller)) {
            return false;
        }
        Conseiller other = (Conseiller) object;
        if ((this.idconseiller == null && other.idconseiller != null) || (this.idconseiller != null && !this.idconseiller.equals(other.idconseiller))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.gtm.domaine.Conseiller[ idconseiller=" + idconseiller + " ]";
    }
    
}
