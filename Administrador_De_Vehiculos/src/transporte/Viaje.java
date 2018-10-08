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
public class Viaje {

    private String placaVehiculo;
    private int distaciaKilometros;
    private int peso;
    private int costo;
    private String medio;

    public String getMedio() {
        return medio;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public int getDistaciaKilometros() {
        return distaciaKilometros;
    }

    public int getPeso() {
        return peso;
    }
    
    public int getCosto() {
        return costo;
    }
    
    public Viaje(String placaVehiculo, int distaciaKilometros, int peso, int costo, String medio){
        this.placaVehiculo = placaVehiculo;
        this.distaciaKilometros = distaciaKilometros;
        this.peso = peso;
        this.costo = costo;
        this.medio = medio;
    }
    
}
