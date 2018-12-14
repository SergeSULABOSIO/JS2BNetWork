/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Callback;

import org.json.JSONObject;

/**
 *
 * @author HP Pavilion
 */
public abstract class CallBackObjetNetWork {
    public abstract void getObjetNetWork(JSONObject object);
    public abstract void getErreur(String message);
}
