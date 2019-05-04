/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Callback;

/**
 *
 * @author HP Pavilion
 */
public abstract class CallBackReponse {
    
    public abstract void onSucess(Object object);
    public abstract void onErreur(String message);
    public abstract void onProcessing(String message);
    
}









