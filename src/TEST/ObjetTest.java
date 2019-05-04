/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

import BASE.ObjetNetWork;

/**
 *
 * @author user
 */
public class ObjetTest extends ObjetNetWork{
    public int id;
    public String motdepasse;
    public String email;

    public ObjetTest(int id, String motdepasse, String email, String adresseServeur) {
        super(adresseServeur);
        this.id = id;
        this.motdepasse = motdepasse;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    @Override
    public String toString() {
        return "ObjetTest{" + "id=" + id + ", motdepasse=" + motdepasse + ", email=" + email + '}';
    }

    
    
}











































