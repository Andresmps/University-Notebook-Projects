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
public class Furgon extends Terrestre {

    private int identificador;
    final static private int NUMERO_EJES = 2;
 
    public Furgon(String placa, int capacidadCargaKilogramos) {
        super(placa, capacidadCargaKilogramos);
        this.identificador = super.identificador++;
    }
   
    public int getNumeroEjes() {
        return NUMERO_EJES;
    }

    @Override
    public int costo(int distanciaKilometros) {
        return 1000 * NUMERO_EJES * distanciaKilometros;
    }
    
    @Override
    public String toJson() {

        String toJson = "{\"id\": "+identificador+", "+"\"placa\": \""+placa+"\", \"carga\": "+capacidadCargaKilogramos+", \"ejes\": "+
                NUMERO_EJES+", \"viajes\": "+numeroViajesRealizados+", \"kilometraje\": "+
                kilometrosRecorridos+"}";

        return toJson;
    }

}
