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
        if (codigos == null || saldos == null) throw new IllegalArgumentException();
        for (int i = 0; i < codigos.size(); i++) {
            if (codigos.get(i) == null || saldos.get(i) == null || codigos.size() != saldos.size())
                throw new IllegalArgumentException();
            if (cuentas.get(codigos) == null) {
                cuentas.put(codigos.get(i), saldos.get(i));
                desglose.put(codigos.get(i), new LinkedList<Transferencia>());
            } else {
                int saldo = cuentas.get(codigos);
                cuentas.replace(codigos.get(i), saldo + saldos.get(i));

            }
        }
    }

    /**
     * Realiza una una trasnferencia entres dos cuentas modificando su saldo. Guarda la transferencia en un histórico.
     *
     * @param tr La transferencia. Los códigos de cuenta deben existir y ser distintos de <i>null</i>. La cuenta origen debe
     *           tener saldo positivo suficiente para realizar la transferencia.
     * @return <i>True</i> si la transferencia fue posible.
     * @throws <i>IllegalArgumentExcpetion</i> si alguna de las cuentas no existe, o el código es <i>null</i>.
     */
    public boolean asiento(Transferencia tr) {
        //TODO Metodo por implementar
        if (cuentas.get(tr.origen) == null || cuentas.get(tr.destino) == null) throw new IllegalArgumentException();
        System.out.printf(tr.toString());
        if (tr.cantidad >= 0 && consulta(tr.origen) < tr.cantidad) return false;
        if (tr.cantidad < 0 && consulta(tr.destino) < (tr.cantidad * -1)) return false;
        cuentas.replace(tr.origen, consulta(tr.origen) - tr.cantidad);
        cuentas.replace(tr.destino, consulta(tr.destino) + tr.cantidad);
        desglose.get(tr.origen).add(tr);
        desglose.get(tr.destino).add(tr);


        return true;
    }

    /**
     * Devuelve el saldo de una cuenta
     *
     * @param codigo Código de la cuenta. Debe ser distinto <i>null</i> y existir.
     * @return El saldo de la cuenta.
     * @throws <i>IllegalArgumentException</i> si el código de cuenta no es válido.
     */
    public Integer consulta(String codigo) {
        //TODO Metodo por implementar
        Integer saldo = cuentas.get(codigo);
        if (saldo != null) return saldo;
        throw new IllegalArgumentException();
    }

    /**
     * Devuelve el histórico de transferencias entre dos cuentas.
     *
     * @param primera Código válido de cuenta
     * @param segunda Código válido de cuenta
     * @return Lista de transferencias. El código <i> primera</i> siempre aparecerá como cuenta de origen de cada
     * transferencia. En caso de el código de cuenta sea el mismo la lista estará vacía.
     * @throws <i>IllegalArgumentExcpetion</i> si alguno de los códigos de cuenta no son válidos.
     */
    public List<Transferencia> historico(String primera, String segunda) {
        // TODO Metodo por implementar
        if (primera == null || segunda == null || cuentas.get(primera) == null || cuentas.get(segunda) == null)
            throw new IllegalArgumentException();
        List<Transferencia> devolver = new LinkedList<>();
        List<Transferencia> listaA = desglose.get(primera);
        List<Transferencia> listaB = desglose.get(segunda);
        if (!primera.equals(segunda))
            for (Transferencia tr : listaA) {

                if (listaB.contains(tr)) {
                    if (tr.origen.equals(primera))
                        devolver.add(tr);
                    else {
                        tr.invertir();
                        devolver.add(tr);

                    }
                }
            }

        return devolver;
    }

    public String toString() {
        StringBuilder bf = new StringBuilder("Banco - cuentas {\n");

        for (String cod : cuentas.keySet())
            bf.append("  " + cod + ": " + cuentas.get(cod) + "\n");


        bf.append("} - size:" + cuentas.size());

        return bf.toString();
    }

    public String toStringDesglose() {
        StringBuilder bf = new StringBuilder("Banco - desglose {\n");

        for (String cod : desglose.keySet())
            bf.append("  " + cod + ": " + desglose.get(cod));


        bf.append("}");
        return bf.toString();
    }

}
