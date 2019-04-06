package practica03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Banco {
    public HashMap<String, Integer> cuentas = new HashMap<>();                // Mapa con las cuentas y su saldos
    public HashMap<String, List<Transferencia>> desglose = new HashMap<>();  // Mapa con las trasnferencias por cada cuenta

    public Banco(List<String> codigos, List<Integer> saldos) {
       //TODO Implementar constructor
    }

    /**
     * Realiza una una trasnferencia entres dos cuentas modificando su saldo. Guarda la transferencia en un histórico.
     *
     *
     * @param tr La transferencia. Los códigos de cuenta deben existir y ser distintos de <i>null</i>. La cuenta origen debe
     *           tener saldo positivo suficiente para realizar la transferencia.
     * @return <i>True</i> si la transferencia fue posible.
     * @throws <i>IllegalArgumentExcpetion</i> si alguna de las cuentas no existe, o el código es <i>null</i>.
     */
    public boolean asiento(Transferencia tr) {
        //TODO Metodo por implementar
        return false;
    }

    /**
     * Devuelve el saldo de una cuenta
     * @param codigo Código de la cuenta. Debe ser distinto <i>null</i> y existir.
     * @return El saldo de la cuenta.
     * @throws <i>IllegalArgumentException</i> si el código de cuenta no es válido.
     */
    public Integer consulta(String codigo) {
        //TODO Metodo por implementar
        return null;
    }

    /**
     *  Devuelve el histórico de transferencias entre dos cuentas.
     * @param primera Código válido de cuenta
     * @param segunda Código válido de cuenta
     * @return Lista de transferencias. El código <i> primera</i> siempre aparecerá como cuenta de origen de cada
     *          transferencia. En caso de el código de cuenta sea el mismo la lista estará vacía.
     * @throws <i>IllegalArgumentExcpetion</i> si alguno de los códigos de cuenta no son válidos.
     */
    public List<Transferencia> historico(String primera, String segunda) {
        // TODO Metodo por implementar
        return null;
    }

    public String toString() {
        StringBuilder bf = new StringBuilder("Banco - cuentas {\n") ;

        for (String cod: cuentas.keySet())
            bf.append("  " + cod + ": " +cuentas.get(cod)+ "\n");


        bf.append("} - size:" + cuentas.size());

        return bf.toString();
    }

    public String toStringDesglose() {
        StringBuilder bf = new StringBuilder("Banco - desglose {\n");

        for (String cod: desglose.keySet())
            bf.append("  " + cod + ": " + desglose.get(cod));


        bf.append("}");
        return bf.toString();
    }

}
