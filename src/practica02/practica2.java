package practica02;

import java.util.*;

public class practica2 {

    /**
     * Comprueba si dos listas de String son equivalentes.
     * <p>
     * Dos listas son equivalentes si contienen los mismos elementos y la misma cantidad de ellos.
     *
     * @param l1 Primera lista
     * @param l2 Segunda lista
     * @return <code>true</code> si las listas son equivalentes. <code>false</code> en caso contrario.
     */
    static public boolean equivalentes(List<String> l1, List<String> l2) {
        //TODO completa la implmentación
        int posicio = 0;
        List<String> aux = new LinkedList<>();
        aux.addAll(l2);
        if (l1.size() == aux.size()) {
            for (String element : l1) {
                posicio = aux.indexOf(element);
                if (posicio < 0) return false;
                aux.remove(posicio);
            }
            if (aux.size() == 0) return true;
        }
        return false;


    }

    /**
     * Invierte el orden de los elmentos de una lista.
     *
     * @param iter Un iterador de la lista. Puede estar en cualqueir posición de la lista.
     */
    static public void invierte(ListIterator<String> iter) {
        //TODO completa la implmentación
        while (iter.hasNext()) iter.next();
        List<String> aux = new LinkedList<>();
        while (iter.hasPrevious()) {
            aux.add(iter.previous());
        }
        System.out.printf(aux.toString());
        for (String element : aux) {
            iter.next();
            iter.set(element);
        }

    }


    /**
     * Ordena los elementos de una lista de menor a mayor
     *
     * @param l La lista
     * @return Una nueva lista con los mismo elementos, pero ordenados.
     */
    static public List<Integer> ordenar(List<Integer> l) {
        //TODO completa la implmentación
        return null;
    }

}
