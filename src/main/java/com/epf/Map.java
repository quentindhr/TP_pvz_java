package com.epf;
public class Map {

    private int  id_map;
    private int ligne;
    private int colonne;
    private String chemin_image;



    public Map(int id_map, int ligne, int colonne, String chemin_image) {
        this.id_map = id_map;
        this.ligne = ligne;
        this.colonne = colonne;
        this.chemin_image = chemin_image;
    }
    

    public int getId_map() {
        return this.id_map;
    }

    public void setId_map(int id_map) {
        this.id_map = id_map;
    }

    public int getLigne() {
        return this.ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public int getColonne() {
        return this.colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public String getChemin_image() {
        return this.chemin_image;
    }

    public void setChemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }
    

}
