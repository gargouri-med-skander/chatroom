/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Theme;

/**
 *
 * @author everyone
 */
public interface IThemeService {
    public void ajouterTheme(Theme t);
    public void modifierTheme(Theme t);  
    public void supprimerTheme(Theme t);
    public void afficherTheme();
}
