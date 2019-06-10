package examens.ex_ene19;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Despensa {
    private HashMap<String, Integer> almacen;

    public Despensa() {
        almacen = new HashMap<>();
    }

    public void reponer(Collection<String> cesta) {

        if (cesta == null) return;

        for (String aliment : cesta) {
            if (almacen.containsKey(aliment)) {
                int tam = almacen.get(aliment);
                almacen.put(aliment, tam + 1);
            } else {
                almacen.put(aliment, 1);
            }
        }

    }

    public Collection<String> buscar(Collection<String> pedido) {
        HashMap<String, Integer> datos = new HashMap<>();
        HashMap<String, Integer> devolver = new HashMap<>();


        for (String producto : pedido) {
            Integer cant = datos.get(producto);
            if (cant == null)
                datos.put(producto, 1);
            else datos.put(producto, cant + 1);

        }

        for (String producto : datos.keySet()) {
            Integer c1 = almacen.get(producto);
            Integer c2 = datos.get(producto);

            if (c1 == null) {
                devolver.put(producto, c2);

            } else if (c1 < c2) {
                devolver.put(producto, c2 - c1);

            }

        }

        List<String> res = new LinkedList<>();
        for (String producto : devolver.keySet()) {
            for (int i = 0; i < devolver.get(producto); i++) {
                res.add(producto);
            }
        }

        return res;
    }

    public boolean servir(Collection<String> pedido) {
        List<String> faltan = (List<String>) buscar(pedido);
        if (!faltan.isEmpty()) return false;

        for (String alimento : pedido) {
            int cant = almacen.get(alimento);
            almacen.put(alimento, cant - 1);
        }

        return true;

    }

    public  String toString (){
        String devolver="";
        for (String producto : almacen.keySet()) {
        devolver+=("Producto: "+producto+" cantidad: "+almacen.get(producto)+"\n");
        }
        return devolver;
    }
    public static void main(String[] args) {
        Despensa despensa = new Despensa();
        List<String> alimentos = new LinkedList<>();

        alimentos.add("Tomate");
        alimentos.add("Queso");
        alimentos.add("Tomate");
        alimentos.add("Cebolla");
        alimentos.add("Huevos");
        alimentos.add("Tomate");
        alimentos.add("Queso");
        alimentos.add("Tomate");
        alimentos.add("Cebolla");
        alimentos.add("Huevos");
        alimentos.add("Tomate");
        alimentos.add("Queso");
        alimentos.add("Tomate");
        alimentos.add("Cebolla");
        alimentos.add("Huevos");

        despensa.reponer(alimentos);
        System.out.printf(despensa.toString());

    }

}
