package proyectnumber3;

/**
 *
 * @author Camilo Martínez
 */
public class Nota {

    private String nombre;
    private double porcentaje;
    private String descripcion;
    private double notaObtenida;

    public String getNombre() {
        return nombre;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getNotaObtenida() {
        return notaObtenida;
    }

    public Nota(String nombre, double porcentaje, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.porcentaje = porcentaje;
    }

    public void cambiarNotaObtenida(double notaObtenida) {
        this.notaObtenida = notaObtenida;
    }

    public double cambiarPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
        return porcentaje;
    }

    @Override
    public String toString() {
        String mensaje = "{nombre: " + nombre + ", porcentaje: " + porcentaje + ", descripcion: " + descripcion + ", nota: " + notaObtenida + "}";
        return mensaje;
    }

}
