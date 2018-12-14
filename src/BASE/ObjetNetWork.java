/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BASE;

import Callback.CallBackObjetNetWork;
import Callback.CallBackObjetNetWorks;
import Callback.CallBackReponse;
import java.lang.reflect.Field;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author HP Pavilion
 */
public abstract class ObjetNetWork {
    
    private static Vector<Constante> constante = new Vector<>();
    protected static String adresseServeur;

    public ObjetNetWork(String adresseServeur) {
        this.adresseServeur = adresseServeur;
        setConstantes(constante);
    }

    public void initConstantes(){
        setConstantes(constante);
    }
    
    public static String getConstanteS(int code, Class NomClasse) {
        String rep = "INCONNU";
        for (Constante co : constante) {
            if (co.getCode() == code && NomClasse.equals(co.getNomClasse())) {
                return co.getValeur();
            }
        }
        return rep;
    }

    public static int getConstanteI(String valeur) {
        int rep = -1;
        for (Constante co : constante) {
            if (co.getValeur().equals(valeur)) {
                return co.getCode();
            }
        }
        return rep;
    }

    public static JSONObject getJSON(Class NomClasse, Object object) {
        JSONObject objJSON = null;
        try {
            objJSON = new JSONObject();
            for (Field attribut : NomClasse.getFields()) {
                objJSON.put(attribut.getName(), attribut.get(object) + "");
            }
        } catch (Exception e) {
            e.printStackTrace();
            objJSON = null;
        }
        return objJSON;
    }

