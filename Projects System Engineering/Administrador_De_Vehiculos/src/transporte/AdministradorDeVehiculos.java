/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transporte;

import java.util.ArrayList;

/**
 *
 * @author camil
 */
public class AdministradorDeVehiculos {

    protected ArrayList<Vehiculos> coleccionVehiculos = new ArrayList<Vehiculos>();

    public void precargarSistema() {

        agregarFurgon("WER154", 800);
        agregarFurgon("FSD326", 500);
        agregarCamion("ERT202", 2000, 4, 0);
        agregarCamion("DBZ004", 1000, 6, 20000);
        agregarAvion("HK6514", 7500, 2);
        agregarAvion("HK9986", 30000, 6);

    }

    public void agregarFurgon(String placa, int capacidadCargaKilogramos) {
        coleccionVehiculos.add(new Furgon(placa, capacidadCargaKilogramos));
    }

    public void agregarCamion(String placa, int capacidadCargaKilogramos, int numeroEjes, int cargaRemolque) {

        coleccionVehiculos.add(new Camion(placa, capacidadCargaKilogramos, numeroEjes, cargaRemolque));
    }

    public void agregarAvion(String placa, int capacidadCargaKilogramos, int numeroMotores) {
        coleccionVehiculos.add(new Avion(placa, capacidadCargaKilogramos, numeroMotores));

    }

    public String mostrarTerrestres() {

        String toJson = "{\"vehiculosTerrestres\": [";

        for (int i = 0; i < coleccionVehiculos.size(); i++) {
            if (coleccionVehiculos.get(i) instanceof Furgon) {
                Furgon furgon = (Furgon) coleccionVehiculos.get(i);
                toJson += "\n" + furgon.toJson() + ",";
            }
            if (coleccionVehiculos.get(i) instanceof Camion) {
                Camion camion = (Camion) coleccionVehiculos.get(i);
                toJson += "\n" + camion.toJson() + ",";
            }
        }

        if (coleccionVehiculos.size() > 0) {
            toJson = toJson.substring(0, toJson.length() - 1);
        }
        toJson += "\n]}";

        return toJson;
    }

    public String mostrarAereos() {

        String toJson = "{\"VehiculosAereos\": [";

        for (int i = 0; i < coleccionVehiculos.size(); i++) {
            if (coleccionVehiculos.get(i) instanceof Avion) {
                Avion avion = (Avion) coleccionVehiculos.get(i);
                toJson += "\n" + avion.toJson() + ",";
            }

        }
        if (coleccionVehiculos.size() > 0) {
            toJson = toJson.substring(0, toJson.length() - 1);
        }
        toJson += "\n]}";

        return toJson;
    }

    public String darCotizacion(int distanciaKilometros, int peso) {

        String toJson = "{\"opciones\":[";
        boolean condicionCamion;
        
        for (int i = 0; i < coleccionVehiculos.size(); i++) {
            Vehiculos vehiculo = coleccionVehiculos.get(i);
            condicionCamion = false;
            if (vehiculo instanceof Camion) {
                condicionCamion = ((Camion) vehiculo).getCargaMaxima() >= peso;
            }

            if (vehiculo.capacidadCargaKilogramos >= peso || condicionCamion ) {

                String medio = "";
                if (vehiculo instanceof Terrestre) {
                    medio = "tierra";

                } else if (vehiculo instanceof Aereo) {
                    medio = "aire";
                }
                toJson += formatoOpcion(coleccionVehiculos.get(i).placa, medio, coleccionVehiculos.get(i).costo(distanciaKilometros));

            }
        }
        if (coleccionVehiculos.size() > 0) {
            toJson = toJson.substring(0, toJson.length() - 1);
        }

        toJson += "\n]}";

        return toJson;
    }

    public String formatoOpcion(String placa, String medio, int costo) {

        String toJson = "\n{\"placa\": \"" + placa + "\", \"medio\": \"" + medio + "\", \"costo\": " + costo + "},";

        return toJson;
    }

    public String darTipoClase(Vehiculos vehiculo) {

        if (vehiculo instanceof Furgon) {
            return "Furgon";
        } else if (vehiculo instanceof Camion) {
            return "Camion";
        } else if (vehiculo instanceof Avion) {
            return "Avion";
        }

        return "";
    }

    public int registrarViajePrincipal(int distanciaKilometros, int peso, String placa) {

        int costo = 0;
        boolean condicionCamion;

        for (int i = 0; i < coleccionVehiculos.size(); i++) {
            Vehiculos vehiculo = coleccionVehiculos.get(i);
            condicionCamion = false;
            if (vehiculo instanceof Camion) {
                condicionCamion = ((Camion) vehiculo).getCargaMaxima() >= peso;
            }

            if (costo == 0 && (vehiculo.capacidadCargaKilogramos >= peso || condicionCamion)
                    && placa.equals(vehiculo.placa)) {

                String medio = "";
                if (vehiculo instanceof Terrestre) {
                    medio = "tierra";

                } else if (vehiculo instanceof Aereo) {
                    medio = "aire";
                }

                costo = vehiculo.costo(distanciaKilometros);
                registrarViaje(vehiculo, placa, medio, distanciaKilometros, peso, costo);
                vehiculo.kilometrosRecorridos += distanciaKilometros;
                vehiculo.numeroViajesRealizados++;
            }
        }

        return costo;
    }

    public int registrarViaje(Vehiculos vehiculo, String placa, String medio, int distanciaKm, int peso, int costo) {

        vehiculo.viajesTotales.add(new Viaje(placa, distanciaKm, peso, costo, medio));
        return costo;
    }

    public String mostrarViajesVehiculo(String placa) {

        String toJson = "{\"viajes\" :[";

        for (int i = 0; i < coleccionVehiculos.size(); i++) {
            Vehiculos vehiculo = coleccionVehiculos.get(i);

            toJson += vehiculo.getFormatoViajes(vehiculo, placa);

        }

        if (coleccionVehiculos.size() > 0) {
            toJson = toJson.substring(0, toJson.length() - 1);
        }

        toJson += "\n]}";

        return toJson;
    }

    public String mostrarTotalViajes() {

        String viajesTotales = totalViajesFormato();

        return viajesTotales;
    }

    public String totalViajesFormato() {

        String toJson = "{\"totalCostos\": " + costoTotalViajes() + ", \"viajes\":[";

        for (int i = 0; i < coleccionVehiculos.size(); i++) {
            Vehiculos vehiculo = coleccionVehiculos.get(i);
            for (int j = 0; j < vehiculo.viajesTotales.size(); j++) {
                Viaje viaje = vehiculo.viajesTotales.get(j);

                toJson += "\n{\"placa\": \"" + viaje.getPlacaVehiculo() + "\", \"medio\": \""
                        + viaje.getMedio() + "\", \"distancia\": " + viaje.getDistaciaKilometros()
                        + ", \"costo\": " + viaje.getCosto() + "},";
            }
        }
        if (coleccionVehiculos.size() > 0) {
            toJson = toJson.substring(0, toJson.length() - 1);
        }
        toJson += "\n]}";
        return toJson;
    }

    public int costoTotalViajes() {

        int total = 0;

        for (int i = 0; i < coleccionVehiculos.size(); i++) {
            Vehiculos vehiculo = coleccionVehiculos.get(i);
            for (int j = 0; j < vehiculo.viajesTotales.size(); j++) {
                Viaje viaje = vehiculo.viajesTotales.get(j);
                total += viaje.getCosto();
            }
        }

        return total;
    }

}
