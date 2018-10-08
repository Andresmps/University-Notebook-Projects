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
public class Avion extends Aereo {

    private int identificador;
    private int numeroMotores;

    public Avion(String placa, int capacidadCargaKilogramos, int numeroMotores) {
        super(placa, capacidadCargaKilogramos);
        this.numeroMotores = numeroMotores;
        this.identificador = super.identificador++;
    }

    public int getNumeroMotores() {
        return numeroMotores;
    }

    @Override
    public String toJson() {

        String toJson = "{\"id\": " + identificador + ", " + "\"placa\": \"" + placa + "\", \"carga\": " + capacidadCargaKilogramos
                + ", \"motores\": " + numeroMotores + ", \"viajes\": " + numeroViajesRealizados
                + ", \"kilometraje\": " + kilometrosRecorridos + "}";

        return toJson;
    }

    @Override
    public int costo(int distanciaKilometros) {
        return 500000 + (250 * distanciaKilometros) + ((500 * distanciaKilometros) / (numeroMotores * capacidadCargaKilogramos));
    }

}
