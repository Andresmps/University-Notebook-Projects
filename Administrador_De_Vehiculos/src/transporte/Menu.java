/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transporte;

import java.util.Scanner;

/**
 *
 * @author camil
 */
public class Menu {

    private Scanner scan;
    private AdministradorDeVehiculos administrador = new AdministradorDeVehiculos();
    final private int FURGON = 2;
    final private int AVION = 3;
    final private int CAMION = 4;

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.desplegarMenu();
    }

    public Menu() {
        scan = new Scanner(System.in);
    }

    public void desplegarMenu() {

        String mensaje = "";

        mensaje += "Menú biblioteca, digite alguna de las siguiente opciones:";
        mensaje += "\n\t1. Precargar sistema.";
        mensaje += "\n\t2. Ingresar vehículo.";
        mensaje += "\n\t3. Mostrar vehículos terrestres.";
        mensaje += "\n\t4. Mostrar vehículos aéreos.";
        mensaje += "\n\t5. Dar cotización viaje.";
        mensaje += "\n\t6. Registrar viaje.";
        mensaje += "\n\t7. Dar viajes vehículo.";
        mensaje += "\n\t8. Dar resumen de viajes.";
        mensaje += "\n\t0. Salir.";
        System.out.println(mensaje);
        int opcion = Integer.parseInt(scan.nextLine());
        menu(opcion);
    }

    public void menu(int opcion) {

        switch (opcion) {

            case 1:
                precargarSistema();
                break;
            case 2:
                ingresarVehiculo();
                break;
            case 3:
                mostrarVehiculosTerrestres();
                break;
            case 4:
                mostrarVehiculosAereos();
                break;
            case 5:
                darCotizacion();
                break;
            case 6:
                registrarViaje();
                break;
            case 7:
                darViajesVehiculo();
                break;
            case 8:
                darResumenDeViajes();
                break;
            case 0:
                System.exit(0);
                break;
        }
        System.out.println("");
        desplegarMenu();
    }

    public void precargarSistema() {
        System.out.println("Usted ha seleccionado la opción 1, precargar vehículos.");

        administrador.precargarSistema();

        System.out.println("\nSalida:");
        System.out.println("Los Vehículos han sido agregados.");
    }

    public void ingresarVehiculo() {

        System.out.println("Usted ha seleccionado la opción 2, agregar vehículo.");
        System.out.println("Ingrese la información del vehículo: ");

        String vehiculo = scan.nextLine();
        String[] datosVehiculo = vehiculo.split("&");

        System.out.println("\nSalida:");

        switch (datosVehiculo.length) {
            case FURGON:
                administrador.agregarFurgon(datosVehiculo[0],
                        Integer.parseInt(datosVehiculo[1]));

                System.out.println("El furgón ha sido agregado.");
                break;
            case CAMION:
                administrador.agregarCamion(datosVehiculo[0],
                        Integer.parseInt(datosVehiculo[1]),
                        Integer.parseInt(datosVehiculo[2]),
                        Integer.parseInt(datosVehiculo[3]));

                System.out.println("El camión ha sido agregado.");
                break;
            case AVION:
                administrador.agregarAvion(datosVehiculo[0],
                        Integer.parseInt(datosVehiculo[1]),
                        Integer.parseInt(datosVehiculo[2]));

                System.out.println("El avión ha sido agregado.");
                break;
            default:
                break;
        }
    }

    public void mostrarVehiculosTerrestres() {

        System.out.println("Usted ha seleccionado la opción 3, mostrar vehiculos terrestres.");
        System.out.println("\nSalida:");
        System.out.println(administrador.mostrarTerrestres());
    }

    public void mostrarVehiculosAereos() {

        System.out.println("Usted ha seleccionado la opción 4, mostrar vehiculos aereos.");
        System.out.println("\nSalida:");
        System.out.println(administrador.mostrarAereos());
    }

    public void darCotizacion() {

        System.out.println("Usted ha seleccionado la opción 5, dar cotización.");
        System.out.println("Ingrese los datos del viaje:");

        String entrada = scan.nextLine();
        String[] datos = entrada.split("&");
        
        int distanciaKilometros = Integer.parseInt(datos[0]);
        int peso = Integer.parseInt(datos[1]);

        System.out.println("\nSalida:");
        System.out.println(administrador.darCotizacion(distanciaKilometros, peso));
    }

    public void registrarViaje() {

        System.out.println("Usted ha seleccionado la opción 6, registrar viaje.");
        System.out.println("Ingrese los datos del viaje:");

        String entrada = scan.nextLine();
        String[] datos = entrada.split("&");

        System.out.println("\nSalida:");
        
        int costo = administrador.registrarViajePrincipal(Integer.parseInt(datos[0]),Integer.parseInt(datos[1]), datos[2]);
        System.out.println("El viaje se ha registrado con un costo de "+costo+".");
    }

    public void darViajesVehiculo() {
        
        System.out.println("Usted ha seleccionado la opción 7, mostrar autores viajes vehículo.");
        System.out.println("Ingrese la placa del vehículo:");

        String placa = scan.nextLine();

        System.out.println("\nSalida:");
        System.out.println(administrador.mostrarViajesVehiculo(placa));
    }

    public void darResumenDeViajes() {
        
        System.out.println("Usted ha seleccionado la opción 6, mostrar viajes.");

        System.out.println("\nSalida:");
        System.out.println(administrador.mostrarTotalViajes());
    }

}
// Hola Mundo :V