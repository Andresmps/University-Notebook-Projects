/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasenlazadas;

/**
 *
 * @author Camilo Martinez
 */
public class TestCase {

    public static void main(String[] args) {

        Chain<String> vString = new Chain();
        Chain<String> zString = new Chain();
        Chain<Integer> xInteger = new Chain();
        Chain<Integer> yInteger = new Chain();

        // Precargar Datos
        for (int i = 0; i < 5; i++) {
            xInteger.add(i, i);
            yInteger.add(i, i);

        }
        xInteger.sortedInsert(2);
        xInteger.sortedInsert(-5);
        xInteger.sortedInsert(1000);
        
        zString.add(zString.size, "Hola");
        zString.add(zString.size, "Mundo");
        zString.add(zString.size, "Estoy");
        zString.add(zString.size, "Usando");
        zString.add(zString.size, "Generic");
      
        vString.add(vString.size, "Eso");
        vString.add(vString.size, "Es");
        vString.add(vString.size, "Todo");
        vString.add(vString.size, "Chao");

        System.out.println("Lista X: " + xInteger + "\nLista Y: " + yInteger + "\n");
        System.out.println("Lista Z: " + zString + "\nLista V: " + vString + "\n");

//        // Count test:
//        System.out.println("Count test:\n");
//        System.out.println("Lista X: " + xInteger + "\nLista Y: " + yInteger + "\n");
//        System.out.println("En la lista X:");
//        System.out.println("El 2 se encuentra "+xInteger.count(2)+" veces.");
//        System.out.println("El -3 se encuentra "+xInteger.count(-3)+" veces.");
//        System.out.println("El -5 se encuentra "+xInteger.count(-5)+" veces.");
//        System.out.println("El 1000 se encuentra "+xInteger.count(1000)+" veces.");
//        System.out.println("");
//        
//        // Peek test:
//        System.out.println("Peek test:\n");
//        System.out.println("Lista X: " + xInteger + "\nLista Y: " + yInteger + "\n");
//        System.out.println("El primer elemento de la lista X es: " + xInteger.peek());
//        System.out.println("El primer elemento de la lista Y es: " + yInteger.peek());
//        System.out.println("X: "+xInteger);
//        System.out.println("Y: "+yInteger);
//        System.out.println("");
//        
//        // Poll test:
//        System.out.println("Poll test:\n");
//        System.out.println("Lista X: " + xInteger + "\nLista Y: " + yInteger + "\n");
//        System.out.println("El primer elemento de la lista X es: " + xInteger.poll());
//        System.out.println("El primer elemento de la lista Y es: " + yInteger.poll());
//        System.out.println("X: "+xInteger);
//        System.out.println("Y: "+yInteger);
//        System.out.println("");
//        // Contains test:
//        System.out.println("Contains test:\n");
//        System.out.println("Lista X: " + xInteger + "\nLista Y: " + yInteger + "\n");
//        System.out.println("X contiene a -5: " + xInteger.contains(-5));
//        System.out.println("X contiene a 5: " + xInteger.contains(5));
//        System.out.println("Y contiene a 4: " + xInteger.contains(4));
//        System.out.println("Y contiene a -100: " + xInteger.contains(-100));
//        System.out.println("");
//      
//        // SortedInsert test:
//        System.out.println("sortedInsert test:\n");
//        System.out.println("Lista X: " + xInteger + "\nLista Y: " + yInteger + "\n");
//
//        yInteger.sortedInsert(2);
//        yInteger.sortedInsert(-5);
//        yInteger.sortedInsert(1000);
//        System.out.println("Y: "+yInteger);
//
//        System.out.println("");
//        // Append test:
//        System.out.println("append test:\n");
//        System.out.println("x.append(y)\n");
//        System.out.println("Lista X: " + xInteger + "\nLista Y: " + yInteger + "\n");
//        xInteger.append(yInteger);
//        System.out.println("X: " + xInteger + "\nY: " + yInteger + "\n");
//        
//        System.out.println("y.append(x)\n");
//        System.out.println("Lista Y: " + yInteger + "\nLista X: " + xInteger + "\n");
//        yInteger.append(xInteger);
//        System.out.println("\nY: " + yInteger + "\n"+"X: " + xInteger);
//        
//        System.out.println("");
//
//        // RemovedDuplicates test:
//        System.out.println("removedDuplicates test:\n");
//        xInteger.sortedInsert(0);
//        xInteger.sortedInsert(1000);
//        yInteger.sortedInsert(-5);
//        yInteger.sortedInsert(3);
//        System.out.println("Lista X: " + xInteger + "\nLista Y: " + yInteger + "\n");
//        xInteger.removeDuplicate();
//        yInteger.removeDuplicate();
//        System.out.println("X: " + xInteger + "\nY: " + yInteger + "\n");
//        
//        System.out.println("");
//        // LastIndex test:
//        System.out.println("lastIndex test: \n");
//        xInteger.add(xInteger.size, 2);
//        System.out.println("Lista X: " + xInteger + "\nLista Y: " + yInteger + "\n");
//        System.out.println("La ultima aparicion de 2 en X es: "+xInteger.lastIndexOf(2));
//        System.out.println("La ultima aparicion de 5 en X es: "+xInteger.lastIndexOf(5));
//        System.out.println("La ultima aparicion de -5 en X es: "+xInteger.lastIndexOf(-5));
//        System.out.println("La ultima aparicion de 4 en X es: "+xInteger.lastIndexOf(4));
//        System.out.println("");
//        // Generic test:
//        System.out.println("Generica test: \n");
//        zString.add(zString.size, "Estoy");
//        System.out.println("Lista Z: " + zString);
//
//        System.out.println("Estoy se encuentra " + zString.count("Estoy") + " veces en Z.");
//        System.out.println("Hola se encuentra " + zString.count("Hola") + " veces en Z.");
//        System.out.println("chao se encuentra " + zString.count("chao") + " veces en Z.\n");
//        
//        System.out.println("Lista Z: " + zString);
//        System.out.println("El primer elemento de la lista Z sin eliminar es: " + zString.peek()+"\n");
//        
//        System.out.println("Lista Z: " + zString);
//        System.out.println("El primer elemento de la lista Z eliminandolo es: " + zString.poll()+"\n");
//        
//        System.out.println("Lista Z: " + zString);
//        System.out.println("Z contiene a Hola: " + zString.contains("Hola"));
//        System.out.println("Z contiene a Estoy: " + zString.contains("Estoy"));
//        System.out.println("Z contiene a Chao: " + zString.contains("Chao"));
//        System.out.println("Z contiene a Mundo: " + zString.contains("Mundo"));
//        System.out.println("");
//        
//        System.out.println("Lista Z: " + zString+ "        //        Lista V: "+vString+"\n");
//        zString.append(vString);
//        System.out.println("z.append(v)");
//        System.out.println("Z: " + zString+ "\nV: "+vString+"\n");
//        
//        
//        System.out.println("Lista Z: " + zString);
//        System.out.println("Remover los duplicados\n");
//        zString.removeDuplicate();
//        
//        System.out.println("Lista Z: " + zString);
//        System.out.println("La ultima aparicion de Mundo en Z es: "+zString.lastIndexOf("Mundo"));
//        System.out.println("La ultima aparicion de Estoy en Z es: "+zString.lastIndexOf("Estoy"));
//        System.out.println("La ultima aparicion de Generic en Z es: "+zString.lastIndexOf("Generic"));
//        System.out.println("");
    }

}
