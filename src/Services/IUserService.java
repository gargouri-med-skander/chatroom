/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.User;

/**
 *
 * @author everyone
 */
public interface IUserService {
    
    public void ajouterUser(User u);
    public void modifierUser(User u);  
    public void supprimerUser(User u);
    public void afficherUser();
    
}