    public static Object getObjet(Class NomClasse, JSONObject objJSON) {
        Object obj = null;
        try {
            obj = NomClasse.newInstance();
            for (Field attribut : NomClasse.getFields()) {
                //System.out.println("**"+attribut);
                if (objJSON.has(attribut.getName())) {
                    if (attribut.getType() == int.class) {
                        attribut.set(obj, objJSON.getInt(attribut.getName()));
                    } else if (attribut.getType() == double.class) {
                        attribut.set(obj, objJSON.getDouble(attribut.getName()));
                    } else {
                        attribut.set(obj, objJSON.get(attribut.getName()) + "");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj = null;
        }
        return obj;
    }

    public static Vector getListe(Class NomClasse, JSONArray jSONArray) {
        Vector<Object> lisObjects = new Vector<Object>();
        try {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject js_utilisateur = jSONArray.getJSONObject(i);
                Object utt = getObjet(NomClasse, js_utilisateur);
                lisObjects.add(utt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lisObjects;
    }

    
    public void POST_CHARGER(String adresseServeur, String parametres, CallBackObjetNetWork callBackObjetNetWork) {
        //www.s2b-simple.com/sepcongo/json/SEPProcesseur.php?action=101&id=27&idUtilisateur=27
        //String url = "http://www.s2b-simple.com/sepcongo/json/SEPProcesseur.php?action=101&id=" + id + "&idUtilisateur=" + idUtilisateur;
        parametres = adresseServeur + "?" + parametres;
        parametres = parametres.replaceAll(" ", "%20");
        try {
            ClientHttp clientHttp = new ClientHttp(parametres, new JSONObject(), new CallBackReponse() {
                @Override
                public void setResultat(Object objet) {
                    try {
                        JSONObject jSONObject = new JSONObject(objet + "");
                        callBackObjetNetWork.getObjetNetWork(jSONObject);
                    } catch (Exception e) {
                        e.printStackTrace();
                        callBackObjetNetWork.getErreur(e.getMessage());
                    }
                }

                @Override
                public void setErreur(String message) {
                    callBackObjetNetWork.getErreur(message);
                }
            });
        } catch (Exception e) {
            callBackObjetNetWork.getErreur(e.getMessage());
            e.printStackTrace();
        }
    }

    public void POST_AJOUTER(String parametres, Object NewObjetc, CallBackReponse callBackReponse) {
        //http://www.s2b-simple.com/sepcongo/json/SEPProcesseur.php?action=100&idUtilisateur=27
        //String url = "http://www.s2b-simple.com/sepcongo/json/SEPProcesseur.php?action=100&idUtilisateur=" + idUtilisateur;
        parametres = adresseServeur + "?" + parametres;
        parametres = parametres.replaceAll(" ", "%20");
        try {
            JSONObject jSONObject = getJSON(NewObjetc.getClass(), NewObjetc);
            ClientHttp clientHttp = new ClientHttp(parametres, jSONObject, new CallBackReponse() {
                @Override
                public void setResultat(Object objet) {
                    try {
                        Reponse reponse = (Reponse) getObjet(Reponse.class, new JSONObject(objet + ""));
                        callBackReponse.setResultat(reponse);
                    } catch (Exception e) {
                        callBackReponse.setErreur(e.getMessage());
                        e.printStackTrace();
                    }
                }

                @Override
                public void setErreur(String message) {
                    callBackReponse.setErreur(message);
                }
            });

        } catch (Exception e) {
            callBackReponse.setErreur(e.getMessage());
            e.printStackTrace();
        }
    }

    public void POST_SUPPRIMER(String adresseServeur, String parametres, CallBackReponse callBackReponse) {
        //http://www.s2b-simple.com/sepcongo/json/SEPProcesseur.php?action=105&id=36&idUtilisateur=27
        //String url = "http://www.s2b-simple.com/sepcongo/json/SEPProcesseur.php?action=105&id=" + id + "&idUtilisateur=" + idUtilisateur;
        parametres = adresseServeur + "?" + parametres;
        parametres = parametres.replaceAll(" ", "%20");
        try {
            ClientHttp clientHttp = new ClientHttp(parametres, new JSONObject(), new CallBackReponse() {
                @Override
                public void setResultat(Object objet) {
                    try {
                        Reponse reponse = (Reponse) getObjet(Reponse.class, new JSONObject(objet + ""));
                        callBackReponse.setResultat(reponse);
                    } catch (Exception e) {
                        callBackReponse.setErreur(e.getMessage());
                        e.printStackTrace();
                    }
                }

                @Override
                public void setErreur(String message) {
                    callBackReponse.setErreur(message);
                }
            });

        } catch (Exception e) {
            callBackReponse.setErreur(e.getMessage());
            e.printStackTrace();
        }

    }

    public void POST_LISTE(String parametres, Object critere, CallBackObjetNetWorks callBackObjetNetWorks) {
        //http://www.s2b-simple.com/sepcongo/json/SEPProcesseur.php?action=103&pageEncours=1&taillePage=100&idUtilisateur=27
        //String lien = "http://www.s2b-simple.com/sepcongo/json/SEPProcesseur.php?action=103&pageEncours=" + pageEncours + "&taillePage=" + taillePage + "&idUtilisateur=" + idUtilisateur;
        parametres = adresseServeur + "?" + parametres;
        parametres = parametres.replaceAll(" ", "%20");
        try {
            JSONObject cri = getJSON(critere.getClass(), critere);
            ClientHttp clientHttp = new ClientHttp(parametres, cri, new CallBackReponse() {
                @Override
                public void setResultat(Object objet) {
                    try {
                        JSONArray tabObj = new JSONArray(objet + "");
                        callBackObjetNetWorks.getObjetNetWorks(tabObj);
                    } catch (Exception e) {
                        e.printStackTrace();
                        callBackObjetNetWorks.getErreur(e.getMessage());
                    }
                }

                @Override
                public void setErreur(String message) {
                    callBackObjetNetWorks.getErreur(message);
                }
            });
        } catch (Exception e) {
            callBackObjetNetWorks.getErreur(e.getMessage());
            e.printStackTrace();
        }
    }

    public void POST_MODIFIER(String parametres, Object newObjct, CallBackReponse callBackReponse) {
        //http://www.s2b-simple.com/sepcongo/json/SEPProcesseur.php?action=104&idUtilisateur=24
        //String url = "http://www.s2b-simple.com/sepcongo/json/SEPProcesseur.php?action=104&idUtilisateur=" + idUtilisateur;
        parametres = adresseServeur + "?" + parametres;
        parametres = parametres.replaceAll(" ", "%20");
        try {
            JSONObject js_util = getJSON(newObjct.getClass(), newObjct);
            ClientHttp clientHttp = new ClientHttp(parametres, js_util, new CallBackReponse() {
                @Override
                public void setResultat(Object objet) {
                    try {
                        Reponse reponse = (Reponse) getObjet(Reponse.class, new JSONObject(objet + ""));
                        callBackReponse.setResultat(reponse);
                    } catch (Exception e) {
                        callBackReponse.setErreur(e.getMessage());
                        e.printStackTrace();
                    }
                }

                @Override
                public void setErreur(String message) {
                    callBackReponse.setErreur(message);
                }
            });

        } catch (Exception e) {
            callBackReponse.setErreur(e.getMessage());
            e.printStackTrace();
        }

    }

    public abstract void setConstantes(Vector<Constante> constante);
    
    public abstract void NetWork_supprimer(int idObj, int idUtilisateur, CallBackReponse callBackReponse);
    
    public abstract void NetWork_modifier(int idUtilisateur, Object newObjet, CallBackReponse callBackReponse);
    
    public abstract void NetWork_login(String email, String motdepasse, CallBackObjetNetWork callBackObjetNetWork);
    
    public abstract void NetWork_charger_via_idObj(int idObj, int idUtilisateur, CallBackObjetNetWork callBackObjetNetWork);
    
    public abstract void NetWork_enregistrer(int idUtilisateur, Object newObjet, CallBackReponse callBackReponse);
    
    public abstract void NetWork_lister(String dateA, String dateB, int idUtilisateur, int pageEncours, int taillePage, Object objCritere, CallBackObjetNetWorks callBackObjetNetWorks);

}
