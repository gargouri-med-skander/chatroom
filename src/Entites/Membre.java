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
public class Membre extends User{
    
    
 
    private profession Profession ;
    
    
    
  
    
    
    public Membre(int id_user,String nom,String  prenom ,String gmail, String password  ,LocalDate date_naissance,gender Gender,role Role,profession Profession){
   super(id_user,nom,prenom,gmail,password,date_naissance,Gender,Role);
   this.Profession=Profession ;
    
}
 
    public profession getProfession(){
    return Profession;
    }
    public void setProfession(profession Profession){
    this.Profession=Profession;
    }
    
   
    }
    


