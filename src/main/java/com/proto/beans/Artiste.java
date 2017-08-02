package com.proto.beans;

import javax.persistence.*;

@Entity
public class Artiste {

    public Artiste() { }

    public Artiste(String nom) {
        this.nom = nom;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    @Column(nullable = false)
    private String nom;
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    @Column(nullable = false)
    private String prenom;
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    @Embedded
    private Adresse adresse;
    public Adresse getAdresse() { return adresse; }
    public void setAdresse(Adresse adresse) { this.adresse = adresse; }

    @Embedded
    @AttributeOverrides( {
        @AttributeOverride(name="adresse", column = @Column(name="adressePro") ),
        @AttributeOverride(name="codePostal", column = @Column(name="codePostalPro") ),
        @AttributeOverride(name="ville", column = @Column(name="villePro") )
    })
    private Adresse adressePro;
    public void setAdressePro(Adresse a) {adressePro = a;}
    public Adresse getAdressePro() {return adressePro;}
}
