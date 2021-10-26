/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Membre;

/**
 *
 * @author everyone
 */
public interface IMembreService {
    
    public void ajouterMembre(Membre m);
    public void modifierMembre(Membre m);  
    public void supprimerMembre(Membre m);
    public void afficherMembre();


}
