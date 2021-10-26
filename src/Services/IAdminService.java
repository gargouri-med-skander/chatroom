/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Admin;

/**
 *
 * @author everyone
 */
public interface IAdminService {
    
    public void ajouterAdmin(Admin a);
    public void modifierAdmin(Admin a);  
    public void supprimerAdmin(Admin a);
    public void afficherAdmin();
    
}
