/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author pedro
 */
public class TattooArtist {
 
    private int id;
    private String name;
    private String tel;
    private String login;
    private String passw;

    public TattooArtist(String name, String tel, String login, String passw) {
        this.name = name;
        this.tel = tel;
        this.login = login;
        this.passw = passw;
    }

    public TattooArtist(int id, String name, String tel, String login, String passw) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.login = login;
        this.passw = passw;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }
    
    @Override
    public String toString() {
        return getName();
    }
}
