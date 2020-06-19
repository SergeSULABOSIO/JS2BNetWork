/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BASE;

import Callback.CallBackObjetNetWork;
import Callback.CallBackObjetNetWorks;
import Callback.CallBackReponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Vector;

/**
 *
 * @author HP Pavilion
 */
public abstract class ObjetNetWork {

    private String adresseServeur;

    public ObjetNetWork(String adresseServeur) {
        if(!adresseServeur.startsWith("https://")){
            this.adresseServeur = "https://" + adresseServeur;
        }else{
            this.adresseServeur = adresseServeur;
        }
    }

    public String getAdresseServeur() {
        return adresseServeur;
    }

    public void setAdresseServeur(String adresseServeur) {
        this.adresseServeur = adresseServeur;
    }

    public static String getJSON(Object object) {
        String jsonString = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
            //System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    public static Object getObjet(Class NomClasse, String JSONString) {
        Object obj = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            obj = mapper.readValue(JSONString, NomClasse);
            //System.out.println(obj.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static Vector getListe(Class NomClasse, String[] jSONArrayString) {
        Vector<Object> lisObjects = new Vector<Object>();
        try {
            for (int i = 0; i < jSONArrayString.length; i++) {
                String js_utilisateur = jSONArrayString[i];
                Object utt = getObjet(NomClasse, js_utilisateur);
                lisObjects.add(utt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lisObjects;
    }

    public void POST_CHARGER(String parametres, CallBackObjetNetWork callBackObjetNetWork) {
        //www.s2b-simple.com/sepcongo/json/SEPProcesseur.php?action=101&id=27&idUtilisateur=27
        //String url = "http://www.s2b-simple.com/sepcongo/json/SEPProcesseur.php?action=101&id=" + id + "&idUtilisateur=" + idUtilisateur;
        parametres = adresseServeur + "?" + parametres;
        parametres = parametres.replaceAll(" ", "%20");
        try {
            ClientHttp clientHttp = new ClientHttp(parametres, "", new CallBackReponse() {

                @Override
                public void onSucess(Object object) {
                    try {
                        callBackObjetNetWork.onDone(object + "");
                    } catch (Exception e) {
                        e.printStackTrace();
                        callBackObjetNetWork.onError(e.getMessage());
                    }
                }

                @Override
                public void onErreur(String message) {
                    callBackObjetNetWork.onError(message);
                }

                @Override
                public void onProcessing(String message) {
                    callBackObjetNetWork.onProcessing(message);
                }
            });
        } catch (Exception e) {
            callBackObjetNetWork.onError(e.getMessage());
            e.printStackTrace();
        }
    }

    public void POST_AJOUTER(String parametres, Object NewObjetc, CallBackReponse callBackReponse) {
        //http://www.s2b-simple.com/sepcongo/json/SEPProcesseur.php?action=100&idUtilisateur=27
        //String url = "http://www.s2b-simple.com/sepcongo/json/SEPProcesseur.php?action=100&idUtilisateur=" + idUtilisateur;
        parametres = adresseServeur + "?" + parametres;
        parametres = parametres.replaceAll(" ", "%20");
        try {
            String jsonString = getJSON(NewObjetc);
            ClientHttp clientHttp = new ClientHttp(parametres, jsonString, new CallBackReponse() {

                @Override
                public void onSucess(Object object) {
                    try {
                        //Reponse reponse = (Reponse) getObjet(Reponse.class, object + "");
                        callBackReponse.onSucess(object);
                    } catch (Exception e) {
                        callBackReponse.onErreur(e.getMessage());
                        e.printStackTrace();
                    }
                }

                @Override
                public void onErreur(String message) {
                    callBackReponse.onErreur(message);
                }

                @Override
                public void onProcessing(String message) {
                    callBackReponse.onProcessing(message);
                }
            });

        } catch (Exception e) {
            callBackReponse.onErreur(e.getMessage());
            e.printStackTrace();
        }
    }

    public void POST_SUPPRIMER(String parametres, CallBackReponse callBackReponse) {
        //http://www.s2b-simple.com/sepcongo/json/SEPProcesseur.php?action=105&id=36&idUtilisateur=27
        //String url = "http://www.s2b-simple.com/sepcongo/json/SEPProcesseur.php?action=105&id=" + id + "&idUtilisateur=" + idUtilisateur;
        parametres = adresseServeur + "?" + parametres;
        parametres = parametres.replaceAll(" ", "%20");
        try {
            ClientHttp clientHttp = new ClientHttp(parametres, "", new CallBackReponse() {
                
                @Override
                public void onSucess(Object object) {
                    try {
                        Reponse reponse = (Reponse) getObjet(Reponse.class, object + "");
                        callBackReponse.onSucess(reponse);
                    } catch (Exception e) {
                        callBackReponse.onErreur(e.getMessage());
                        e.printStackTrace();
                    }
                }

                @Override
                public void onErreur(String message) {
                    callBackReponse.onErreur(message);
                }

                @Override
                public void onProcessing(String message) {
                    callBackReponse.onProcessing(message);
                }
            });

        } catch (Exception e) {
            callBackReponse.onErreur(e.getMessage());
            e.printStackTrace();
        }

    }

    public void POST_LISTE(String parametres, Object critere, CallBackObjetNetWorks callBackObjetNetWorks) {
        //http://www.s2b-simple.com/sepcongo/json/SEPProcesseur.php?action=103&pageEncours=1&taillePage=100&idUtilisateur=27
        //String lien = "http://www.s2b-simple.com/sepcongo/json/SEPProcesseur.php?action=103&pageEncours=" + pageEncours + "&taillePage=" + taillePage + "&idUtilisateur=" + idUtilisateur;
        parametres = adresseServeur + "?" + parametres;
        parametres = parametres.replaceAll(" ", "%20");
        try {
            String cri = getJSON(critere);
            ClientHttp clientHttp = new ClientHttp(parametres, cri, new CallBackReponse() {
                
                @Override
                public void onSucess(Object object) {
                    try {
                        //JSONArray tabObj = new JSONArray(objet + "");
                        String[] tabJSONObjts = (String[]) object;
                        callBackObjetNetWorks.onDone(tabJSONObjts);
                    } catch (Exception e) {
                        e.printStackTrace();
                        callBackObjetNetWorks.onError(e.getMessage());
                    }
                }

                @Override
                public void onErreur(String message) {
                    callBackObjetNetWorks.onError(message);
                }

                @Override
                public void onProcessing(String message) {
                    callBackObjetNetWorks.onProgress(message);
                }
            });
        } catch (Exception e) {
            callBackObjetNetWorks.onError(e.getMessage());
            e.printStackTrace();
        }
    }

    public void POST_MODIFIER(String parametres, Object newObjct, CallBackReponse callBackReponse) {
        //http://www.s2b-simple.com/sepcongo/json/SEPProcesseur.php?action=104&idUtilisateur=24
        //String url = "http://www.s2b-simple.com/sepcongo/json/SEPProcesseur.php?action=104&idUtilisateur=" + idUtilisateur;
        parametres = adresseServeur + "?" + parametres;
        parametres = parametres.replaceAll(" ", "%20");
        try {
            String js_util = getJSON(newObjct);
            ClientHttp clientHttp = new ClientHttp(parametres, js_util, new CallBackReponse() {
                
                @Override
                public void onSucess(Object object) {
                    try {
                        Reponse reponse = (Reponse) getObjet(Reponse.class, object + "");
                        callBackReponse.onSucess(reponse);
                    } catch (Exception e) {
                        callBackReponse.onErreur(e.getMessage());
                        e.printStackTrace();
                    }
                }

                @Override
                public void onErreur(String message) {
                    callBackReponse.onErreur(message);
                }

                @Override
                public void onProcessing(String message) {
                    callBackReponse.onProcessing(message);
                }
            });

        } catch (Exception e) {
            callBackReponse.onErreur(e.getMessage());
            e.printStackTrace();
        }

    }
}








































