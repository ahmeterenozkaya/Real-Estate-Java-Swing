/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toprakemlak06;

/**
 *
 * @author ozkay
 */
public class City {
    private int id;
    private String firstname;
    private String lastname;
    private String numberphone;
    private String identity;
    private String address;
    private String ada;
    private String parsel;
    private String notlar;

    

    public City(int id, String firstname, String lastname, String numberphone, String identity, String address, String ada, String parsel, String notlar) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.numberphone = numberphone;
        this.identity = identity;
        this.address = address;
        this.ada = ada;
        this.parsel = parsel;
        this.notlar = notlar;

    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNumberphone() {
        return numberphone;
    }

    public void setNumberphone(String numberphone) {
        this.numberphone = numberphone;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAda() {
        return ada;
    }

    public void setAda(String ada) {
        this.ada = ada;
    }

    public String getParsel() {
        return parsel;
    }

    public void setParsel(String parsel) {
        this.parsel = parsel;
    }
    
    public String getNotlar() {
        return notlar;
    }

    public void setNotlar(String notlar) {
        this.notlar = notlar;
    }
    
   
}
