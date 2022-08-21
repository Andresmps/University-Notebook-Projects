/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerenclase2;

/**
 *
 * @author CISCO
 */
public class PoemAnalysisLinearListExtension extends ArrayLinearList {

    // Crea la lista por las lineas que recibe
    
    public void crearListaLineal(String line) {

        String palabras[] = line.split(" ");
 
        for (String palabra : palabras) {
            add(size(), palabra);
        }
    }

    // Retorna el número de veces que está la palabra en la lista
    public int palabrasRepetidas(String palabra) {

        int palabrasRepetidas = 0; 
        
        for (int i = 0; i < size(); i++) {
            if (get(i).equals(palabra)) {
                palabrasRepetidas++;
            }
        }

        return palabrasRepetidas;
    }

    // Intercambia todas las palabrasUno por las palabrasDos, al igual que todas las palabrasDos por las 
    //  palabras Uno, que se encuentren en la lista 
    
    public void intercambiarPalabras(String palabraUno, String palabraDos) {

        for (int i = 0; i < size(); i++) {
            if (get(i).equals(palabraUno)) { 
                remove(i);
                add(i, palabraDos); 
            }else if (get(i).equals(palabraDos)) {
                remove(i);
                add(i, palabraUno); 
            }
        }
        
    }

    
    // Convierte la lista en un String y lo retorna 
    public String newFile(String palabraUno, String palabraDos) {
        
        String textoPlano = ""; 
        intercambiarPalabras(palabraUno, palabraDos);

        for (int i = 0; i < size(); i++) {
            
            String palabra = get(i)+"";
            textoPlano += palabra+" ";
            if ( palabra.charAt(palabra.length()-1) == '.' ) {
                textoPlano += "\r\n";
            }
            
        }
        return textoPlano;
    }

}
