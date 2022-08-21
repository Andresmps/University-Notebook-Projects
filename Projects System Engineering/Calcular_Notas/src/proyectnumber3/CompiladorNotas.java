package proyectnumber3;

import java.util.ArrayList;

/**
 *
 * @author Camilo Martínez
 */
public class CompiladorNotas {

    private String nombreMateria = "No definida.";
   
    private ArrayList<Nota> notas;
    int contador = -1;

    public CompiladorNotas(String nombreMateria) {
        notas = new ArrayList<>();
        this.nombreMateria = nombreMateria;

    }

    public void agregarNota(String nombre, double porcentaje, String descripcion) {

        Nota nota1 = new Nota(nombre, porcentaje, descripcion);
        notas.add(nota1);

        contador++;
    }

    public void cambiarPorcentajeNota(String nombre, double porcentaje) {

        Nota nomb = buscarNotaPorNombre(nombre);

        for (int i = notas.size() - 1; i >= 0; i--) {
            if (nomb != null && nomb.getNombre().equals(notas.get(i).getNombre())) {
                notas.get(i).cambiarPorcentaje(porcentaje);
            }
        }

    }

    public void asignarNota(String nombre, double nota) {

        Nota nomb = buscarNotaPorNombre(nombre);

        for (int i = notas.size() - 1; i >= 0; i--) {
            if (nomb != null && nomb.getNombre().equals(notas.get(i).getNombre())) {
                notas.get(i).cambiarNotaObtenida(nota);
            }
        }

    }

    public void eliminarNota(String indice) {
        
        int i = Integer.parseInt(indice);
        if (i < notas.size()) {
            notas.remove(i);
        }

    }

    public void eliminarNot(String nombre) {
        
        Nota nomb = buscarNotaPorNombre(nombre);
        
        for (int i = notas.size() - 1; i >= 0; i--) {
            
            if (nomb != null && nomb.getNombre().equals(notas.get(i).getNombre())) {
                notas.remove(i);
            }
        }

    }
    

    private Nota buscarNotaPorNombre(String nombre) {

        for (int i = notas.size() - 1; i >= 0; i--) {
            
            if (notas != null && nombre.equals(notas.get(i).getNombre())) {
                return notas.get(i);

            }
        }
        return null;
    }

    public double darNotaOptenida() {

        double notaMateria = 0;
            
        if (darPorcentaje() == 100.0) {
            
            for (int i = notas.size()-1; i >= 0; i--) {
                if (notas != null) {
                    notaMateria += (notas.get(i).getNotaObtenida() * notas.get(i).getPorcentaje());
                }
            }
        } else {
            notaMateria = -1;
        }

        return notaMateria;
    }

    public double darPorcentaje() {
        double percent = 0;
        for (int i = notas.size()-1; i >= 0; i--) {
            percent += notas.get(i).getPorcentaje();
        }
        percent *= 100.0;
        return percent;
    }

    public String darNombreMateria(String nombreMateria) {

        return nombreMateria;
    }

    @Override
    public String toString() {

        String mensaje = "";
        for (int i = 0; i < notas.size(); i++) {
            mensaje += i + ":{nombre: " + notas.get(i).getNombre() + ", porcentaje: " + notas.get(i).getPorcentaje() + ", descripcion: " + notas.get(i).getDescripcion() + ", nota: " + notas.get(i).getNotaObtenida() + "}\n";
        }

        return mensaje;
    }

}
