package practica01;


import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class practica1 {

    /**
     *  Método que toma dos conjuntos de enteros y separa los elementos entre aquellos que sólo aparecen una vez
     *  y aquellos que aparecen repetidos. El método modifica los conjuntos que toma como parámetros.
     * @param unicos    A la entrada un conjunto de enteros. A la sálida los elementos que solo aparecen en uno de
     *                  los conjuntos.
     * @param repetidos A la entrada un conjunto de enteros. A la salida los elementos que aparecen en ambos conjuntos.
     */
    static public void separa(Set<String> unicos, Set<String> repetidos) {
        // TODO
    }

    /**
     *  Toma un iterador a una colección de enteros positivos y devuelve como resultado un conjunto con aquellos elementos
     *  de la colección que no son múltiplos de algún otro de la colección. Los ceros son descartados
     * @param iter  Iterador a una colección de enteros
     * @return Conjunto de de enteros.
     */
    static public Set <Integer> filtra(Iterator<Integer> iter) {
        //TODO
        return null;
    }

    /**
     * Toma una colección de conjuntos de <i>String</i> y devuelve como resultado un conjunto con aquellos <i>String </i>
     * Que aparecen en al menos dos conjuntos de la colección.
     * @param col Coleccion de conjuntos de <i>String</i>
     * @return Conjunto de <i>String</i> repetidos.
     */
    static public Set<String> repetidos(Collection<Set<String>> col) {
        // TODO
        return null;
    }
}
