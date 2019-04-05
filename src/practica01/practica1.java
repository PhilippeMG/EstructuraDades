package practica01;


import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class practica1 {

    /**
     * Método que toma dos conjuntos de enteros y separa los elementos entre aquellos que sólo aparecen una vez
     * y aquellos que aparecen repetidos. El método modifica los conjuntos que toma como parámetros.
     *
     * @param unicos    A la entrada un conjunto de enteros. A la sálida los elementos que solo aparecen en uno de
     *                  los conjuntos.
     * @param repetidos A la entrada un conjunto de enteros. A la salida los elementos que aparecen en ambos conjuntos.
     */
    static public void separa(Set<String> unicos, Set<String> repetidos) {
        // TODO

        Set<String> conjunto = new HashSet<>();
        conjunto.addAll(unicos);
        conjunto.retainAll(repetidos);
        unicos.addAll(repetidos);
        unicos.removeAll(conjunto);
        repetidos.removeAll(unicos);


    }


    /**
     * Toma un iterador a una colección de enteros positivos y devuelve como resultado un conjunto con aquellos elementos
     * de la colección que no son múltiplos de algún otro de la colección. Los ceros son descartados
     *
     * @param iter Iterador a una colección de enteros
     * @return Conjunto de de enteros.
     */
    static public Set<Integer> filtra(Iterator<Integer> iter) {
        //TODO
        Set<Integer> devolver = new HashSet<Integer>();
        while (iter.hasNext()) {
            Integer valor = iter.next();
            if (valor > 0) {
                if (devolver.isEmpty())
                    devolver.add(valor);
                else {
                    Iterator<Integer> iter2 = devolver.iterator();
                    boolean añadir = false;
                    Set<Integer> borrar = new HashSet<Integer>();

                    for (Integer elemento : devolver) {
                        if (valor % elemento != 0) añadir = true;

                        if (elemento != valor && elemento % valor == 0) borrar.add(elemento);

                    }
                    if (añadir) devolver.add(valor);
                    devolver.removeAll(borrar);
                }
            }
        }
        return devolver;

    }

    /**
     * Toma una colección de conjuntos de <i>String</i> y devuelve como resultado un conjunto con aquellos <i>String </i>
     * Que aparecen en al menos dos conjuntos de la colección.
     *
     * @param col Coleccion de conjuntos de <i>String</i>
     * @return Conjunto de <i>String</i> repetidos.
     */
    static public Set<String> repetidos(Collection<Set<String>> col) {
        // TODO
        return null;
      /*  Set<String> devolver = new HashSet<String>();
        Set<String> aux = new HashSet<String>();

        Iterator<Set<String>> iter = col.iterator();

        while (iter.hasNext()) {

            Set<String> a = iter.next();
            if (aux.isEmpty()) {
                aux.addAll(a);
            } else {

                Iterator<String> iter2 = a.iterator();
                while (iter2.hasNext()) {

                    String element = iter2.next();
                    if (aux.contains(element)) {
                        devolver.add(element);
                    }

                }
                aux.addAll(a);

            }
        }
        return devolver;*/
    }
}
