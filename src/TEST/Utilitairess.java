/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.json.JSONObject;

/**
 *
 * @author user
 */
public class Utilitairess {
    
    public static int TAILLE_PAGE = 20;
    public static int ACTION_UTILISATEUR_LISTER = 103;
    public static int ACTION_UTILISATEUR_AJOUT = 100;
    public static int ACTION_UTILISATEUR_CHARGER_VIA_ID = 101;
    public static int ACTION_UTILISATEUR_CHARGER_VIA_EMAIL_MOT_DE_PASSE = 102;
    public static int ACTION_UTILISATEUR_MODIFICATION = 104;
    public static int ACTION_UTILISATEUR_SUPPRESSION = 105;
    public static String LIEN_SERVEUR = "http://www.s2b-simple.com/sepcongo/json/SEPProcesseur.php";
    
    public static final String Fichier_Connexion = "Connexion.json";
    
    
    public static void main(String[] a){
        Utilisateur utilisateur = new Utilisateur();
        lireFichier();
        
    }
    
    public static Utilisateur lireFichier() {
        Utilisateur util = null;
        String data = "";
        if (new File(Fichier_Connexion).exists() == true) {
            try {
                FileReader reader = new FileReader(Fichier_Connexion);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    data = data + line;
                }
                reader.close();

                //On transforme le texte lu en Objet JSON, puis en Objet Utilisateur
                if (data.length() != 0) {
                    System.out.println("JSON1 : " + data.toString());
                    util = (Utilisateur) Utilisateur.getObjet(Utilisateur.class, new JSONObject(data.toString()));
                    System.out.println("JSON2 : " + util.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Fichier_Connexion = " + util.toString());
        }
        return util;
    }
    
}
