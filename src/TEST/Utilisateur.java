/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

import BASE.Constante;
import BASE.ObjetNetWork;
import Callback.CallBackObjetNetWork;
import Callback.CallBackObjetNetWorks;
import Callback.CallBackReponse;
import java.util.Vector;

/**
 *
 * @author HP Pavilion
 */
public class Utilisateur extends ObjetNetWork {

    public int id;
    public String dateEnreg;
    public int tailleResultat;
    public String nom;
    public String postnom;
    public String prenom;
    public String adresse;
    public String telephone;
    public String email;
    public String fonction;
    public int role;			//0 = Administrateur, 1 = Invité
    public String motDePasse;
    public int idStation;
    public String nomStation;
    public int idUtilisateur;
    public String nomUtilisateur;

    public Utilisateur() {
        super(Utilitairess.LIEN_SERVEUR);
        this.id = -1;
        this.nom = "";
        this.postnom = "";
        this.prenom = "";
        this.adresse = "";
        this.telephone = "";
        this.email = "";
        this.fonction = "";
        this.role = -1;
        this.motDePasse = "";
        this.idStation = -1;
        this.nomStation = "";
        this.idUtilisateur = -1;
        this.nomUtilisateur = "";
    }

    public Utilisateur(int id, String nom, String postnom, String prenom, String adresse, String telephone, String email, String fonction, int role, String motDePasse, int idStation, String nomStation, int idUtilisateur, String nomUtilisateur, String dateEnreg, int tailleResultat) {
        super(Utilitairess.LIEN_SERVEUR);
        this.id = id;
        this.nom = nom;
        this.postnom = postnom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.fonction = fonction;
        this.role = role;
        this.motDePasse = motDePasse;
        this.idStation = idStation;
        this.nomStation = nomStation;
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateEnreg() {
        return dateEnreg;
    }

    public void setDateEnreg(String dateEnreg) {
        this.dateEnreg = dateEnreg;
    }

    public int getTailleResultat() {
        return tailleResultat;
    }

    public void setTailleResultat(int tailleResultat) {
        this.tailleResultat = tailleResultat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPostnom() {
        return postnom;
    }

    public void setPostnom(String postnom) {
        this.postnom = postnom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public int getIdStation() {
        return idStation;
    }

    public void setIdStation(int idStation) {
        this.idStation = idStation;
    }

    public String getNomStation() {
        return nomStation;
    }

    public void setNomStation(String nomStation) {
        this.nomStation = nomStation;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", dateEnreg=" + dateEnreg + ", tailleResultat=" + tailleResultat + ", nom=" + nom + ", postnom=" + postnom + ", prenom=" + prenom + ", adresse=" + adresse + ", telephone=" + telephone + ", email=" + email + ", fonction=" + fonction + ", role=" + role + ", motDePasse=" + motDePasse + ", idStation=" + idStation + ", nomStation=" + nomStation + ", idUtilisateur=" + idUtilisateur + ", nomUtilisateur=" + nomUtilisateur + '}';
    }

    public static void main(String[] a) {

        /* EXEMPLE : LISTER LE CONTENU DE LA TABLE 
        int pageEncours = 1;
        int idUtilisateur = 78;
        new Utilisateur().NetWork_lister("", "", idUtilisateur, pageEncours, Util.TAILLE_PAGE, new Utilisateur(), new CallBackObjetNetWorks() {
            @Override
            public void getObjetNetWorks(JSONArray objects) {
                try {
                    Vector<Utilisateur> utilisateurs = getListe(Utilisateur.class, objects);
                    for (Utilisateur u : utilisateurs) {
                        System.out.println("**" + u.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void getErreur(String message) {
                System.out.println("**" + message);
            }
        });*/
 /* EXEMPLE : AJOUT D'UN ENREGISTREMENT 
        int idUtilisateur = 78;
        Utilisateur newOb = new Utilisateur(-1, "SULA", "BOSCO", "Bob", "TBA", "(+243)844803514", "serge@gmail.com", "MD", 1, "adorer", 2, "", 78, "", "", 0);
        new Utilisateur().NetWork_enregistrer(idUtilisateur, newOb, new CallBackReponse() {
            @Override
            public void setResultat(Object objet) {
                Reponse reponse = (Reponse)objet;
                System.out.println("Réponse "+reponse.toString());
            }

            @Override
            public void setErreur(String message) {
                System.out.println("Erreur : "+message);
            }
        });*/
 /* EXEMPLE : CHARGER OBJET VIA SON ID 
        int idUtilisateur = 78;
        int idAcharger = 78;
        new Utilisateur().NetWork_charger_via_idObj(idAcharger, idUtilisateur, new CallBackObjetNetWork() {
            @Override
            public void getObjetNetWork(JSONObject object) {
                Utilisateur user = (Utilisateur)getObjet(Utilisateur.class, object);
                 System.out.println("Réponse : "+ user.toString());
            }

            @Override
            public void getErreur(String message) {
                System.out.println("Erreur : "+message);
            }
        });*/
 /* EXEMPLE : CHARGER OBJET VIA SON EMAIL ET MOT DE PASSE (Ces champs doivent exister dans la base de données) 
        String email = "sulabosiog@gmail.com";
        String motdepasse = "adorer";
        new Utilisateur().NetWork_login(email, motdepasse, new CallBackObjetNetWork() {
            @Override
            public void getObjetNetWork(JSONObject object) {
                Utilisateur user = (Utilisateur)getObjet(Utilisateur.class, object);
                 System.out.println("Réponse : "+ user.toString());
            }

            @Override
            public void getErreur(String message) {
                System.out.println("Erreur : "+message);
            }
        });*/
 /* EXEMPLE : MODIFICATION D'UN ENREGISTREMENT 
        int idUtilisateur = 78;
        Utilisateur newOb = new Utilisateur(88, "SULA", "BOSCOOOOO", "Bob", "TBA", "(+243)844803514", "serge@gmail.com", "MD", 1, "adorer", 2, "", 78, "", "", 0);
        new Utilisateur().NetWork_modifier(idUtilisateur, newOb, new CallBackReponse() {
            @Override
            public void setResultat(Object objet) {
                Reponse reponse = (Reponse)objet;
                System.out.println("Réponse "+reponse.toString());
            }

            @Override
            public void setErreur(String message) {
                System.out.println("Erreur : "+message);
            }
        });*/
 /* EXEMPLE : SUPPRESSION D'UN ENREGISTREMENT 
        int idUtilisateur = 78;
        int idObjASupprimer = 88;
        new Utilisateur().NetWork_supprimer(idObjASupprimer, idUtilisateur, new CallBackReponse() {
            @Override
            public void setResultat(Object objet) {
                Reponse reponse = (Reponse)objet;
                System.out.println("Réponse "+reponse.toString());
            }

            @Override
            public void setErreur(String message) {
                System.out.println("Erreur : "+message);
            }
        });*/
    }

    @Override
    public void NetWork_supprimer(int idObj, int idUtilisateur, CallBackReponse callBackReponse) {
        String parametres = "action=" + Utilitairess.ACTION_UTILISATEUR_SUPPRESSION + "&id=" + idObj + "&idUtilisateur=" + idUtilisateur;
        POST_SUPPRIMER(adresseServeur, parametres, callBackReponse);
    }

    @Override
    public void NetWork_modifier(int idUtilisateur, Object newObjet, CallBackReponse callBackReponse) {
        String parametres = "action=" + Utilitairess.ACTION_UTILISATEUR_MODIFICATION + "&idUtilisateur=" + idUtilisateur;
        POST_MODIFIER(parametres, newObjet, callBackReponse);
    }

    @Override
    public void NetWork_login(String email, String motdepasse, CallBackObjetNetWork callBackObjetNetWork) {
        String parametres = "action=" + Utilitairess.ACTION_UTILISATEUR_CHARGER_VIA_EMAIL_MOT_DE_PASSE + "&email=" + email + "&motDePasse=" + motdepasse + "&idUtilisateur=-1";
        POST_CHARGER(adresseServeur, parametres, callBackObjetNetWork);
    }

    @Override
    public void NetWork_charger_via_idObj(int idObj, int idUtilisateur, CallBackObjetNetWork callBackObjetNetWork) {
        String parametres = "action=" + Utilitairess.ACTION_UTILISATEUR_CHARGER_VIA_ID + "&id=" + idObj + "&idUtilisateur=" + idUtilisateur;
        POST_CHARGER(adresseServeur, parametres, callBackObjetNetWork);
    }

    @Override
    public void NetWork_enregistrer(int idUtilisateur, Object newObjet, CallBackReponse callBackReponse) {
        String parametres = "action=" + Utilitairess.ACTION_UTILISATEUR_AJOUT + "&idUtilisateur=" + idUtilisateur;
        POST_AJOUTER(parametres, newObjet, callBackReponse);
    }

    @Override
    public void NetWork_lister(String dateA, String dateB, int idUtilisateur, int pageEncours, int taillePage, Object objCritere, CallBackObjetNetWorks callBackObjetNetWorks) {
        String parametres = "action=" + Utilitairess.ACTION_UTILISATEUR_LISTER + "&pageEncours=" + pageEncours + "&taillePage=" + taillePage + "&idUtilisateur=" + idUtilisateur;
        POST_LISTE(parametres, objCritere, callBackObjetNetWorks);
    }

    @Override
    public void setConstantes(Vector<Constante> constante) {
        constante.add(new Constante(0, "ADMINISTRATEUR", this.getClass()));
        constante.add(new Constante(1, "INVITE", this.getClass()));
    }

}
