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
public class Reponse {
    public int code;
    public String message;

    public Reponse() {
        this.code = -1;
        this.message = "";
    }
    
    
    public Reponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    
    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Reponse{" + "code=" + code + ", message=" + message + '}';
    }
    
    
}
