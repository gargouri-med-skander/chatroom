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
public enum gender {
    female("female"),male("male");
    private final String value;
    
    private gender(String value){
this.value=value;
}
    @Override
    public String toString(){
            return value;
    }
}
