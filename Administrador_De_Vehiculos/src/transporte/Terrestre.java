/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transporte;

/**
 *
 * @author camil
 */
public abstract class Terrestre extends Vehiculos {
    
    public Terrestre(String placa, int capacidadCargaKilogramos){
        super(capacidadCargaKilogramos) ;
        this.placa = placa;
        
    }
    
}
