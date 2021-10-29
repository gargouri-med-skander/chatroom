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
public class User {
    private int id_user ;
    private String nom ;
    private String  prenom ;
    private String gmail ;
    private String password  ;
    private LocalDate date_naissance ;
    private gender Gender ;
    private role Role ;
    
    
    public User(int id_user,String nom,String  prenom ,String gmail, String password  ,LocalDate date_naissance,gender Gender,role Role){
   this.id_user =id_user;
     this.nom =nom;
    this.prenom =prenom;
    this.gmail =gmail;
     this.password =password ;
   this.date_naissance=date_naissance ;
    this.Gender =Gender;
    this.Role =Role;
    }

    public User() {
       
    }

    public User(String prenom, String nom, String gmail) {
        
        this.prenom = prenom;
        this.nom = nom;
        this.gmail = gmail;
      
    }


   
    public int getIdUser(){
    return id_user;
    }
    public void setIdUser(int id){
    this.id_user=id;
    }
    
   
    public String getNom(){
    return nom;
    }
    public void setNom(String nom){
    this.nom=nom;
    }
    
   
    public String getPrenom(){
    return prenom;
    }
    public void setPrenom(String prenom){
    this.prenom=prenom;
    }
    
   
    public String getGmail(){
    return gmail;
    }
    public void setGmail(String gmail){
    this.gmail=gmail;
    }
    
   
    public String getPassword(){
    return password;
    }
    public void setPassword(String password){
    this.password=password;
    }
    
    
    public LocalDate getDateNaissance(){
    return date_naissance;
    }
    public void setDateNaissance(LocalDate date_naissance){
    this.date_naissance=date_naissance;
    }
    
    
    
    
    public gender getGender(){
    return Gender;
    }
    public void setGender(gender Gender){
    this.Gender=Gender;}
    
   
    
    public role getRole(){   
    return Role;
    }
     public void setRole(role Role){
    this.Role=Role;}

  
    
    
    
    
}
