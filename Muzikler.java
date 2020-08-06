/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aliha
 */
public class Muzikler {
    private int id;
    private String şarkı_ismi;

    public Muzikler(int id, String şarkı_ismi) {
        this.id = id;
        this.şarkı_ismi = şarkı_ismi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getŞarkı_ismi() {
        return şarkı_ismi;
    }

    public void setŞarkı_ismi(String şarkı_ismi) {
        this.şarkı_ismi = şarkı_ismi;
    }
    
}
