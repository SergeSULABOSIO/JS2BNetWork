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

import Callback.CallBackReponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedInputStream;
import java.io.OutputStream;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
//import javax.net.ssl.HttpsURLConnection;

public class ClientHttp {
    private static String str_UTF8 = "UTF-8";
    private static String str_POST = "POST";
    private static String str_APP_JSON = "application/json; charset=UTF-8";
    private static String str_content_type = "Content-Type";

    public static void main(String[] args) {
        try {

            JSONObject jsonObjet = new JSONObject();
            //jsonObjet.put("id", -1);
            //jsonObjet.put("nom", "SULA");
            //jsonObjet.put("postnom", "BOSIO");
            //jsonObjet.put("age", 32);
            //System.out.println(jsonObjet);

            //Exemple : UTILISATEUR - CHARGER VIA ID
            ClientHttp clienthttp = new ClientHttp("http://www.s2b-simple.com/sepcongo/json/SEPProcesseur.php?action=101&id=27&idUtilisateur=27", jsonObjet, new CallBackReponse() {
                @Override
                public void setResultat(Object objet) {
                    System.out.println(objet);
                }

                @Override
                public void setErreur(String message) {
                    System.out.println("Exception : " + message);
                }
            });

            System.out.println("Envoie de la requête...");

        } catch (Exception ioe) {
            System.out.println("Erreur !");
            ioe.printStackTrace();
        }
    }

    public ClientHttp(String lienHttp, JSONObject corp, CallBackReponse callBackPost) {
        try {
            post(lienHttp, corp, callBackPost);
        } catch (Exception ioe) {
            callBackPost.setErreur("Erreur !");
            ioe.printStackTrace();
        }
    }

    public void post(String postUrl, JSONObject data, CallBackReponse callBackPost) throws IOException {
        Thread th = new Thread() {
            public void run() {
                try {
                    URL url = new URL(postUrl);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setConnectTimeout(5000);
                    con.setRequestProperty(str_content_type, str_APP_JSON);
                    con.setDoOutput(true);
                    con.setDoInput(true);
                    con.setRequestMethod(str_POST);
                    //Envoi des données
                    OutputStream os = con.getOutputStream();
                    os.write(data.toString().getBytes(str_UTF8));
                    os.close();
                    //Lectue de données venant du serveur
                    InputStream in = new BufferedInputStream(con.getInputStream());
                    String resultatServeur = IOUtils.toString(in, str_UTF8);
                    //Fermeture des flux de communication
                    in.close();
                    con.disconnect();
                    //Renvoi du callBack
                    
                    callBackPost.setResultat(resultatServeur);
                } catch (Exception e) {
                    callBackPost.setErreur(e.getMessage());
                    e.printStackTrace();
                }
            }
        };
        th.start();
    }
}
