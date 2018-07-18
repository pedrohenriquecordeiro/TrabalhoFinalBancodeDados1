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
public class Client {
    
    private int iduser;
    private String name;
    private String tel;
    private int age;
    private String next_session;
    private String local_picture;
    private int tattoo_artist;

      
     public Client(String nm, String tel, int age, String next_session, String local_picture,int tattoo_artist) {
        this.name = nm;
        this.tel = tel;
        this.age = age;
        this.next_session = next_session;
        this.local_picture = local_picture;
        this.tattoo_artist = tattoo_artist;
    }

    public Client(int iduser , String nm, String tel, int age, String next_session, String local_picture,int tattoo_artist) {
        this.iduser = iduser;
        this.name = nm;
        this.tel = tel;
        this.age = age;
        this.next_session = next_session;
        this.local_picture = local_picture;
        this.tattoo_artist = tattoo_artist;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNext_session() {
        return next_session;
    }

    public void setNext_session(String next_session) {
        this.next_session = next_session;
    }

    public String getLocal_picture() {
        return local_picture;
    }

    public void setLocal_picture(String local_picture) {
        this.local_picture = local_picture;
    }

    public int getTattoo_artist() {
        return tattoo_artist;
    }

    public void setTattoo_artist(int tattoo_artist) {
        this.tattoo_artist = tattoo_artist;
    }
    
    
     @Override
    public String toString() {
        return getName();
    }
    
}
