/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author everyone
 */
public enum role {
    Admin("Admin"),Membre("Membre");
     private String value;
    
    role(String value){
this.value=value;
}
    public String toString(){
            return value;
    }

    public static class membre {

        public membre() {
        }
    }
   
        
    
}
