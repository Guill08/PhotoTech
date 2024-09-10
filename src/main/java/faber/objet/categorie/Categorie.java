package faber.objet.categorie;

import java.util.ArrayList;

public class Categorie  {
    private String libelle="";
    private String code="";
    private ArrayList<Categorie> collectionSouSCategories = new ArrayList<>();
    private int niveau =0;
    private int id =0;
    public Categorie(String libelle, String code,int id) {
        this.libelle = libelle;
        this.code = code;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public ArrayList<Categorie> getCollectionSouSCategories() {
        return collectionSouSCategories;
    }

    public void setCollectionSouSCategories(ArrayList<Categorie> collectionSouSCategories) {
        this.collectionSouSCategories = collectionSouSCategories;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
