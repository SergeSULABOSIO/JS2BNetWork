/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BASE;

/**
 *
 * @author HP Pavilion
 */
public class Constante {
    public int code;
    public String valeur;
    public Class NomClasse;

    public Constante(int code, String valeur, Class NomClasse) {
        this.code = code;
        this.valeur = valeur;
        this.NomClasse = NomClasse;
    }

    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public Class getNomClasse() {
        return NomClasse;
    }

    public void setNomClasse(Class NomClasse) {
        this.NomClasse = NomClasse;
    }

    @Override
    public String toString() {
        return "Constante{" + "code=" + code + ", valeur=" + valeur + ", NomClasse=" + NomClasse + '}';
    }

    
    
}
