/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transporte;

import java.util.ArrayList;

/**
 *
 * @author CISCO
 */
public abstract class Vehiculos{

    protected ArrayList<Viaje> viajesTotales = new ArrayList();
    static public int identificador = 1;
    protected String placa;
    protected int capacidadCargaKilogramos;
    protected int numeroViajesRealizados;
    protected int kilometrosRecorridos;
    
    public Vehiculos(int capacidadCargaKilogramos) {
        this.capacidadCargaKilogramos = capacidadCargaKilogramos;
    }

    public String getFormatoViajes(Vehiculos vehiculo, String placa) {

        String toJson = "";
        
        for (int i = 0; i < vehiculo.viajesTotales.size(); i++) {
            Viaje viaje = vehiculo.viajesTotales.get(i);
            if (viaje.getPlacaVehiculo().equals(placa)) { 
                toJson += "\n{\"distancia\": " + viaje.getDistaciaKilometros() + ", \"costo\": " + viaje.getCosto() + "},";
            }
        }
        return toJson;
    }

    public abstract int costo(int distanciaKilometros);

    public abstract String toJson();
}
