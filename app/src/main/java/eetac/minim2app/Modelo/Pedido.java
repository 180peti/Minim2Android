package eetac.minim2app.Modelo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Alex Aguilera on 18/12/2017.
 */

public class Pedido implements Serializable{

    @SerializedName("productos")
    private List<Producto> productos;
    @SerializedName("cantidades")
    private HashMap<String, Integer> cantidades;
    @SerializedName("usuario")
    private String usuario;

    public Pedido(String usuario) {
        this.usuario = usuario;
        this.productos = new ArrayList<Producto>();
        this.cantidades = new HashMap<String, Integer>();

    }


    public void añadirProducto(Producto pr, int cantidad) {
        if (productos.contains(pr)) {
            cantidades.put(pr.getNombre(), cantidades.get(pr.getNombre()) + cantidad);
        } else {
            productos.add(pr);
            cantidades.put(pr.getNombre(), cantidad);
        }
    }

    //GETTERS Y SETTERS


    public List<Producto> getProductos() {
        return productos;
    }

    public HashMap<String, Integer> getCantidades() {
        return cantidades;
    }

    public String getUsuario() {
        return usuario;
    }
}
