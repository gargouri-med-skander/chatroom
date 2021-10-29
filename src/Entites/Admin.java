/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author everyone
 */
public class Admin extends User {
    
    private int num_poste;
    private String adresse ;
    
    
    
    public Admin(int id_user,String nom,String  prenom ,String gmail, String password  ,LocalDate date_naissance,gender Gender,role Role,int num_poste,String adresse){
    super(id_user,nom,prenom,gmail,password,date_naissance,Gender,Role);
    this.num_poste=num_poste;
    this.adresse=adresse;
    }

    public Admin() {
  
    }
    
    
    
    public int getNumPoste(){
    return num_poste;
    }
    public void setNumPoste(int id){
    this.num_poste=id;
    }
    
    public String getAdresse(){
    return adresse;
    }
    public void setAdresse(String adresse){
    this.adresse=adresse;
    }
    
    
}
