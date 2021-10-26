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
public class Theme {
    private int id_theme ;
    private String nom_theme ;
    private int capacite;
    private int nbr_participant;
    private boolean visibilite ;
    
    
    public Theme(){}
    
    public Theme(int id_theme,String nom_theme,int capacite,int nbr_participant,boolean visibilite){
        this.id_theme=id_theme;
        this.nom_theme=nom_theme;
        this.capacite=capacite;
        this.nbr_participant=nbr_participant;
        this.visibilite=visibilite;
        
    }   
    
    public int getIdTheme(){
    return id_theme;
    }
    public void setTheme(int id){
    this.id_theme=id;
    }
    
    public int getCapacite(){
    return capacite;
    }
    public void setCapacite(int id){
    this.capacite=id;
    }
    
    public int getNbrParticipant(){
    return nbr_participant;
    }
    public void setNbrParticipant(int id){
    this.nbr_participant=id;
    }
    
    public String getNomTheme(){
    return nom_theme;
    }
    public void setNomTheme(String nom){
    this.nom_theme=nom;
    }
    
    public boolean getVisibilite(){
    return visibilite;
    }
    public void setVisibilite(boolean visibilite){
    this.visibilite=visibilite;
    }
}
