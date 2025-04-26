package com.epf;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public class Plante {
    private int id_plante;
    private String nom;
    private int point_de_vie;
    private float attaque_par_seconde;
    private int degat_attaque;
    private int cout;
    private int soleil_par_seconde;
    private effet effet;
    private String chemin_image;

    public enum effet {
    NORMAL("normal"),
    SLOW_LOW("slow low"),
    SLOW_MEDIUM("slow medium"),
    SLOW_STOP("slow stop");

    private final String label;

    effet(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }

    @JsonCreator
    public static effet fromLabel(String label) {
        for (effet e : values()) {
            if (e.label.equalsIgnoreCase(label)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Effet inconnu : " + label);
    }
}
    
    public Plante() {
    }

    public Plante(int id_plante, String nom, int point_de_vie, float attaque_par_seconde, int degat_attaque, int cout, int soleil_par_seconde, effet effet, String chemin_image) {
        this.id_plante = id_plante;
        this.nom = nom;
        this.point_de_vie = point_de_vie;
        this.attaque_par_seconde = attaque_par_seconde;
        this.degat_attaque = degat_attaque;
        this.cout = cout;
        this.soleil_par_seconde = soleil_par_seconde;
        this.effet = effet;
        this.chemin_image = chemin_image;
    }


    public int getId_plante() {
        return this.id_plante;
    }

    public void setId_plante(int id_plante) {
        this.id_plante = id_plante;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPoint_de_vie() {
        return this.point_de_vie;
    }

    public void setPoint_de_vie(int point_de_vie) {
        this.point_de_vie = point_de_vie;
    }

    public float getAttaque_par_seconde() {
        return this.attaque_par_seconde;
    }

    public void setAttaque_par_seconde(float attaque_par_seconde) {
        this.attaque_par_seconde = attaque_par_seconde;
    }

    public int getDegat_attaque() {
        return this.degat_attaque;
    }

    public void setDegat_attaque(int degat_attaque) {
        this.degat_attaque = degat_attaque;
    }

    public int getCout() {
        return this.cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public int getSoleil_par_seconde() {
        return this.soleil_par_seconde;
    }

    public void setSoleil_par_seconde(int soleil_par_seconde) {
        this.soleil_par_seconde = soleil_par_seconde;
    }

    public effet getEffet() {
        return this.effet;
    }

    public void setEffet(effet effet) {
        this.effet = effet;
    }

    public String getChemin_image() {
        return this.chemin_image;
    }

    public void setChemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }



}
