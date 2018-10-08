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
public class Camion extends Terrestre {

    private int identificador;
    private int cargaRemolque;
    private int numeroEjes;
    private int cargaMaxima;

    public Camion(String placa, int capacidadCargaKilogramos, int numeroEjes, int cargaRemolque) {

        super(placa, capacidadCargaKilogramos);
        this.numeroEjes = numeroEjes;
        this.cargaRemolque = cargaRemolque;
        this.identificador = super.identificador++;
        cargaMaxima = capacidadCargaKilogramos + cargaRemolque;
    }

    public int getCargaRemolque() {
        return cargaRemolque;
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }

    public int getCargaMaxima() {
        return cargaMaxima;
    }

    @Override
    public int costo(int distanciaKilometros) {
        return (1000 * numeroEjes * distanciaKilometros) + ((500 * numeroEjes * distanciaKilometros) / cargaMaxima);
    }
    
    @Override
    public String toJson() {

        String toJson = "{\"id\": " + identificador + ", " + "\"placa\": \""+placa+"\", \"carga\": "+capacidadCargaKilogramos + ", \"cargaRemolque\": " + cargaRemolque
                + ", \"ejes\": " + numeroEjes + ", \"viajes\": " + numeroViajesRealizados
                + ", \"kilometraje\": " + kilometrosRecorridos + "}";

        return toJson;
    }

    

}
