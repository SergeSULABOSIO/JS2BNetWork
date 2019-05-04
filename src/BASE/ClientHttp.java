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
//import javax.net.ssl.HttpsURLConnection;

public class ClientHttp {
    private static String str_UTF8 = "UTF-8";
    private static String str_POST = "POST";
    private static String str_APP_JSON = "application/json; charset=UTF-8";
    private static String str_content_type = "Content-Type";

    public ClientHttp(String lienHttp, String corps, CallBackReponse callBackPost) {
        try {
            post(lienHttp, corps, callBackPost);
        } catch (Exception ioe) {
            callBackPost.onErreur("Erreur !");
            ioe.printStackTrace();
        }
    }

    private void post(String postUrl, String data, CallBackReponse callBackPost) throws IOException {
        Thread th = new Thread() {
            public void run() {
                try {
                    if(callBackPost != null){
                        callBackPost.onProcessing("Connexion en cours...");
                    }
                    URL url = new URL(postUrl);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setConnectTimeout(5000);
                    con.setRequestProperty(str_content_type, str_APP_JSON);
                    con.setDoOutput(true);
                    con.setDoInput(true);
                    con.setRequestMethod(str_POST);
                    //Envoi des données
                    OutputStream os = con.getOutputStream();
                    os.write(data.getBytes(str_UTF8));
                    os.close();
                    //Lectue de données venant du serveur
                    InputStream in = new BufferedInputStream(con.getInputStream());
                    String resultatServeur = IOUtils.toString(in, str_UTF8);
                    //Fermeture des flux de communication
                    in.close();
                    con.disconnect();
                    //Renvoi du callBack
                    
                    if(callBackPost != null){
                        callBackPost.onSucess(resultatServeur);
                    }
                } catch (Exception e) {
                    if(callBackPost != null){
                        callBackPost.onErreur(e.getMessage());
                    }
                    e.printStackTrace();
                }
            }
        };
        th.start();
    }
}

























